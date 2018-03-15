package easy.code.common.execute;

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
    },

    DB {
        @Override
        public IExecuteRule getExecuteRule() {
            throw new RuntimeException("暂时未实现");
        }
    }

}
