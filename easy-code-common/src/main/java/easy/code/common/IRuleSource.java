package easy.code.common;

import easy.code.common.groovyvo.EasyCodeCompilerConfiguration;

import java.util.Map;

public interface IRuleSource {
    /**
     * 规则主键的key
     *
     * @return 规则组件key
     */
    IRuleKey getKey();

    /**
     * 获取 规则定义文件
     *
     * @return 规则文本
     */
    String getSourceString();

    /**
     * 获取默认引入的类 import
     * 会在编译时候处理，对应的规则中 可以无需引入该类 就可以直接使用
     *
     * @return 所有默认引入的类
     */
    EasyCodeCompilerConfiguration getDefaultCompilerConfig();

    /**
     * 默认引入的成员属性
     * ruleKey/executeMethod  规则主键和执行方法
     *
     * @return 成员名称，成员的值
     */
    Map<String, Object> getDefaultParamMap();
}
