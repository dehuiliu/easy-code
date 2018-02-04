package easy.code.common;

import easy.code.fileload.FileSourceLoad;

public enum ExecuteType implements IExecuteType {
    FILE {
        @Override
        public DefaultExecuteRule getExecuteRule() {
            return new DefaultExecuteRule(new FileSourceLoad());
        }
    },

    DB {
        @Override
        public DefaultExecuteRule getExecuteRule() {
            throw new RuntimeException("暂时未实现");
        }
    }

}
