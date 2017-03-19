package com.kaishengit.controller;

import com.google.common.collect.Maps;
import com.kaishengit.dto.AjaxResult;
import com.kaishengit.dto.DataTablesResult;
import com.kaishengit.pojo.Notice;
import com.kaishengit.pojo.Reader;
import com.kaishengit.pojo.User;
import com.kaishengit.service.NoticeService;
import com.kaishengit.service.ReaderService;
import com.kaishengit.shiro.ShiroUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import java.io.IOException;
import java.util.List;
import java.util.Map;

/**
 * Created by loveoh on 2017/3/18.
 */
@Controller
@RequestMapping("/notice")
public class NoticeController {

    @Autowired
    private NoticeService noticeService;
    @Autowired
    private ReaderService readerService;

   @GetMapping
    public String notice (){
        return "notice/list";
    }

    /**
     * dataTables 显示公告数据
     * @param request
     * @return
     */
    @RequestMapping(value ="/list/load",method = RequestMethod.GET )
    @ResponseBody
    public DataTablesResult<Notice> load(HttpServletRequest request){
        String draw = request.getParameter("draw");
        String start = request.getParameter("start");
        String length = request.getParameter("length");

        List<Notice> noticeList = noticeService.findNoticeByQueryParam(start,length);
        Long count = noticeService.count();

        return new  DataTablesResult<Notice>(draw,noticeList,count,count);
    }

    /**
     * 查看公告详情信息
     * @param id
     * @param model
     * @return
     */
    @RequestMapping(value = "/detail/{id:\\d+}")
    public String noticeDetail(@PathVariable Integer id , Model model){
        Notice notice = noticeService.findNoticeByNoticeId(id);
        //先查出哪个用户看过公告
        List<Reader> readerList = readerService.findByNoticeId(id);

        //记录看过公告的每一个用户
        Reader reader = new Reader();
        User user =  ShiroUtil.getCurrentUser();

        reader.setNoticeid(id);
        reader.setReaderName(user.getUsename());
        reader.setUserid(user.getId());

        readerService.save(reader);
        model.addAttribute("notice",notice);
        model.addAttribute("readerList",readerList);
        return "notice/view";
    }

    /**
     * 跳转到发布通告页面
     * @return
     */
    @RequestMapping(value = "/new",method = RequestMethod.GET)
    public String newNotice(){
        return "notice/new";
    }

    /**
     * 发表公告
     * @return
     */
    @RequestMapping(value = "/new",method = RequestMethod.POST)
    @ResponseBody
    public AjaxResult addNotice (Notice notice){

        noticeService.save(notice);

        return new AjaxResult(AjaxResult.SUCCESS);
    }

    /**
     * 在线编辑器上传文件
     * @param file
     * @return
     */
    @RequestMapping(value = "/img/upload",method = RequestMethod.POST)
    @ResponseBody
    public Map<String,Object> imgUpload(MultipartFile file) throws IOException {
        Map<String,Object> result = Maps.newHashMap();
        if (!file.isEmpty()){

            //获取上传后文件的路径
            String path = noticeService.saveImage(file.getInputStream(),file.getOriginalFilename());
            result.put("success",true);
            result.put("file_path", path);

        }else {
            result.put("success",false);
            result.put("msg","请选择上传图片");
        }
        return result;
    }

}
