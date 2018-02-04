package easy.code.fileload;

import easy.code.common.IRuleKey;
import easy.code.common.ISourceLoad;

/**
 * 文件类型获取方式
 */
public class FileSourceLoad implements ISourceLoad {

    @Override
    public FileRuleInfo getRuleSource(IRuleKey ruleKey) {
        FileRuleKey fileFileRuleKey = (FileRuleKey) ruleKey;

        return null;
    }
}
