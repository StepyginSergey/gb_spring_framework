package homework_1.xml;

import org.springframework.stereotype.Component;

import java.util.HashMap;

@Component("reception")
public class Reception {

    HashMap<String,String> doctors;

    public Reception(){
        this.doctors = new HashMap<>();
        doctors.put("Терапевт", "101");
        doctors.put("ЛОР", "102");
        doctors.put("Окулист", "103");
        doctors.put("Кардиолог", "104");
        doctors.put("Хирург", "201");
        doctors.put("УЗИ", "202");
        doctors.put("Пульмонолог", "203");
    }

    public void getCabinet(String doctor) {
        if(doctors.containsKey(doctor)){
            System.out.println(doctor + " в кабинете " + doctors.get(doctor));
        }else {
            System.out.println("Такого специалиста в нашей клинике нету.");
        }
    }
}
