package easy.code.fileload;

import easy.code.common.IRuleKey;
import easy.code.common.IRuleSource;
import easy.code.common.groovyvo.EasyCodeCompilerConfiguration;

import java.util.Map;

/**
 * 文件的规则信息
 */
public class RuleInfo implements IRuleSource {
    /**
     * 规则的唯一标示
     */
    private RuleKey ruleKey;
    /**
     * 规则文本
     */
    private String ruleText;

    public RuleInfo(RuleKey ruleKey) {
        this.ruleKey = ruleKey;
        //加载规则文本

    }

    /**
     * 获取规则key
     *
     * @return
     */
    public IRuleKey getKey() {
        return this.ruleKey;
    }

    @Override
    public String getSourceString() {
        return this.ruleText;
    }

    @Override
    public EasyCodeCompilerConfiguration getDefaultCompilerConfig() {
        return null;
    }

    @Override
    public Map<String, Object> getDefaultParamMap() {
        return null;
    }

}
