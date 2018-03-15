package easy.code.common.execute;

import easy.code.common.IRuleKey;
import easy.code.common.vo.RuleParam;
import easy.code.common.vo.RuleResult;

public interface IExecuteRule {
    /**
     * 执行规则
     *
     * @param ruleKey   规则唯一标示
     * @param ruleParam 规则的执行参数
     * @return 规则的返回结果
     */
    RuleResult getResult(IRuleKey ruleKey, RuleParam ruleParam);
}
