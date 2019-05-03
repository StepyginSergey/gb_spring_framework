package homework_1.xml;

import org.springframework.stereotype.Component;

@Component("polyclinic")
public class Polyclinic {
    Reception reception;

    public Polyclinic(Reception reception){
        this.reception = reception;
    }

}
