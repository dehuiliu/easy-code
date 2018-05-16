package easy.code.common.execute;

import easy.code.common.vo.RuleParam;

/**
 * 执行规则接口
 */
public interface IExecuteRule {
    /**
     * 执行规则核心逻辑
     * ruleParam中执行方法为空时，按照ruleKey中的执行方法
     *
     * @param ruleParam 规则的执行参数
     * @return 规则的返回结果
     */
    Object getResult(RuleParam ruleParam);
}
