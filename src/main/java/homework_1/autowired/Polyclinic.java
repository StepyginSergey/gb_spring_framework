package homework_1.autowired;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component("polyclinic")
public class Polyclinic {
    @Autowired
    Reception reception;
    @Autowired
    public Polyclinic(Reception reception){
        this.reception = reception;
    }


}
