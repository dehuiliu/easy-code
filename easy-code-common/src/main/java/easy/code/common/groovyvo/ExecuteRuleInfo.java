package easy.code.common.groovyvo;

import easy.code.common.IRuleKey;

import java.util.ArrayList;
import java.util.List;

/**
 * 执行的规则对象
 */
public class ExecuteRuleInfo {
    /**
     * 执行序号
     */
    private int index;
    /**
     * 当前节点的规则key
     */
    private IRuleKey ruleKey;
    /**
     * 执行规则对象
     */
    private Object ruleObject;
    /**
     * 方法名称
     */
    private String method;
    /**
     * 入参信息
     */
    private Object inputParam;
    /**
     * 出参信息
     */
    private Object outPutParam;
    /**
     * 是否出错
     */
    private boolean isError;
    /**
     * 异常信息
     */
    private Throwable throwable;

    /**
     * 上级结构信息
     */
    private ExecuteRuleInfo upExecuteRuleInfo;
    /**
     * 所有下级
     */
    private List<ExecuteRuleInfo> subExecuteRuleInfo;

    public ExecuteRuleInfo() {
        subExecuteRuleInfo = new ArrayList<>();
    }

    public ExecuteRuleInfo(IRuleKey ruleKey) {
        this();
        this.ruleKey = ruleKey;
    }

    public IRuleKey getRuleKey() {
        return ruleKey;
    }

    public void setRuleKey(IRuleKey ruleKey) {
        this.ruleKey = ruleKey;
    }

    public Object getInputParam() {
        return inputParam;
    }

    public void setInputParam(Object inputParam) {
        this.inputParam = inputParam;
    }

    public Object getOutPutParam() {
        return outPutParam;
    }

    public void setOutPutParam(Object outPutParam) {
        this.outPutParam = outPutParam;
    }

    public boolean isError() {
        return isError;
    }

    public void setError(boolean error) {
        isError = error;
    }

    public Throwable getThrowable() {
        return throwable;
    }

    public ExecuteRuleInfo getUpExecuteRuleInfo() {
        return upExecuteRuleInfo;
    }

    public int getIndex() {
        return index;
    }

    public void setIndex(int index) {
        this.index = index;
    }

    public Object getRuleObject() {
        return ruleObject;
    }

    public void setRuleObject(Object ruleObject) {
        this.ruleObject = ruleObject;
    }

    public void setUpExecuteRuleInfo(ExecuteRuleInfo upExecuteRuleInfo) {
        this.upExecuteRuleInfo = upExecuteRuleInfo;
    }

    public void setThrowable(Throwable throwable) {
        this.throwable = throwable;
    }

    public void addNextExecuteRuleInfo(ExecuteRuleInfo subRuleInfo) {
        //添加到后面
        this.subExecuteRuleInfo.add(subRuleInfo);
        //设置 所有子的 上节点
        subRuleInfo.setUpExecuteRuleInfo(this);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        ExecuteRuleInfo that = (ExecuteRuleInfo) o;

        if (index != that.index) return false;
        return ruleKey.equals(that.ruleKey);
    }

    @Override
    public int hashCode() {
        int result = index;
        result = 31 * result + ruleKey.hashCode();
        return result;
    }

    @Override
    public String toString() {
        return "{" +
                "index=" + index +
                ", ruleKey=" + ruleKey +
                '}';
    }

    public void setMethod(String method) {
        this.method = method;
    }
}
