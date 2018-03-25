package easy.code.common.execute;

import easy.code.common.IRuleKey;
import easy.code.common.RuleType;
import easy.code.common.util.StringUtil;
import easy.code.fileload.FileRuleKey;
import easy.code.fileload.FileSourceLoad;

/**
 * 系统默认支持类型
 */
public enum ExecuteType implements IExecuteType {
    FILE {
        @Override
        public IExecuteRule getExecuteRule() {
            return new DefaultExecuteRule(new FileSourceLoad());
        }

        @Override
        public IRuleKey createKey(Object param) {
            String ruleKey = StringUtil.toString(param);
            return new FileRuleKey(ruleKey);
        }
    },

    DB {
        @Override
        public IExecuteRule getExecuteRule() {
            throw new RuntimeException("暂时未实现");
        }

        @Override
        public IRuleKey createKey(Object param) {
            throw new RuntimeException("暂时未实现");
        }
    }

}
