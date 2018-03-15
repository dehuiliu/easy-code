package easy.code.common.exception;

public class ErrorMessage {
    /**
     * 错误码
     */
    private ErrorCode errorCode;
    /**
     * 错误信息
     */
    private String note;

    public ErrorMessage(ErrorCode errorCode, String note) {
        this.errorCode = errorCode;
        this.note = note;
    }

    public ErrorCode getErrorCode() {
        return errorCode;
    }

    public String getNote() {
        return note;
    }
}
