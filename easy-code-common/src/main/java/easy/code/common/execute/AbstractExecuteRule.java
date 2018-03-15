package easy.code.common.execute;

import easy.code.common.ISourceLoad;

public abstract class AbstractExecuteRule implements IExecuteRule {

    protected ISourceLoad sourceLoad;

    public AbstractExecuteRule(ISourceLoad sourceLoad) {
        this.sourceLoad = sourceLoad;
    }
}
