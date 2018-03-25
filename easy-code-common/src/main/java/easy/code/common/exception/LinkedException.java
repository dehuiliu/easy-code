package easy.code.common.exception;

import java.util.ArrayList;
import java.util.List;

public class LinkedException extends RuntimeException {
    /**
     * 规则异常调用链路
     */
    private List<EasyCodeException> linkedException = new ArrayList<>();

    public LinkedException(Throwable cause) {
        super(cause);
    }

    public LinkedException addEasyException(EasyCodeException e) {
        linkedException.add(e);
        return this;
    }

    public LinkedException addLinkedException(LinkedException e) {
        linkedException.addAll(e.linkedException);
        return this;
    }
}
