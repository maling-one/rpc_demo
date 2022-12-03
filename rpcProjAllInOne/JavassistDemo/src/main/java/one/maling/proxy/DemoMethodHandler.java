package one.maling.proxy;

import javassist.util.proxy.MethodHandler;

import java.lang.reflect.Method;

public class DemoMethodHandler implements MethodHandler {

    @Override
    public Object invoke(Object self, Method thisMethod, Method proceed, Object[] args) throws Throwable {
        System.out.println("------- Before selling fruits -------");
        //执行被代理的目标对象的方法
        Object result = proceed.invoke(self, args);
        System.out.println("------- After selling fruits -------");
        return result;
    }
}
