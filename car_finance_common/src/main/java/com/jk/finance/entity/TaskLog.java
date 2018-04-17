package com.jk.finance.entity;

import java.io.Serializable;

/**
 * Created by Administrator on 2018/4/13.
 */
public class TaskLog implements Serializable {

    private static final long serialVersionUID = -6082802158357091206L;
    private String URL;
    private String HTTP_METHOD;
    private String IP;
    private String ARGS;
    private String CLASS_METHOD;
    private String createTime;

    public String getURL() {
        return URL;
    }

    public void setURL(String URL) {
        this.URL = URL;
    }

    public String getHTTP_METHOD() {
        return HTTP_METHOD;
    }

    public void setHTTP_METHOD(String HTTP_METHOD) {
        this.HTTP_METHOD = HTTP_METHOD;
    }

    public String getIP() {
        return IP;
    }

    public void setIP(String IP) {
        this.IP = IP;
    }

    public String getARGS() {
        return ARGS;
    }

    public void setARGS(String ARGS) {
        this.ARGS = ARGS;
    }

    public String getCLASS_METHOD() {
        return CLASS_METHOD;
    }

    public void setCLASS_METHOD(String CLASS_METHOD) {
        this.CLASS_METHOD = CLASS_METHOD;
    }

    public String getCreateTime() {
        return createTime;
    }

    public void setCreateTime(String createTime) {
        this.createTime = createTime;
    }

    @Override
    public String toString() {
        return "TaskLog{" +
                "URL='" + URL + '\'' +
                ", HTTP_METHOD='" + HTTP_METHOD + '\'' +
                ", IP='" + IP + '\'' +
                ", ARGS='" + ARGS + '\'' +
                ", CLASS_METHOD='" + CLASS_METHOD + '\'' +
                ", createTime='" + createTime + '\'' +
                '}';
    }
}
