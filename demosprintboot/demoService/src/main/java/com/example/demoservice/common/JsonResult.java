package com.example.demoservice.common;

public class JsonResult<T> {

    // code=200 ->成功
    // [].{}
    // code !=200 ->失败
    // msg="需要权限"

    private T data;
    private String code;
    private String msg;

    /**
     * 操作失败，没有取得数据，人为指定返回码，返回消息
     * @param code  返回码
     * @param msg   返回消息
     */
    public JsonResult(String code, String msg) {
        this.code = code;
        this.msg = msg;
    }

    /**
     * 没有数据，人为指定返回码，返回消息
     */
    public JsonResult() {
        this.code = "0";
        this.msg = "操作成功";
    }

    /**
     * 拿到数据，自动赋予返回码，返回消息
     * @param data 得到的数据
     */
    public JsonResult(T data) {
        this.data = data;
        this.code = "0";
        this.msg = "操作成功";
    }

    /**
     * 拿到数据，自动赋予返回码，人为赋予返回消息
     * @param data  得到的数据
     * @param msg   返回消息
     */
    public JsonResult(T data, String msg) {
        this.data = data;
        this.msg = msg;
    }

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }
}
