package easy.code.common.groovyvo;

import easy.code.common.execute.IExecuteType;

import java.util.HashMap;
import java.util.Map;

/**
 * 线程级 上下文对象
 * 存储 一次执行的相应内容
 */
public class EasyCodeThreadLocal {

    private static final ThreadLocal<EasyCodeThreadLocal> THREAD_LOCAL = new ThreadLocal<>();
    /**
     * 变量存储的集合
     */
    private Map<String, Object> variableMap = new HashMap<>();
    /**
     * 当前执行的类型
     */
    private IExecuteType nowExecuteType;

    private EasyCodeThreadLocal() {

    }

    /**
     * 获得当前线程变量
     *
     * @return 线程上下文
     */
    public static EasyCodeThreadLocal getThreadLocal() {
        EasyCodeThreadLocal easyCodeThreadLocal = THREAD_LOCAL.get();
        if (easyCodeThreadLocal == null) {
            easyCodeThreadLocal = new EasyCodeThreadLocal();
            THREAD_LOCAL.set(easyCodeThreadLocal);
        }
        return THREAD_LOCAL.get();
    }

    /**
     * 清理上下文
     * 每次需要手动清理，避免出现线程问题
     *
     * @return 清理的对象
     */
    public static EasyCodeThreadLocal clear() {
        EasyCodeThreadLocal easyCodeThreadLocal = THREAD_LOCAL.get();
        if (easyCodeThreadLocal != null) {
            THREAD_LOCAL.set(null);
        }
        return easyCodeThreadLocal;
    }

    /**
     * 添加值
     *
     * @param key
     * @param value
     */
    public void addVariable(String key, Object value) {
        this.variableMap.put(key, value);
    }

    /**
     * 获取变量中所有值
     *
     * @return
     */
    public Map<String, Object> getVariableMap() {
        return variableMap;
    }

    /**
     * 获取指定key对应的值
     *
     * @param key
     * @return
     */
    public Object getVariable(String key) {
        return getVariableMap().get(key);
    }

    public IExecuteType getNowExecuteType() {
        return nowExecuteType;
    }

    public void setNowExecuteType(IExecuteType nowExecuteType) {
        if (this.nowExecuteType != null) {
            this.nowExecuteType = nowExecuteType;
        }
    }
}
