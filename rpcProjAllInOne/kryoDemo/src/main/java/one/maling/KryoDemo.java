package one.maling;

import com.esotericsoftware.kryo.Kryo;
import com.esotericsoftware.kryo.Registration;
import com.esotericsoftware.kryo.io.Input;
import com.esotericsoftware.kryo.io.Output;
import one.maling.entity.Person;

import javax.imageio.plugins.jpeg.JPEGImageReadParam;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;

public class KryoDemo {
    public static void originalObjectSerializationTest() {
        Kryo kryo = new Kryo();
        String name = "xiaoming";
        //序列化
        try {
            Output output = new Output(new FileOutputStream("kryo.result"));
            kryo.writeObject(output, name);
            output.close();
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        }
        //反序列化
        try {
            Input input = new Input(new FileInputStream("kryo.result"));
            String s = kryo.readObject(input, String.class);
            System.out.println(s);
            input.close();
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        }
    }

    public static void customizeObjectSerializationTest() {
        Kryo kryo = new Kryo();
        kryo.register(Person.class);
        Person xiaoming = new Person("xiaoming", 18);
        //序列化
        try {
            Output output = new Output(new FileOutputStream("kryo.result"));
            kryo.writeObject(output, xiaoming);
            output.close();
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        }
        //反序列化
        try {
            Input input = new Input(new FileInputStream("kryo.result"));
            Person person = kryo.readObject(input, Person.class);
            System.out.println(person.getName());
            System.out.println(person.getAge());
            input.close();
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        }
    }

    public static void originalObjectSerializationWithObjectTest(){
        Kryo kryo = new Kryo();
        String name = "xiaoming";
        //序列化
        try {
            Output output = new Output(new FileOutputStream("kryo.result"));
            kryo.writeClassAndObject(output, name);
            output.close();
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        }
        //反序列化
        try {
            Input input = new Input(new FileInputStream("kryo.result"));
            String s = (String) kryo.readClassAndObject(input);
            System.out.println(s);
            input.close();
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        }
    }

    public static void customizeObjectSerializationWithObjectTest() {
        Kryo kryo = new Kryo();
        kryo.register(Person.class);
        Person xiaoming = new Person("xiaoming", 18);
        //序列化
        try {
            Output output = new Output(new FileOutputStream("kryo.result"));
            kryo.writeClassAndObject(output, xiaoming);
            output.close();
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        }
        //反序列化
        try {
            Input input = new Input(new FileInputStream("kryo.result"));
            Person person = (Person) kryo.readClassAndObject(input);
            System.out.println(person.getName());
            System.out.println(person.getAge());
            input.close();
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        }
    }

    public static void main(String[] args) {
        //originalObjectSerializationTest();
        //customizeObjectSerializationTest();
        //originalObjectSerializationWithObjectTest();
        customizeObjectSerializationWithObjectTest();
    }
}
