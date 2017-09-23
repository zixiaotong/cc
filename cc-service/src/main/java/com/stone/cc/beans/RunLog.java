package com.stone.cc.beans;

import java.io.Serializable;
import java.util.Date;

import org.springframework.stereotype.Component;

/**
 * @author shanglei
 * @date 2017/7/26.
 */
@Component("runlog")
public class RunLog implements Serializable {
    private static final long serialVersionUID = 3902700044798592248L;

    private int id;
    private Date createdate;
    private String app;
    private String serverip;
    private String log;
    private String deployid;

    public int getId() {
        return this.id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Date getCreatedate() {
        return this.createdate;
    }

    public void setCreatedate(Date createdate) {
        this.createdate = createdate;
    }

    public String getApp() {
        return this.app;
    }

    public void setApp(String app) {
        this.app = app;
    }

    public String getServerip() {
        return this.serverip;
    }

    public void setServerip(String serverip) {
        this.serverip = serverip;
    }

    public String getLog() {
        return this.log;
    }

    public void setLog(String log) {
        this.log = log;
    }

    public String getDeployid() {
        return this.deployid;
    }

    public void setDeployid(String deployid) {
        this.deployid = deployid;
    }

    @Override
    public String toString() {
        return "RunLog{" +
            "id=" + id +
            ", createdate=" + createdate +
            ", app='" + app + '\'' +
            ", serverip='" + serverip + '\'' +
            ", log='" + log + '\'' +
            ", deployid=" + deployid +
            '}';
    }
}
