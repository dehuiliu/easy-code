package easy.code.fileload;

import easy.code.common.IRuleKey;
import easy.code.common.RuleType;
import easy.code.common.groovyvo.EasyCodeCompilerConfiguration;

/**
 * 文件的规则信息
 */
public class FileRuleSource extends AbstractRuleSource {

    public FileRuleSource(IRuleKey ruleKey, String ruleText) {
        super(ruleKey, ruleText);
    }

    @Override
    public RuleType getRuleType() {
        return RuleType.CLASS;
    }

    @Override
    public EasyCodeCompilerConfiguration getDefaultCompilerConfig() {
        return null;
    }


}
