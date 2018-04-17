package com.jk.finance.entity;

import java.io.Serializable;

public class TaskLog implements Serializable {

    private static final long serialVersionUID = -8492907693449426753L;
    private String URL;
    private String HTTP_METHOD;
    private String IP;
    private String ARGS;
    private String CLASS_METHOD;
    private String createTime;

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

    public void setURL(String URL) {
        this.URL = URL;
    }

    public void setHTTP_METHOD(String HTTP_METHOD) {
        this.HTTP_METHOD = HTTP_METHOD;
    }

    public void setIP(String IP) {
        this.IP = IP;
    }

    public void setARGS(String ARGS) {
        this.ARGS = ARGS;
    }

    public void setCLASS_METHOD(String CLASS_METHOD) {
        this.CLASS_METHOD = CLASS_METHOD;
    }

    public void setCreateTime(String createTime) {
        this.createTime = createTime;
    }

    public String getURL() {
        return URL;
    }

    public String getHTTP_METHOD() {
        return HTTP_METHOD;
    }

    public String getIP() {
        return IP;
    }

    public String getARGS() {
        return ARGS;
    }

    public String getCLASS_METHOD() {
        return CLASS_METHOD;
    }

    public String getCreateTime() {
        return createTime;
    }
}