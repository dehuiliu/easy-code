package easy.code.common;

import java.util.ArrayList;
import java.util.List;

/**
 * 规则执行工具类
 */
public final class RuleUtils {
    /**
     * 执行类 集合，可通过注入方式注入
     */
    private final static List<IExecuteType> EXECUTE_CLASSES = new ArrayList<IExecuteType>();
    /**
     * 默认执行类型
     */
    private final static IExecuteType DEFAULT_EXE_TYPE = ExecuteType.FILE;

    private RuleUtils() {

    }

    public void init(List<IExecuteType> _classes) {
        EXECUTE_CLASSES.addAll(_classes);
    }

    public static RuleResult executeRule(IRuleKey ruleKey, RuleParam ruleParam) {
        return executeRule(DEFAULT_EXE_TYPE, ruleKey, ruleParam);
    }

    public static RuleResult executeRule(IExecuteType ruleType, IRuleKey ruleKey, RuleParam ruleParam) {
        //校验 exeType 是否在执行的Types 中

        IExecuteRule executeRule = ruleType.getExecuteRule();
        //打印日志 开始执行
        RuleResult result = executeRule.getResult(ruleKey, ruleParam);
        //打印结束日志
        return result;

    }
}
