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
        //加载规则文本

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

    @Override
    public EasyCodeCompilerConfiguration getDefaultCompilerConfig() {
        return null;
    }

    @Override
    public Map<String, Object> getDefaultParamMap() {
        return new HashMap<String, Object>();
    }

}
