package easy.code.common;

public class MyGroovyParse {
    private MyGroovyParse() {
    }

    public static MyGroovyObject parse(IRuleSource ruleSource) {
        RuleType ruleType = ruleSource.getKey().getRuleType();
        return ruleType.parse(ruleSource);
    }
}
