package homework_1.autowired;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component("client")
public class Client {
    private String name;
    private int age;

    public Client(@Value("Petra")String name, @Value("28") int age){
        this.name = name;
        this.age = age;
    }

    public void getName() {
        System.out.println(name);
    }

    public void setName(String name) {
        this.name = name;
    }

    public void getAge() {
        System.out.println(age);
    }

    public void setAge(int age) {
        this.age = age;
    }
}
