package homework_1.xml;

public class Client {
    private String name;
    private int age;

    public Client(String name, int age){
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
