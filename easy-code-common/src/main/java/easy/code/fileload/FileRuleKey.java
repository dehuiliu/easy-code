package easy.code.fileload;

import easy.code.common.IRuleKey;
import easy.code.common.RuleType;
import easy.code.common.execute.ExecuteType;

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

    public RuleType getRuleType() {
        return this.ruleType;
    }

    @Override
    public ExecuteType getExecuteType() {
        return ExecuteType.FILE;
    }

    @Override
    public String getExecuteMethod() {
        return "entryMethod";
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
