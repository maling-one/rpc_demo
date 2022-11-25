package one.maling;

import com.alibaba.fastjson.JSON;

import java.math.BigDecimal;

public class SerializeAPI {
    public static void main(String[] args) {
        Person xiaoming = new Person("xiaoming", 18, new BigDecimal("123.23232"));
        String s = JSON.toJSONString(xiaoming);
        System.out.println(s);
    }
}
