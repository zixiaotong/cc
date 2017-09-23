package cn.test;

/**
 * Created by shanglei on 2017/2/19.
 *
 * @author shanglei
 * @date 2017/02/19
 */
public enum RefundStatusEnum {


    ABC("1", "111"),
    ASD("22", "222");

    private String code;
    private String value;

    RefundStatusEnum(String code,String value) {
        this.value = value;
        this.code = code;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public void setValue(String value) {
        this.value = value;
    }

    public String getValue() {
        return value;
    }

    public static String getByValue(String code) {
        for (RefundStatusEnum refundstatus : values()) {
            if (refundstatus.getCode().equals(code)) {
                return refundstatus.getValue();
            }
        }
        return null;
    }

    public static void main(String[] args) {
        System.out.println(getByValue("29"));
    }
}
