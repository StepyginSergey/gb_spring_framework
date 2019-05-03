package homework_1.xml;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class VisitMain {
    public static void main(String[] args) {
/*        Reception reception = new Reception();
        Polyclinic poly = new Polyclinic(reception);
        poly.reception.getCabinet("Терапевт");
        poly.reception.getCabinet("Хирург");
*/
        ApplicationContext ctx = new ClassPathXmlApplicationContext("polyclinic_config.xml");
        Polyclinic polyclinic = ctx.getBean("polyclinic", Polyclinic.class);
        polyclinic.reception.getCabinet("Кардиолог");
        Client client = ctx.getBean("client", Client.class);
        client.getName();
        client.getAge();
    }
}
