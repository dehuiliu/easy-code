package easy.code.common.groovyvo;

public class ExecuteTree {
    /**
     * 记录执行规则数量
     */
    private int ruleNum;

    /**
     * 根 规则信息对象
     */
    private ExecuteRuleNode treeInfo;
    /**
     * 是否记录
     */
    private boolean isRecord = true;
    /**
     * 当前执行的规则信息
     */
    private ExecuteRuleNode tempThis;

    public ExecuteTree(ExecuteRuleNode treeInfo) {
        this.addRuleNum();
        treeInfo.setIndex(this.ruleNum);

        this.treeInfo = treeInfo;
    }

    /**
     * 添加子规则
     *
     * @param subInfo 子规则信息
     */
    public void addSub(ExecuteRuleNode subInfo) {
        //执行规则+1
        this.addRuleNum();
        subInfo.setIndex(ruleNum);

        tempThis.addNextExecuteRuleInfo(subInfo);

    }

    public ExecuteRuleNode getTempThis() {
        return tempThis;
    }

    public void setTempThis(ExecuteRuleNode tempThis) {
        this.tempThis = tempThis;
    }

    public ExecuteRuleNode getTreeInfo() {
        return treeInfo;
    }

    /**
     * 执行规则数量+1
     *
     * @return
     */
    private int addRuleNum() {
        this.ruleNum++;
        return this.ruleNum;
    }

    public boolean isRecord() {
        return isRecord;
    }

    public void setRecord(boolean record) {
        isRecord = record;
    }
}
