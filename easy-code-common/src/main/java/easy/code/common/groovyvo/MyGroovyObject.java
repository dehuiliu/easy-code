package easy.code.common.groovyvo;

import easy.code.common.vo.RuleParam;
import easy.code.common.vo.RuleResult;
import groovy.lang.GroovyObject;

import java.io.Serializable;

/**
 * 编译后的规则对象
 * --todo 换成序列化 groovyObject 不确定是否有问题
 */
public class MyGroovyObject implements Serializable {
    /**
     * 规则编译对象
     */
    private GroovyObject groovyObject;

    public MyGroovyObject(GroovyObject groovyObject) {
        this.groovyObject = groovyObject;
    }

    public GroovyObject getGroovyObject() {
        return groovyObject;
    }

    /**
     * 执行规则
     *
     * @param ruleParam 规则参数
     * @return 规则执行结果
     */
    public RuleResult execute(RuleParam ruleParam) {
        Object executeResult = getGroovyObject().
                invokeMethod(ruleParam.getExeMethod(), ruleParam.getParam());
        return new RuleResult(executeResult);
    }
}
