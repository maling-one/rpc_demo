package one.maling;

import com.alibaba.fastjson.JSON;

public class DeserializerAPI {
    public static void main(String[] args) {
        String json = "{\"age\":18,\"name\":\"xiaoming\",\"salary\":123.23232}";
        Person person = JSON.parseObject(json, Person.class);
        System.out.println(person);
    }
}
