package com.zjf.demo.utils;

public class AjaxResult {
    private String status;
    private String message;
    private Object data;

    public AjaxResult() {
    }

    public AjaxResult(Object data) {
        this.status = "0";
        this.message = "success";
        this.data = data;
    }

    public AjaxResult(String status, Object data) {
        this.status = status;
        this.message = "error";
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
