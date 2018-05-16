package easy.code.web.service;

import easy.code.web.service.common.CacheRuleInfo;
import easy.code.web.service.common.SingleCache;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class RuleServiceImpl implements RuleService {

    private static final Logger logger = LoggerFactory.getLogger(RuleServiceImpl.class);

    @Override
    public String saveRuleInfo(String user, String ruleKey, String ruleInfo) {
        logger.debug("-------saveRuleInfo");
        SingleCache singleCache = SingleCache.getSingleCache();
        singleCache.pub(ruleKey, new CacheRuleInfo(user, ruleInfo));
        return "success";
    }

    @Override
    public String deleteRule(String ruleKey) {
        logger.debug("-------deleteRule");
        SingleCache singleCache = SingleCache.getSingleCache();
        CacheRuleInfo ruleInfo = singleCache.getCacheMap().remove(ruleKey);

        return ruleInfo.getRuleText();
    }

    @Override
    public CacheRuleInfo queryRuleByKey(String ruleKey) {
        logger.debug("-------queryRuleByKey");
        SingleCache singleCache = SingleCache.getSingleCache();
        return singleCache.get(ruleKey);
    }

    @Override
    public List<CacheRuleInfo> queryRuleList(final String user) {
        logger.debug("-------queryRuleList");
        SingleCache singleCache = SingleCache.getSingleCache();
        Collection<CacheRuleInfo> values = singleCache.getCacheMap().values();

        return values.stream().filter(value -> value.thisUser(user)).collect(Collectors.toList());

    }
}
