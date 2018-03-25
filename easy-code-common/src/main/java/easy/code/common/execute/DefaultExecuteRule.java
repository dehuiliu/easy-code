package easy.code.common.execute;

import easy.code.common.*;
import easy.code.common.groovyvo.MyGroovyObject;
import easy.code.common.vo.RuleParam;
import easy.code.common.vo.RuleResult;

public class DefaultExecuteRule extends AbstractExecuteRule {


    public DefaultExecuteRule(ISourceLoad sourceLoad) {
        super(sourceLoad);
    }

    @Override
    public RuleResult getResult(IRuleKey ruleKey, RuleParam ruleParam) {
        //根据 ruleKey 从缓存加载  myGroovyObject
        MyGroovyObject myGroovyObject = getCache(ruleKey);
        if (myGroovyObject == null) {
            //加载规则信息

            IRuleSource ruleSource = sourceLoad.getRuleSource(ruleKey);
            myGroovyObject = ruleKey.getRuleType().parse(ruleSource);
            //存入缓存信息

        }
        if (ruleParam.isEmptyMethod()) {
            String executeMethod = ruleKey.getExecuteMethod();
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
