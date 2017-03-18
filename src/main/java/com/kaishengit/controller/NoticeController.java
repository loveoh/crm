package com.kaishengit.controller;

import com.kaishengit.dto.DataTablesResult;
import com.kaishengit.pojo.Notice;
import com.kaishengit.service.NoticeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

/**
 * Created by loveoh on 2017/3/18.
 */
@Controller
@RequestMapping("/notice")
public class NoticeController {

    @Autowired
    private NoticeService noticeService;

   @GetMapping
    public String notice (){
        return "notice/list";
    }

    @RequestMapping(value = "/list/load",method = RequestMethod.GET )
    public DataTablesResult<Notice> load(HttpServletRequest request){
        String draw = request.getParameter("draw");
        String start = request.getParameter("start");
        String length = request.getParameter("length");

        List<Notice> noticeList = noticeService.findNoticeByQueryParam(start,length);
        Long count = noticeService.count();

        return new  DataTablesResult<Notice>(draw,noticeList,count,count);

    }
}
