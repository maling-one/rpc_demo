package one.maling;

import net.sf.cglib.core.DebuggingClassWriter;
import net.sf.cglib.proxy.Enhancer;
import one.maling.proxy.DemoMethodInterceptor;
import one.maling.proxy.FruitGrower;

public class CgLibProxyTest {
    public static void main( String[] args ) {
        System.setProperty(DebuggingClassWriter.DEBUG_LOCATION_PROPERTY, ".//cglibDemo//target//tmp");
        Enhancer enhancer = new Enhancer();
        enhancer.setSuperclass(FruitGrower.class);
        enhancer.setCallback(new DemoMethodInterceptor());
        FruitGrower proxy = (FruitGrower) enhancer.create();
        proxy.sellFruit();
    }
}
