package easy.code.common.groovyvo;

import easy.code.common.IRuleKey;
import easy.code.common.exception.EasyCodeException;
import easy.code.common.exception.ErrorCode;
import easy.code.common.exception.ErrorMessage;
import easy.code.common.execute.IExecuteType;
import easy.code.common.util.RuleUtils;
import easy.code.common.vo.RuleParam;
import easy.code.common.vo.RuleResult;
import groovy.lang.*;
import org.codehaus.groovy.ast.ClassNode;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.lang.reflect.Method;
import java.util.List;

/**
 * Created by liudh
 * 仅仅限于Groovy 1.8.7 版本（其余版本不能确定稳定）
 * 扩展的MetaClass
 * 拦截invoke方法，missingMethod方法
 */
public class EasyCodeMetaClass implements MetaClass, MutableMetaClass {

    /**
     * 日志
     */
    private static Logger logger = LoggerFactory.getLogger(EasyCodeMetaClass.class);
    /**
     * 执行的 MetaClass 对象
     */
    private MetaClassImpl executeMetaClass;

    public EasyCodeMetaClass(MetaClass executeMetaClass) {
        this.executeMetaClass = (MetaClassImpl) executeMetaClass;
    }

    @Override
    public Object invokeConstructor(Object[] arguments) {
        return executeMetaClass.invokeConstructor(arguments);
    }

    @Override
    public Object invokeMissingMethod(Object instance, String methodName, Object[] arguments) {
        return executeMetaClass.invokeMissingMethod(instance, methodName, arguments);
    }

    @Override
    public Object invokeMethod(Object object, String methodName, Object arguments) {
        if (logger.isDebugEnabled()) {
            logger.debug("---- meta class execute ---- ");
        }
        Object ret = null;
        try {
            //执行 规则
            return executeMetaClass.invokeMethod(object, methodName, arguments);
        } catch (Exception e) {
            //如果是 方法丢失异常
            if (e instanceof MissingMethodException) {
                // 继续寻找执行规则
                GroovyObject groovyObject = (GroovyObject) object;
                ret = executeOtherRule(methodName, arguments);
            } else if (e instanceof EasyCodeException) {
                EasyCodeException easyException = (EasyCodeException) e;
                //缓存规则调用链路异常信息
                easyException.addLinked();
                // 直接抛出
                throw easyException;
            } else {
                //其它异常 封装后抛出
                throw EasyCodeException.asException(
                        new ErrorMessage(ErrorCode.DOING_ERROR, "未知异常"), e);
            }
        }
        return ret;
    }

    private RuleResult executeOtherRule(String methodName, Object arguments) throws EasyCodeException {
        RuleResult ruleResult = null;
        EasyCodeThreadLocal threadLocal = EasyCodeThreadLocal.getThreadLocal();
        IExecuteType nowExecuteType = threadLocal.getNowExecuteType();
        try {
//            IRuleKey ruleKey = (IRuleKey) groovyObject.getProperty(IRuleSource._PROPERTY_RULE_KEY);
            IRuleKey ruleKey = nowExecuteType.createKey(methodName);
//            String executeMethodName = StringUtil.toString(groovyObject.getProperty("executeMethodName"));
            String executeMethodName = ruleKey.getExecuteMethod();
            RuleParam ruleParam = new RuleParam();
            ruleParam.setParam(arguments);
            ruleParam.setExeMethod(executeMethodName);
            ruleResult = RuleUtils.executeRule(nowExecuteType, ruleKey, ruleParam);
        } catch (EasyCodeException inException) {
            //内部错误，直接抛出
            throw inException;
        } catch (Exception e) {
            //未知异常 封装后抛出
            throw EasyCodeException.asException(
                    new ErrorMessage(ErrorCode.DOING_ERROR, "未知异常"), e);
        }
        return ruleResult;

    }

    @Override
    public Object invokeMethod(Object object, String methodName, Object[] arguments) {
        return executeMetaClass.invokeMethod(object, methodName, arguments);
    }

    @Override
    public Object invokeMethod(Class sender, Object receiver, String methodName, Object[] arguments, boolean isCallToSuper, boolean fromInsideClass) {
        return executeMetaClass.invokeMethod(sender, receiver, methodName, arguments, isCallToSuper, fromInsideClass);
    }


