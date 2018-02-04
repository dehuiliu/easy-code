package easy.code.common;

import org.junit.Test;

public class RuleUtilsTest {

    @Test
    public void executeRule() {
        RuleParam ruleParam = new RuleParam();
        RuleUtils.executeRule(new RuleKey("test"), ruleParam);
    }
}