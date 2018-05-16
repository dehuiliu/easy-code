package easy.code.web.controller.ruleInfo;

import easy.code.web.controller.WebUtil;
import easy.code.web.service.RuleService;
import easy.code.web.service.common.CacheRuleInfo;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

@Controller
@RequestMapping("/rule")
public class RuleController {

    private static final Logger logger = LoggerFactory.getLogger(RuleController.class);

    @Autowired
    private RuleService ruleService;

    /**
     * 添加规则信息
     *
     * @param ruleKey 规则命名
     * @return
     */
    @RequestMapping("/save/{ruleKey}")
    @ResponseBody
    public String addRule(HttpServletRequest request, @PathVariable String ruleKey) {

        String user = WebUtil.getUser(request);

        String ruleInfo = request.getParameter("ruleInfo");

        return ruleService.saveRuleInfo(user, ruleKey, ruleInfo);
    }

    /**
     * 删除规则信息
     *
     * @param ruleKey
     * @return
     */
    @RequestMapping("/del/{ruleKey}")
    @ResponseBody
    public String deleteRule(@PathVariable String ruleKey) {
        return ruleService.deleteRule(ruleKey);
    }

    @RequestMapping("/query/{ruleKey}")
    public String queryDetail(@PathVariable String ruleKey) {
        CacheRuleInfo cacheRuleInfo = ruleService.queryRuleByKey(ruleKey);
        return cacheRuleInfo.getRuleText();
    }

    @RequestMapping("/query")
    @ResponseBody
    public Object queryDetail(HttpServletRequest request) {
        String user = WebUtil.getUser(request);

        List<CacheRuleInfo> cacheRuleInfos = ruleService.queryRuleList(user);

        return cacheRuleInfos;
    }

}