    @Override
    public Object invokeStaticMethod(Object object, String methodName, Object[] arguments) {
        return executeMetaClass.invokeStaticMethod(object, methodName, arguments);
    }


    @Override
    public Object invokeMissingProperty(Object instance, String propertyName, Object optionalValue, boolean isGetter) {
        return executeMetaClass.invokeMissingProperty(instance, propertyName, optionalValue, isGetter);
    }

    @Override
    public boolean isModified() {
        return executeMetaClass.isModified();
    }

    @Override
    public void addNewInstanceMethod(Method method) {
        executeMetaClass.addNewInstanceMethod(method);
    }

    @Override
    public void addNewStaticMethod(Method method) {
        executeMetaClass.addNewStaticMethod(method);
    }

    @Override
    public void addMetaMethod(MetaMethod metaMethod) {
        executeMetaClass.addMetaMethod(metaMethod);
    }

    @Override
    public void addMetaBeanProperty(MetaBeanProperty metaBeanProperty) {
        executeMetaClass.addMetaBeanProperty(metaBeanProperty);
    }

    @Override
    public Object getProperty(Class sender, Object receiver, String property, boolean isCallToSuper, boolean fromInsideClass) {
        return executeMetaClass.getProperty(sender, receiver, property, isCallToSuper, fromInsideClass);
    }

    @Override
    public void setProperty(Class sender, Object receiver, String property, Object value, boolean isCallToSuper, boolean fromInsideClass) {
        executeMetaClass.setProperty(sender, receiver, property, value, isCallToSuper, fromInsideClass);
    }

    @Override
    public Object getAttribute(Class sender, Object receiver, String messageName, boolean useSuper) {
        return executeMetaClass.getAttribute(sender, receiver, messageName, useSuper);
    }

    @Override
    public void setAttribute(Class sender, Object receiver, String messageName, Object messageValue, boolean useSuper, boolean fromInsideClass) {
        executeMetaClass.setAttribute(sender, receiver, messageName, messageValue, useSuper, fromInsideClass);
    }

    @Override
    public void initialize() {
        executeMetaClass.initialize();
    }

    @Override
    public List<MetaProperty> getProperties() {
        return executeMetaClass.getProperties();
    }

    @Override
    public List<MetaMethod> getMethods() {
        return executeMetaClass.getMethods();
    }

    @Override
    public List<MetaMethod> respondsTo(Object obj, String name, Object[] argTypes) {
        return executeMetaClass.respondsTo(obj, name, argTypes);
    }

    @Override
    public List<MetaMethod> respondsTo(Object obj, String name) {
        return executeMetaClass.respondsTo(obj, name);
    }

    @Override
    public MetaProperty hasProperty(Object obj, String name) {
        return executeMetaClass.hasProperty(obj, name);
    }

    @Override
    public MetaProperty getMetaProperty(String name) {
        return executeMetaClass.getMetaProperty(name);
    }

    @Override
    public MetaMethod getStaticMetaMethod(String name, Object[] args) {
        return executeMetaClass.getStaticMetaMethod(name, args);
    }

    @Override
    public MetaMethod getMetaMethod(String name, Object[] args) {
        return executeMetaClass.getMetaMethod(name, args);
    }

    @Override
    public Class getTheClass() {
        return executeMetaClass.getTheClass();
    }

    @Override
    public Object getProperty(Object object, String property) {
        return executeMetaClass.getProperty(object, property);
    }

    @Override
    public void setProperty(Object object, String property, Object newValue) {
        executeMetaClass.setProperty(object, property, newValue);
    }

    @Override
    public Object getAttribute(Object object, String attribute) {
        return executeMetaClass.getAttribute(object, attribute);
    }

    @Override
    public void setAttribute(Object object, String attribute, Object newValue) {
        executeMetaClass.setAttribute(object, attribute, newValue);
    }

    @Override
    public ClassNode getClassNode() {
        return executeMetaClass.getClassNode();
    }

    @Override
    public List<MetaMethod> getMetaMethods() {
        return executeMetaClass.getMetaMethods();
    }

    @Override
    public int selectConstructorAndTransformArguments(int numberOfConstructors, Object[] arguments) {
        return executeMetaClass.selectConstructorAndTransformArguments(numberOfConstructors, arguments);
    }

    @Override
    public MetaMethod pickMethod(String methodName, Class[] arguments) {
        return executeMetaClass.pickMethod(methodName, arguments);
    }
}
