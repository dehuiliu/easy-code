package easy.code.common.vo;

/**
 * 规则的执行结果
 */
public class RuleResult {
    /**
     * 规则返回结果
     */
    private Object executeResult;

    public RuleResult(Object executeResult) {
        this.executeResult = executeResult;
    }

    public Object getExecuteResult() {
        return executeResult;
    }
}
