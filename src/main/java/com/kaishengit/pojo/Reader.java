package com.kaishengit.pojo;

import java.io.Serializable;

/**
 * Created by loveoh on 2017/3/18.
 */
public class Reader implements Serializable {

    private Integer id;
    private String readerName;
    private String readerTime;
    private Integer noticeid;
    private Integer userid;

    public Integer getUserid() {
        return userid;
    }

    public void setUserid(Integer userid) {
        this.userid = userid;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getReaderName() {
        return readerName;
    }

    public void setReaderName(String readerName) {
        this.readerName = readerName;
    }

    public String getReaderTime() {
        return readerTime;
    }

    public void setReaderTime(String readerTime) {
        this.readerTime = readerTime;
    }

    public Integer getNoticeid() {
        return noticeid;
    }

    public void setNoticeid(Integer noticeid) {
        this.noticeid = noticeid;
    }
}
