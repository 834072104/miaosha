package com.mon.miaosha.result;


public class Result<T> {
    private int code;
    private String msg;
    private T data;

    private Result(T data) {   //将成功时调用的构造方法设为private,使得只能在使用success方法时调用
        this.code=0;
        this.msg="success";
        this.data = data;
    }

    private Result(CodeMsg cm) {   //将成功时调用的构造方法设为private,使得只能在使用error方法时调用
        if(cm!=null){
        this.code=cm.getCode();
        this.msg=cm.getMsg();
        }else
            return;
    }
    /*
    *成功时候得调用
    * */
   public static<T> Result<T> success(T data){
       return new Result<T>(data);

   }
    /*
    *失败时候得调用
    * */
   public static<T> Result<T> error(CodeMsg cm){
       return new Result<T>(cm);
   }



    //
//    private  Result(T data) {
//        this.code = 0;
//        this.msg = "success";
//        this.data = data;
//    }
//
//    private  Result(Integer code,String msg,T data) {
//        this.code = code;
//        this.msg = msg;
//        this.data = data;
//    }

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }
}
