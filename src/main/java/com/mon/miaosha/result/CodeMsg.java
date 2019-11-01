package com.mon.miaosha.result;

public class CodeMsg {

    private Integer code;
    private String msg;

    //通用异常
    public static CodeMsg success=new CodeMsg(0,"success");
    public static CodeMsg server_error=new CodeMsg(500,"server_error");

    private CodeMsg(Integer code, String msg) {
        this.code = code;
        this.msg = msg;
    }

    public Integer getCode() {
        return code;
    }

    public void setCode(Integer code) {
        this.code = code;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }
}
