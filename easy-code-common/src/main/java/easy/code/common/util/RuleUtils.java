package easy.code.common.util;

import easy.code.common.IRuleKey;
import easy.code.common.execute.DefaultExecuteRule;
import easy.code.common.execute.IExecuteRule;
import easy.code.common.groovyvo.EasyCodeThreadLocal;
import easy.code.common.vo.RuleParam;

/**
 * 规则执行工具类
 */
public final class RuleUtils {
    /**
     * 是否进行 执行类型校验
     * 若注入执行类型，就进行校验，没有注入就不用校验
     */
    private static boolean UN_CHECK = true;

    private RuleUtils() {

    }

    public static Object executeRule(IRuleKey ruleKey, RuleParam ruleParam) {
        //执行类型缓存到上下文
        EasyCodeThreadLocal threadLocal = EasyCodeThreadLocal.getThreadLocal();
        threadLocal.setNowRuleKey(ruleKey);

        //校验 exeType 是否在执行的Types 中
        IExecuteRule executeRule = new DefaultExecuteRule(ruleKey);
        //打印日志 开始执行
        Object result = executeRule.getResult(ruleParam);

        //打印结束日志
        return result;

    }


}
