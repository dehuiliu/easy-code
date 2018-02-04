package easy.code.common;

/**
 * 规则来源接口；
 * RKEY 规则key对象
 * RINFO 规则 info信息
 */
public interface ISourceLoad {
    /**
     * 获取规则信息
     *
     * @param ruleKey 规则key
     * @return 规则信息对象
     */
    IRuleSource getRuleSource(IRuleKey ruleKey);
}
