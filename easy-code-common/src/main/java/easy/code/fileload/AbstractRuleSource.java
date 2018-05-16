package easy.code.fileload;

import easy.code.common.IRuleKey;
import easy.code.common.IRuleSource;

import java.util.HashMap;
import java.util.Map;

public abstract class AbstractRuleSource implements IRuleSource{

    private IRuleKey ruleKey;

    private String ruleText;

    public AbstractRuleSource(IRuleKey ruleKey,String ruleText) {
        this.ruleKey = ruleKey;
        this.ruleText = ruleText;
    }
    @Override
    public IRuleKey getKey() {
        return ruleKey;
    }

    public String getSourceString() {
        return ruleText;
    }

    public void setRuleText(String ruleText) {
        this.ruleText = ruleText;
    }


    @Override
    public Map<String, Object> getDefaultParamMap() {
        HashMap<String, Object> paramMap = new HashMap<>();
        paramMap.put(_PROPERTY_RULE_KEY, ruleKey);
        paramMap.put(_PROPERTY_METHOD_NAME_KEY, "entryMethod");
        return paramMap;
    }
}
