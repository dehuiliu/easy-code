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
    private final static List<IExecuteType> EXECUTE_CHECKS = new ArrayList<IExecuteType>();
    /**
     * 是否进行 执行类型校验
     * 若注入执行类型，就进行校验，没有注入就不用校验
     */
    private static boolean UN_CHECK = true;
    /**
     * 默认执行类型
     */
    private final static IExecuteType DEFAULT_EXE_TYPE = ExecuteType.FILE;

    private RuleUtils() {

    }

    public void init(List<IExecuteType> _classes) {
        EXECUTE_CHECKS.addAll(_classes);
        UN_CHECK = false;
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


    private static boolean check(IExecuteType executeType) {
        return UN_CHECK || EXECUTE_CHECKS.contains(executeType);
    }
}
