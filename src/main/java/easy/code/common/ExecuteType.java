package easy.code.common;

import easy.code.fileload.FileExecuteRule;

public enum ExecuteType implements IExecuteType<ExecuteType> {
    FILE {
        @Override
        public ExecuteType getType() {
            return FILE;
        }

        @Override
        public IExecuteRule getExecuteRule() {
            return new FileExecuteRule();
        }
    },

    DB {
        @Override
        public ExecuteType getType() {
            throw new RuntimeException("暂时未实现");
        }

        @Override
        public IExecuteRule getExecuteRule() {
            throw new RuntimeException("暂时未实现");
        }
    }

}
