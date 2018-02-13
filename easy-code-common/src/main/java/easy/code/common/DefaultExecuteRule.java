package easy.code.common;

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
