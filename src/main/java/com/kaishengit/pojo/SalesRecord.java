package com.kaishengit.pojo;

import java.io.Serializable;
import java.sql.Timestamp;

/**
 * Created by loveoh on 2017/3/22.
 */
public class SalesRecord implements Serializable {

    public static final String TYPE_AUTO = "auto";
    public static final String TYPE_INPUT = "input";


    private Integer id;
    private String content;
    private Timestamp createTime;
    private Integer salesid;
    private String type;

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public Timestamp getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Timestamp createTime) {
        this.createTime = createTime;
    }

    public Integer getSalesid() {
        return salesid;
    }

    public void setSalesid(Integer salesid) {
        this.salesid = salesid;
    }
}
