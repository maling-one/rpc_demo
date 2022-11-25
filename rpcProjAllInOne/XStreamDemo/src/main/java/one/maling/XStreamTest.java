package one.maling;

import com.thoughtworks.xstream.XStream;

import java.math.BigDecimal;

public class XStreamTest {

    public static void main(String[] args) {
        XStream xStream = new XStream();
        xStream.alias("person", Person.class);
        Person xiaohong = new Person("xiaohong", 28, new BigDecimal(100));
        String xml = xStream.toXML(xiaohong);
        System.out.println(xml);
    }
}
