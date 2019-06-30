package com.jlkf.donglianrider.mvpprojectdemo.base;

import java.io.Serializable;

/**
 * Created by win7 on 2019/6/6.
 */

public class BaseBean<T> implements Serializable {


    /**
     * data : null
     * code : 500
     * msg : null
     * totalPage : null
     * totalRecord : null
     * pageNo : null
     * ltype : null
     */

    private T data;
    private int code;
    private Object msg;
    private Object totalPage;
    private Object totalRecord;
    private Object pageNo;
    private Object ltype;

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public Object getMsg() {
        return msg;
    }

    public void setMsg(Object msg) {
        this.msg = msg;
    }

    public Object getTotalPage() {
        return totalPage;
    }

    public void setTotalPage(Object totalPage) {
        this.totalPage = totalPage;
    }

    public Object getTotalRecord() {
        return totalRecord;
    }

    public void setTotalRecord(Object totalRecord) {
        this.totalRecord = totalRecord;
    }

    public Object getPageNo() {
        return pageNo;
    }

    public void setPageNo(Object pageNo) {
        this.pageNo = pageNo;
    }

    public Object getLtype() {
        return ltype;
    }

    public void setLtype(Object ltype) {
        this.ltype = ltype;
    }
}
