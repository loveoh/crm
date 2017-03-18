package com.kaishengit.dto;

/**
 * Created by 刘忠伟 on 2017/3/18.
 */
public class AjaxResult {

    public static final String SUCCESS = "success";
    public static final String ERROR = "error";

    private String status;
    private String message;
    private Object data;

    public AjaxResult(){}

    public AjaxResult(String message){
        this.status = ERROR;
        this.message = message;
    }


    //字符串是默认调用字符串的构造
    public AjaxResult(Object data){
        this.status = SUCCESS;
        this.data = data;
    }

    public AjaxResult(String status, Object data){
        this.status = status;
        this.data = data;
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
