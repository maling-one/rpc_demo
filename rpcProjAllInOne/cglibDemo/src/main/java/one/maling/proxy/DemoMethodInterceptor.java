package one.maling.proxy;

import net.sf.cglib.proxy.MethodInterceptor;
import net.sf.cglib.proxy.MethodProxy;

import java.lang.reflect.Method;

public class DemoMethodInterceptor implements MethodInterceptor {
    @Override
    public Object intercept(Object o, Method method, Object[] objects, MethodProxy methodProxy) throws Throwable {
        System.out.println("------- Before selling fruits -------");
        //执行被代理的目标对象的方法
        Object result = methodProxy.invokeSuper(o, objects);
        System.out.println("------- After selling fruits -------");
        return result;
    }
}
