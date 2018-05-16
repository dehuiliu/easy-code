package easy.code.web.service.common;

import java.util.HashMap;
import java.util.Map;

/**
 * 缓存简单实现
 */
public class SingleCache {

    private Map<String, CacheRuleInfo> cacheMap = new HashMap<String, CacheRuleInfo>();

    private final static SingleCache singleCache = new SingleCache();

    private SingleCache() {
        //默认加载样例 到内存

    }

    public static SingleCache getSingleCache() {
        return singleCache;
    }

    public Map<String, CacheRuleInfo> getCacheMap() {
        return cacheMap;
    }

    public void setCacheMap(Map<String, CacheRuleInfo> cacheMap) {
        this.cacheMap = cacheMap;
    }

    public void pub(String key, CacheRuleInfo value) {
        this.cacheMap.put(key, value);
    }

    public CacheRuleInfo get(String key){
        return this.getCacheMap().get(key);
    }
    /*
    定时线程，扫描过期内容；除基础例子以外
     */


}
