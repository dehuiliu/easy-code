package easy.code.common;

import easy.code.common.groovyvo.EasyCodeGroovyShell;
import easy.code.common.groovyvo.EasyCodeMetaClass;
import easy.code.common.groovyvo.MyGroovyObject;
import groovy.lang.Binding;
import groovy.lang.GroovyClassLoader;
import groovy.lang.GroovyObject;
import groovy.lang.Script;

import java.util.Map;
import java.util.Set;

public enum RuleType {

    CLASS {
        public MyGroovyObject parse(IRuleSource ruleSource) {
            Map<String, Object> bindMap = ruleSource.getDefaultParamMap();
            GroovyObject groovyObject = null;
            //todo设置上下文
            Set<Map.Entry<String, Object>> entrySet = bindMap.entrySet();
            try {
                StringBuilder tempRuleS = new StringBuilder(ruleSource.getSourceString());
                for (Map.Entry<String, Object> entry : entrySet) {
                    String key = entry.getKey();
                    //强制添加 绑定的属性
                    int lastIndexOf = tempRuleS.lastIndexOf("}");
                    String defProperty = "\n def " + key + ";";
                    tempRuleS.insert(lastIndexOf, defProperty);
                }
                //构造对象
                GroovyClassLoader loader = new GroovyClassLoader(
                        this.getClass().getClassLoader(), ruleSource.getDefaultCompilerConfig());
                Class classR = loader.parseClass(tempRuleS.toString());
                groovyObject = (GroovyObject) classR.newInstance();
            } catch (IllegalAccessException e) {

            } catch (InstantiationException e) {

            } catch (Exception e) {

            }
            //构造执行的 元类
            EasyCodeMetaClass metaClassOfCore = new EasyCodeMetaClass(groovyObject.getMetaClass());
            //设置元类
            groovyObject.setMetaClass(metaClassOfCore);

            //设置上下文
            for (Map.Entry entry : entrySet) {
                groovyObject.setProperty(entry.getKey().toString(), entry.getValue());
            }
            return new MyGroovyObject(groovyObject);
        }

    },

    SCRIPT {
        public MyGroovyObject parse(IRuleSource ruleSource) {
            EasyCodeGroovyShell shellOfCore = new EasyCodeGroovyShell(
                    new Binding(ruleSource.getDefaultParamMap()), ruleSource.getDefaultCompilerConfig());
            Script parse = shellOfCore.parse(ruleSource.getSourceString());
            return new MyGroovyObject(parse);
        }
    };

    /**
     * 编译方法
     *
     * @param ruleSource 规则资源对象
     * @return 编译结果
     */
    public abstract MyGroovyObject parse(IRuleSource ruleSource);
}
