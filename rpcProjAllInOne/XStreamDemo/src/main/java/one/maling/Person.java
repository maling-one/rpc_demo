package one.maling;

import java.math.BigDecimal;

/**
 * bean
 */
public class Person {
    private String name;
    private Integer age;
    private BigDecimal salary;

    public Person(String name, Integer age, BigDecimal salary) {
        this.name = name;
        this.age = age;
        this.salary = salary;
    }
}
