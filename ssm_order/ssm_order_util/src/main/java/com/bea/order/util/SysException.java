package com.bea.order.util;

/**
 * Created by fandi on 2020/4/5 0005.
 */
public class SysException  extends Exception{
    private String msg;

    public SysException(String msg) {
        this.msg = msg;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }
}
