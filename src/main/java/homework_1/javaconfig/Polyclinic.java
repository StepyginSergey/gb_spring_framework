package homework_1.javaconfig;

import org.springframework.stereotype.Component;

@Component("polyclinic")
public class Polyclinic {
    Reception reception;

    public Polyclinic(Reception reception){
        this.reception = reception;
    }

}
