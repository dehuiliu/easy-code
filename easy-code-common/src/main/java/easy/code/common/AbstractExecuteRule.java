package easy.code.common;

public abstract class AbstractExecuteRule implements IExecuteRule {

    protected ISourceLoad sourceLoad;

    public AbstractExecuteRule(ISourceLoad sourceLoad) {
        this.sourceLoad = sourceLoad;
    }
}
