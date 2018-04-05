package com.bigdata.mr.flowanalysis;

/**
 * @author shanglei
 * @date 2018/4/5 15:57
 */
public class FlowBean {
    private long up_flow;
    private long d_flow;
    private long sum_flow;

    public void set(long up_flow, long d_flow) {
        this.up_flow = up_flow;
        this.d_flow = d_flow;
        this.sum_flow = up_flow + d_flow;

    }

    public long getUp_flow() {
        return this.up_flow;
    }

    public void setUp_flow(long up_flow) {
        this.up_flow = up_flow;
    }

    public long getD_flow() {
        return this.d_flow;
    }

    public void setD_flow(long d_flow) {
        this.d_flow = d_flow;
    }

    public long getSum_flow() {
        return this.sum_flow;
    }

    public void setSum_flow(long sum_flow) {
        this.sum_flow = sum_flow;
    }
}
