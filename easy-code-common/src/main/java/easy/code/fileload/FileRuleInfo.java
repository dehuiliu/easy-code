package easy.code.fileload;

import easy.code.common.IRuleSource;
import easy.code.common.groovyvo.EasyCodeCompilerConfiguration;

import java.util.HashMap;
import java.util.Map;

/**
 * 文件的规则信息
 */
public class FileRuleInfo implements IRuleSource {
    /**
     * 规则的唯一标示
     */
    private FileRuleKey fileRuleKey;
    /**
     * 规则文本
     */
    private String ruleText;

    public FileRuleInfo(FileRuleKey fileRuleKey) {
        this.fileRuleKey = fileRuleKey;
    }

    /**
     * 获取规则key
     *
     * @return
     */
    public FileRuleKey getKey() {
        return this.fileRuleKey;
    }

    @Override
    public String getSourceString() {
        return this.ruleText;
    }

    public void setRuleText(String ruleText) {
        this.ruleText = ruleText;
    }

    @Override
    public EasyCodeCompilerConfiguration getDefaultCompilerConfig() {
        return null;
    }

    @Override
    public Map<String, Object> getDefaultParamMap() {
        HashMap<String, Object> paramMap = new HashMap<>();
        paramMap.put(_PROPERTY_RULE_KEY, fileRuleKey);
        paramMap.put(_PROPERTY_METHOD_NAME_KEY, "entryMethod");
        return paramMap;
    }

}
