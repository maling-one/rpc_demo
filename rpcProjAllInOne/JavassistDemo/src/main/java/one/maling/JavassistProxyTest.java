package one.maling;

import javassist.util.proxy.MethodFilter;
import javassist.util.proxy.ProxyFactory;
import javassist.util.proxy.ProxyObject;
import one.maling.proxy.DemoMethodHandler;
import one.maling.proxy.FruitGrower;

import java.lang.reflect.Method;

/**
 * Hello world!
 *
 */
public class JavassistProxyTest {
    public static void main( String[] args ) throws InstantiationException, IllegalAccessException {
        ProxyFactory proxyFactory = new ProxyFactory();
        //设置被代理类
        proxyFactory.setSuperclass(FruitGrower.class);
        //设置方法过滤器
        proxyFactory.setFilter(new MethodFilter() {
            @Override
            public boolean isHandled(Method m) {
                return !"finalize".equals(m.getName());
            }
        });
        //创建代理类
        Class aClass = proxyFactory.createClass();
        FruitGrower proxy = (FruitGrower) aClass.newInstance();
        //设置方法调用器
        ((ProxyObject) proxy).setHandler(new DemoMethodHandler());
        //调用方法
        proxy.sellFruit();
    }
}
