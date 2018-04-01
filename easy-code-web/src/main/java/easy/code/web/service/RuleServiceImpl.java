package easy.code.web.service;

import easy.code.common.IRuleSource;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RuleServiceImpl implements RuleService {

    private static final Logger logger = LoggerFactory.getLogger(RuleServiceImpl.class);

    @Override
    public String saveRuleInfo(String ruleKey, String ruleInfo) {
        logger.debug("-------saveRuleInfo");
        return "success";
    }

    @Override
    public String deleteRule(String ruleKey) {
        logger.debug("-------deleteRule");
        return null;
    }

    @Override
    public IRuleSource queryRuleByKey(String ruleKey) {
        logger.debug("-------queryRuleByKey");
        return null;
    }

    @Override
    public List<IRuleSource> queryRuleList(String user) {
        logger.debug("-------queryRuleList");
        return null;
    }
}
