package easy.code.common.exception;

/**
 * 错误异常码
 */
public enum ErrorCode {

    FOUND_CODE_ERROR(1, "无该CODE对应内容"), DOING_ERROR(1, "规则运行异常");
    /**
     * 异常编码
     */
    private int code;
    /**
     * 异常描述
     */
    private String msg;

    ErrorCode(int code, String msg) {
        this.code = code;
        this.msg = msg;
    }

    public int getCode() {
        return code;
    }

    public String getMsg() {
        return msg;
    }
}
