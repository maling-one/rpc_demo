import sun.misc.ProxyGenerator;

import java.io.FileOutputStream;
import java.io.IOException;

public class BuildClass {
    public static void main(String[] args) {
        String path = "$Proxy0.class";
        byte[] classByte = ProxyGenerator.generateProxyClass("$Proxy0", new Class[]{Sales.class});
        try (FileOutputStream out = new FileOutputStream(path)) {
            out.write(classByte);
            out.flush();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
