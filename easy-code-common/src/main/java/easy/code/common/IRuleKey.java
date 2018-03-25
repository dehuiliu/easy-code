package easy.code.common;

import easy.code.common.execute.ExecuteType;

public interface IRuleKey {
    /**
     * @return
     */
    RuleType getRuleType();

    /**
     * 获取执行类型；指定加载类型
     * ExecuteType
     *
     * @return
     */
    ExecuteType getExecuteType();

    /**
     * 获取执行方法
     *
     * @return 执行方法
     */
    String getExecuteMethod();
}
