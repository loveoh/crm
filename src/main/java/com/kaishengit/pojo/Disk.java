package com.kaishengit.pojo;

import java.io.Serializable;

/**
 * Created by 刘忠伟 on 2017/3/23.
 */
public class Disk implements Serializable{


    public static final String TYPE_FILE =  "file";//文件
    public static final String TYPE_FOLDER =  "folder";//文件夹

    private Integer id;
    private String sourceName;
    private String newName;
    private String size;
    private Integer fid;
    private String createTime;
    private String createUser;
    private String type;

    public static String getTypeFile() {
        return TYPE_FILE;
    }

    public static String getTypeFolder() {
        return TYPE_FOLDER;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getSourceName() {
        return sourceName;
    }

    public void setSourceName(String sourceName) {
        this.sourceName = sourceName;
    }

    public String getNewName() {
        return newName;
    }

    public void setNewName(String newName) {
        this.newName = newName;
    }

    public String getSize() {
        return size;
    }

    public void setSize(String size) {
        this.size = size;
    }

    public Integer getFid() {
        return fid;
    }

    public void setFid(Integer fid) {
        this.fid = fid;
    }

    public String getCreateTime() {
        return createTime;
    }

    public void setCreateTime(String createTime) {
        this.createTime = createTime;
    }

    public String getCreateUser() {
        return createUser;
    }

    public void setCreateUser(String createUser) {
        this.createUser = createUser;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }
}
