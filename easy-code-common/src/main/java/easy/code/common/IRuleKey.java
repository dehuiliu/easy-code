package easy.code.common;

public interface IRuleKey {

    IRuleKey createKey(String ruleKey);

    ISourceLoad sourceLoad();
}
