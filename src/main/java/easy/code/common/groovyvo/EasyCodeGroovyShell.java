package easy.code.common.groovyvo;

import groovy.lang.Binding;
import groovy.lang.GroovyShell;
import groovy.lang.MetaClass;
import groovy.lang.Script;
import org.codehaus.groovy.control.CompilationFailedException;
import org.codehaus.groovy.control.CompilerConfiguration;

/**
 * Created by liudh on 2016/9/6.
 */
public class EasyCodeGroovyShell extends GroovyShell {

    public EasyCodeGroovyShell(Binding binding, CompilerConfiguration config) {
        super(binding, config);
    }

    @Override
    public void resetLoadedClasses() {
        super.resetLoadedClasses();
    }

    @Override
    public Script parse(String scriptText) throws CompilationFailedException {
        Script script = super.parse(scriptText);
        //获取处理的metaClass
        MetaClass metaClass = script.getMetaClass();
        //构造框架扩展的metaClass
        EasyCodeMetaClass metaClassOfCore = new EasyCodeMetaClass(metaClass);
        //脚本中设置执行的metaClass
        script.setMetaClass(metaClassOfCore);
        return script;
    }

}
