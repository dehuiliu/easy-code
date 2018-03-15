package easy.code.common.exception;

public class EasyCodeException extends RuntimeException {
    /**
     * 异常错误信息集合
     */
    private ErrorMessage errorMessage;

    public ErrorMessage getErrorMessage() {
        return errorMessage;
    }
}
