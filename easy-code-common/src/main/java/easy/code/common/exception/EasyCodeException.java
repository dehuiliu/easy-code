package easy.code.common.exception;

import java.util.ArrayList;
import java.util.List;

public class EasyCodeException extends RuntimeException {
    /**
     * 异常错误信息集合
     */
    private ErrorMessage errorMessage;
    /**
     * 规则异常调用链路
     */
    private List<EasyCodeException> linkedException;


    public ErrorMessage getErrorMessage() {
        return errorMessage;
    }

    public static EasyCodeException asException(ErrorMessage errorMessage, Exception e) {
        EasyCodeException easyCodeException = new EasyCodeException();
        easyCodeException.errorMessage = errorMessage;
        easyCodeException.initCause(e);
        return easyCodeException;
    }

    /**
     * 添加当前异常信息到调用链路
     */
    public void addLinked() {
        if (linkedException == null) {
            this.linkedException = new ArrayList<>();
        }
        linkedException.add(this);
    }
}
