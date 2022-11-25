package one.maling;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.serializer.NameFilter;
import com.alibaba.fastjson.serializer.SerializeConfig;

import java.math.BigDecimal;
import java.util.Arrays;
import java.util.List;

public class NameFilterTest {
    public static void main(String[] args) {
        List<Person> listOfPersons = Arrays.asList(
                new Person("xiao ming", 18, new BigDecimal("3.14")),
                new Person("xiao hong", 17, new BigDecimal("3.14")));

        NameFilter formatName = new NameFilter() {
            public String process(Object object, String name, Object value) {
                return name.toUpperCase();
            }
        };

        SerializeConfig.getGlobalInstance().addFilter(Person.class, formatName);

        String jsonOutput =
                JSON.toJSONString(listOfPersons);
        System.out.println(jsonOutput);
    }
}
