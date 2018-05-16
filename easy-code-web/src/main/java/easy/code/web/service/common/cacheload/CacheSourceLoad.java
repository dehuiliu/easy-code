package easy.code.web.service.common.cacheload;

import easy.code.common.IRuleKey;
import easy.code.common.IRuleSource;
import easy.code.common.ISourceLoad;
import easy.code.fileload.FileRuleSource;
import easy.code.web.service.common.CacheRuleInfo;
import easy.code.web.service.common.SingleCache;

public class CacheSourceLoad implements ISourceLoad {

    @Override
    public IRuleSource getRuleSource(IRuleKey ruleKey) {
        CacheRuleKey cacheRuleKey = (CacheRuleKey) ruleKey;
        String cacheKey = cacheRuleKey.getCacheKey();
        //获取缓存内容
        CacheRuleInfo cacheRuleInfo = SingleCache.getSingleCache().get(cacheKey);
        if (cacheRuleInfo == null) {
            throw new RuntimeException("------规则[" + cacheKey + "]内容不存在");
        }
        //规则信息
        return new FileRuleSource(ruleKey, cacheRuleInfo.getRuleText());
    }
}
