import java.lang.reflect.Proxy;

public class JdkProxyTest {
    public static void main(String[] args) {
        FruitGrower fruitGrower = new FruitGrower();
        ClassLoader classLoader = fruitGrower.getClass().getClassLoader();
        Class<?>[] interfaces = fruitGrower.getClass().getInterfaces();
        DemoInvocationHandler demoInvocationHandler = new DemoInvocationHandler(fruitGrower);
        Sales proxy = (Sales) Proxy.newProxyInstance(classLoader, interfaces, demoInvocationHandler);
        proxy.sellFruit();
    }
}