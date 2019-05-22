package homework_1.autowired;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class VisitMain {
    public static void main(String[] args) {
        ApplicationContext ctx = new AnnotationConfigApplicationContext(Config.class);
        Polyclinic polyclinic = ctx.getBean("polyclinic", Polyclinic.class);

        Client client = ctx.getBean("client", Client.class);
        client.getName();
        client.getAge();
        polyclinic.reception.getCabinet("УЗИ");
    }
}
