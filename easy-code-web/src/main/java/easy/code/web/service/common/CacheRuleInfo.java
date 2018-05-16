package easy.code.web.service.common;

import easy.code.common.util.StringUtil;

import java.util.Date;

public class CacheRuleInfo {

    private Date create = new Date();

    private String ruleText;

    private String user;

    public CacheRuleInfo(String user, String ruleInfo) {
        this.user = user;
        this.ruleText = ruleInfo;
    }

    public String getRuleText() {
        return ruleText;
    }

    public boolean thisUser(String user) {
        return StringUtil.isEqual(this.user, user);
    }


}
