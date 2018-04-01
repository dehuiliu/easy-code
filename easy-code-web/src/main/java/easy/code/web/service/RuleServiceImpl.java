package easy.code.web.service;

import easy.code.common.IRuleSource;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RuleServiceImpl implements RuleService {

    @Override
    public String saveRuleInfo(String ruleKey, String ruleInfo) {
        return null;
    }

    @Override
    public String deleteRule(String ruleKey) {
        return null;
    }

    @Override
    public IRuleSource queryRuleByKey(String ruleKey) {
        return null;
    }

    @Override
    public List<IRuleSource> queryRuleList(String user) {
        return null;
    }
}
