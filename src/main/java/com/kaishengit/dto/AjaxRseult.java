package com.kaishengit.dto;

/**
 * Created by loveoh on 2017/3/18.
 */
public class AjaxRseult {

    public static final String SUCCESS = "success";
    public static final String ERROR = "error";

    private String status;
    private String message;
    private Object data;

    public AjaxRseult(Object data) {
        this.status = SUCCESS;
        this.data = data;
    }


    public AjaxRseult(String status, String message) {
        this.status = status;
        this.message = message;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public Object getData() {
        return data;
    }

    public void setData(Object data) {
        this.data = data;
    }
}
