package com.stone.cc.beans;

import java.io.Serializable;
import java.util.Date;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import org.springframework.stereotype.Component;

/**
 * @author shanglei
 * @date 2017/7/26.
 */
@Component("runlog")
@Getter
@Setter
@ToString
public class RunLog implements Serializable {
    private static final long serialVersionUID = 3902700044798592248L;

    private int id;
    private Date createdate;
    private String app;
    private String serverip;
    private String log;
    private String deployid;

}
