package one.maling;

import com.alibaba.fastjson.annotation.JSONField;

import java.math.BigDecimal;

public class Person2 {
    @JSONField(name = "name")
    private String name;
    @JSONField(name = "age")
    private Integer age;
    @JSONField(name = "salary")
    private BigDecimal salary;

    public Person2(String name, Integer age, BigDecimal salary) {
        this.name = name;
        this.age = age;
        this.salary = salary;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public BigDecimal getSalary() {
        return salary;
    }

    public void setSalary(BigDecimal salary) {
        this.salary = salary;
    }
}
