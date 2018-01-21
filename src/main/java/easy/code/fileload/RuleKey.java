package easy.code.fileload;

import easy.code.common.IRuleKey;
import easy.code.common.RuleType;

public class RuleKey implements IRuleKey<RuleKey> {
    /**
     * 文件规则路径
     */
    String rulePath;
    /**
     * 规则文本类型
     */
    RuleType ruleType;

    public RuleKey(String rulePath, RuleType ruleType) {
        this.rulePath = rulePath;
        this.ruleType = ruleType;
    }

    public RuleType getRuleType() {
        return this.ruleType;
    }

    public RuleKey getRuleKey() {
        return this;
    }
}
