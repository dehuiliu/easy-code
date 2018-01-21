package easy.code.common;

/**
 * 规则来源接口；
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
