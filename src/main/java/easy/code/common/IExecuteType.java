package easy.code.common;

/**
 * 执行类型
 */
public interface IExecuteType<T> {
    /**
     * 获取执行类型
     *
     * @return
     */
    T getType();

    IExecuteRule getExecuteRule();
}
