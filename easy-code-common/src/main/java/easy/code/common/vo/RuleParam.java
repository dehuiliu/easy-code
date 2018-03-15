package easy.code.common.vo;

/**
 * 规则的执行参数
 */
public class RuleParam {
    /**
     * 默认执行方法名称
     */
    private static final String DEFAULT_METHOD = "entry";
    /**
     * 执行参数，必须存在
     */
    private Object param;
    /**
     * 执行方法
     */
    private String exeMethod;

    public RuleParam() {

    }

    public void setExeMethod(String exeMethod) {
        this.exeMethod = exeMethod;
    }

    public void setParam(Object param) {
        this.param = param;
    }

    public Object[] getParam() {
        return param == null ? new Object[]{} : (Object[]) param;
    }

    public String getExeMethod() {

        return exeMethod == null || "".equals(exeMethod) ? DEFAULT_METHOD : exeMethod;
    }
}
