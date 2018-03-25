package easy.code.common.util;

import easy.code.common.IRuleKey;
import easy.code.common.vo.RuleParam;
import easy.code.fileload.FileRuleKey;
import org.junit.Test;

public class RuleUtilsTest {
    @Test
    public void executeRule() throws Exception {
        String rulePath = "test";
        IRuleKey ruleKey = new FileRuleKey(rulePath);
        RuleParam ruleParam = new RuleParam();
        RuleUtils.executeRule(ruleKey, ruleParam);
    }

}