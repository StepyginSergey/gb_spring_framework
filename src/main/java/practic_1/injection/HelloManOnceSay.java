package practic_1.injection;

public class HelloManOnceSay implements HelloMan {
    private  String name;
    public HelloManOnceSay(){
    }
    public HelloManOnceSay(String name) {
        this.name = name;
    }
        @Override
    public void helloSay() {
            System.out.println("Hello " + this.getName());
    }

    @Override
    public String getName() {
        return name;
    }

    @Override
    public void setName(String name) {
        this.name = name;
    }
}
