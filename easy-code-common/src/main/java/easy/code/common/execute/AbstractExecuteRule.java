package easy.code.common.execute;

import easy.code.common.IRuleKey;
import easy.code.common.ISourceLoad;

public abstract class AbstractExecuteRule implements IExecuteRule {

    protected ISourceLoad sourceLoad;

    protected IRuleKey ruleKey;

    public AbstractExecuteRule(ISourceLoad sourceLoad, IRuleKey ruleKey) {
        this.sourceLoad = sourceLoad;
        this.ruleKey = ruleKey;
    }
}
