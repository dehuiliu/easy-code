package easy.code.common.execute;

import easy.code.common.IRuleKey;
import easy.code.common.vo.RuleParam;

public interface IExecuteRule {
    /**
     * 执行规则
     * ruleParam中执行方法为空时，按照ruleKey中的执行方法
     *
     * @param ruleKey   规则唯一标示
     * @param ruleParam 规则的执行参数
     * @return 规则的返回结果
     */
    Object getResult(IRuleKey ruleKey, RuleParam ruleParam);
}
