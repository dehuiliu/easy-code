package easy.code.fileload;

import easy.code.common.IRuleKey;
import easy.code.common.ISourceLoad;
import easy.code.common.util.FileUtil;
import easy.code.common.util.StringUtil;

import java.io.File;

/**
 * 获取规则资源
 */
public class FileSourceLoad implements ISourceLoad {

    @Override
    public FileRuleInfo getRuleSource(IRuleKey ruleKey) {
        FileRuleKey fileFileRuleKey = (FileRuleKey) ruleKey;
        String rulePath = fileFileRuleKey.rulePath;

        //加载规则文件信息
        File ruleFile = new File(StringUtil.formatFilePath(rulePath));
        String ruleText = FileUtil.stringFile(ruleFile);

        FileRuleInfo fileRuleInfo = new FileRuleInfo(fileFileRuleKey);
        fileRuleInfo.setRuleText(ruleText);

        return fileRuleInfo;
    }
}
