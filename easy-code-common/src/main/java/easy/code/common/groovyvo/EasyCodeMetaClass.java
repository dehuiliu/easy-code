package easy.code.common.groovyvo;

import easy.code.common.IRuleKey;
import easy.code.common.exception.EasyCodeException;
import easy.code.common.util.RuleUtils;
import easy.code.common.vo.RuleParam;
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
        //execute rule
        ExecuteTree executeTree = getTreeNode(object, methodName, arguments);
        //now execute rule info
        ExecuteRuleNode thisRuleInfo = executeTree.getTempThis();

        try {

            //执行 规则
            ret = executeMetaClass.invokeMethod(object, methodName, arguments);

            //记录 执行规则结果
            executeTree.getTempThis().setOutPutParam(ret);

        } catch (Exception e) {
            //如果是 方法丢失异常
            if (e instanceof MissingMethodException) {
                executeTree.setRecord(true);
                // 继续寻找执行规则
                ret = executeOtherRule(methodName, arguments);
                //重置当前执行对象
                executeTree.setTempThis(thisRuleInfo);
            } else {

                //记录 异常信息
                executeTree.getTempThis().setError(true);
                executeTree.getTempThis().setThrowable(e);

                throw e;
            }
        }
        return ret;
    }

    private ExecuteTree getTreeNode(Object object, String methodName, Object param) {
        ExecuteTree executeTree = EasyCodeThreadLocal.getThreadLocal().getExecuteTree();
        Object iRuleKey = ((GroovyObject) object).getProperty("iRuleKey");
        ExecuteRuleNode executeRuleInfo = null;
        //根的情况
        if (executeTree == null) {
            executeRuleInfo = new ExecuteRuleNode();
            //根
            executeTree = new ExecuteTree(executeRuleInfo);
            EasyCodeThreadLocal.getThreadLocal().setExecuteTree(executeTree);


        } else if (executeTree.isRecord()) {
            //进行记录
            executeRuleInfo = new ExecuteRuleNode();

            executeTree.addSub(executeRuleInfo);

        }
        //补充执行对象信息
        if (executeRuleInfo != null) {
            executeRuleInfo.setRuleObject(object);
            executeRuleInfo.setRuleKey((IRuleKey) iRuleKey);
            executeRuleInfo.setInputParam(param);
            executeRuleInfo.setMethod(methodName);
            //当前执行的规则信息
            executeTree.setTempThis(executeRuleInfo);
            //不再记录，直到出现missing method exception 时继续
            executeTree.setRecord(false);

        }
        return executeTree;

    }

    private Object executeOtherRule(String methodName, Object arguments) throws EasyCodeException {
        Object ruleResult = null;
        EasyCodeThreadLocal threadLocal = EasyCodeThreadLocal.getThreadLocal();

        IRuleKey nowRuleKey = threadLocal.getNowRuleKey();
        IRuleKey ruleKey = nowRuleKey.createKey(methodName);
        //规则参数
        RuleParam ruleParam = new RuleParam();
        ruleParam.setParam(arguments);
        ruleResult = RuleUtils.executeRule(ruleKey, ruleParam);

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
