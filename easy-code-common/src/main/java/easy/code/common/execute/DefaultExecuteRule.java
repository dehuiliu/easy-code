package easy.code.common.execute;

import easy.code.common.IRuleKey;
import easy.code.common.IRuleSource;
import easy.code.common.ISourceLoad;
import easy.code.common.RuleType;
import easy.code.common.groovyvo.MyGroovyObject;
import easy.code.common.vo.RuleParam;

public class DefaultExecuteRule extends AbstractExecuteRule {


    public DefaultExecuteRule(ISourceLoad sourceLoad, IRuleKey ruleKey) {
        super(sourceLoad, ruleKey);
    }

    public DefaultExecuteRule(IRuleKey ruleKey) {
        this(ruleKey.sourceLoad(), ruleKey);
    }

    @Override
    public Object getResult(RuleParam ruleParam) {
        //根据 ruleKey 从缓存加载  myGroovyObject
        MyGroovyObject myGroovyObject = getCache(ruleKey);
        if (myGroovyObject == null) {
            //加载规则信息

            IRuleSource ruleSource = sourceLoad.getRuleSource(ruleKey);
            myGroovyObject = RuleType.parseRule(ruleSource);
            //存入缓存信息

        }
        if (ruleParam.isEmptyMethod()) {
            String executeMethod = ruleParam.getExeMethod();
            ruleParam.setExeMethod(executeMethod);
        }

        //返回执行结果
        return myGroovyObject.execute(ruleParam);
    }

    /**
     * todo 缓存信息
     *
     * @param ruleKey
     * @return
     */
    private MyGroovyObject getCache(IRuleKey ruleKey) {


        return null;
    }
}
