package easy.code.common;

public class RuleKey implements IRuleKey {

    protected String code;
    /**
     * default class
     */
    protected RuleType ruleType;

    public RuleKey(String code) {
        this.code = code;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public void setRuleType(RuleType ruleType) {
        this.ruleType = ruleType;
    }

    @Override
    public RuleType getRuleType() {
        return ruleType == null ? RuleType.CLASS : ruleType;
    }
}
