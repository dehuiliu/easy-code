package easy.code.fileload;

import easy.code.common.IRuleKey;
import easy.code.common.RuleType;
import easy.code.common.execute.ExecuteType;

public class FileRuleKey implements IRuleKey {
    /**
     * 文件规则路径
     */
    String rulePath;
    /**
     * class/script
     */
    RuleType ruleType;

    public FileRuleKey(String rulePath) {
        this.rulePath = rulePath + ".groovy";

        this.ruleType = RuleType.CLASS;
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
}
