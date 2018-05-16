package easy.code.web.service.common.cacheload;

import easy.code.common.IRuleKey;
import easy.code.common.ISourceLoad;

public class CacheRuleKey implements IRuleKey {

    private String cacheKey;

    private String method = "entry";

    public CacheRuleKey(String key) {
        this.cacheKey = key;
    }


    public String getCacheKey() {
        return cacheKey;
    }

    @Override
    public IRuleKey createKey(String ruleKey) {
        return new CacheRuleKey(ruleKey);
    }

    @Override
    public ISourceLoad sourceLoad() {
        return new CacheSourceLoad();
    }
}
