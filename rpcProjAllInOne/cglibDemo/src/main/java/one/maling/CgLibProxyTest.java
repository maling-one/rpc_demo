package one.maling;

import net.sf.cglib.proxy.Enhancer;
import one.maling.proxy.DemoMethodInterceptor;
import one.maling.proxy.FruitGrower;
import one.maling.proxy.Sales;

public class CgLibProxyTest {
    public static void main( String[] args ) {
        Enhancer enhancer = new Enhancer();
        enhancer.setSuperclass(FruitGrower.class);
        enhancer.setCallback(new DemoMethodInterceptor());
        Sales proxy = (Sales) enhancer.create();
        proxy.sellFruit();
    }
}
