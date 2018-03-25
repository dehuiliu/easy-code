package easy.code.common.execute;

import easy.code.common.IRuleKey;

/**
 * 执行类型
 */
public interface IExecuteType {

    IExecuteRule getExecuteRule();

    IRuleKey createKey(Object param);
}
