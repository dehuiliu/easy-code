package easy.code.web.service;

import easy.code.web.service.common.CacheRuleInfo;

import java.util.List;

public interface RuleService {

    String saveRuleInfo(String user, String ruleKey, String ruleInfo);

    String deleteRule(String ruleKey);

    CacheRuleInfo queryRuleByKey(String ruleKey);

    List<CacheRuleInfo> queryRuleList(String user);
}
