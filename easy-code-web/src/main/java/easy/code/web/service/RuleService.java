package easy.code.web.service;

import easy.code.common.IRuleSource;

import java.util.List;

public interface RuleService {

    String saveRuleInfo(String ruleKey, String ruleInfo);

    String deleteRule(String ruleKey);

    IRuleSource queryRuleByKey(String ruleKey);

    List<IRuleSource> queryRuleList(String user);
}
