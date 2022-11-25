package one.maling;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.serializer.BeanContext;
import com.alibaba.fastjson.serializer.ContextValueFilter;
import com.alibaba.fastjson.serializer.SerializerFeature;

import java.math.BigDecimal;
import java.util.Arrays;
import java.util.List;

public class ContextValueFilterTest {

    public static void main(String[] args) {
        List<Person> listOfPersons = Arrays.asList(new Person("xiaoming", 18, new BigDecimal("3.14")),
                new Person("xiaohong", 17, new BigDecimal("3.14")));
        ContextValueFilter valueFilter = new ContextValueFilter() {
            public Object process(
                    BeanContext context, Object object, String name, Object value) {
                if (name.equals("salary")) {
                    return "隐藏";
                }
                if (value.equals("xiaoming")) {
                    return ((String) value).toUpperCase();
                } else {
                    return null;
                }
            }
        };
        String jsonOutput = JSON.toJSONString(listOfPersons, valueFilter);
        System.out.println(jsonOutput);

        jsonOutput = JSON.toJSONString(listOfPersons, SerializerFeature.BeanToArray);
        System.out.println(jsonOutput);
    }
}
