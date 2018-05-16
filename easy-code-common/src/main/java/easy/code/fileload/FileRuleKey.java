package easy.code.fileload;

import easy.code.common.IRuleKey;
import easy.code.common.ISourceLoad;
import easy.code.common.RuleType;

public class FileRuleKey implements IRuleKey {
    /**
     * 文件规则路径
     */
    private String rulePath;
    /**
     * class/script
     */
    private RuleType ruleType;

    public FileRuleKey(String rulePath) {
        this.rulePath = rulePath + ".groovy";

        this.ruleType = RuleType.CLASS;
    }

    public String getRulePath() {
        return rulePath;
    }

    @Override
    public IRuleKey createKey(String ruleKey) {
        return new FileRuleKey(ruleKey);
    }

    @Override
    public ISourceLoad sourceLoad() {
        return new FileSourceLoad();
    }

    public FileRuleKey getRuleKey() {
        return this;
    }

    @Override
    public String toString() {
        return "{" +
                "rulePath='" + rulePath + '\'' +
                ", ruleType=" + ruleType +
                '}';
    }

}
