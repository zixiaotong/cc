package com.thread.wenhu;

import java.io.Serializable;

import lombok.Data;

/**
 * @author shanglei
 * @date 2017/11/10.
 */
@Data
public class OrderTest implements Serializable {

    private static final long serialVersionUID = -8034539838789093912L;
    private Long lId;
    private String strTaskName;
    private Integer nState;
    private String dtHandleTime;

}
