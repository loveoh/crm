package com.kaishengit.pojo;

import java.io.Serializable;

/**
 * Created by loveoh on 2017/3/18.
 */
public class LoginLog implements Serializable{

    private Integer id;
    private String ip;
    private String createTime;
    private Integer userid;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getIp() {
        return ip;
    }

    public void setIp(String ip) {
        this.ip = ip;
    }

    public String getCreateTime() {
        return createTime;
    }

    public void setCreateTime(String createTime) {
        this.createTime = createTime;
    }

    public Integer getUserid() {
        return userid;
    }

    public void setUserid(Integer userid) {
        this.userid = userid;
    }
}
