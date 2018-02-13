package easy.code.fileload;

import easy.code.common.IRuleKey;
import easy.code.common.RuleType;

public class FileRuleKey implements IRuleKey {
    /**
     * 文件规则路径
     */
    String rulePath;
    /**
     * class/script
     */
    RuleType ruleType;

    public FileRuleKey(String rulePath, RuleType ruleType) {
        this.rulePath = rulePath;
        this.ruleType = ruleType;
    }

    public RuleType getRuleType() {
        return this.ruleType;
    }

    public FileRuleKey getRuleKey() {
        return this;
    }
}
