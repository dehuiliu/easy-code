package easy.code.common;

public interface IRuleKey<T> {
    /**
     * @return
     */
    RuleType getRuleType();

    T getRuleKey();
}
