package easy.code.common.util;

import easy.code.common.IRuleKey;
import easy.code.common.vo.RuleParam;
import easy.code.fileload.FileRuleKey;
import org.junit.Test;

public class RuleUtilsTest {
    @Test
    public void executeRule() {
        String rulePath = "test";
        IRuleKey ruleKey = new FileRuleKey(rulePath);
        RuleParam ruleParam = new RuleParam();
        try {

            RuleUtils.executeRule(ruleKey, ruleParam);
        } catch (Exception e) {
            throw  e;
        }
    }

    @Test
    public void executeRule1() {
        try {
            int i = 1 / 0;
        } catch (Exception e) {
            if (true) {

                throw new RuntimeException("-----",e);
            }
        }

    }
}