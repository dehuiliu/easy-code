package easy.code.web.controller.ruleInfo;

import easy.code.common.IRuleSource;
import easy.code.web.service.RuleService;
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
        String ruleInfo = request.getParameter("ruleInfo");
        return ruleService.saveRuleInfo(ruleKey, ruleInfo);
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
        IRuleSource ruleSource = ruleService.queryRuleByKey(ruleKey);
        return "";
    }

    @RequestMapping("/query")
    public String queryDetail(HttpServletRequest request) {
        String user = "";
        List<IRuleSource> ruleSource = ruleService.queryRuleList(user);
        return "";
    }

}
