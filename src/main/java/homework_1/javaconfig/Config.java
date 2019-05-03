package homework_1.javaconfig;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@ComponentScan("homework_1.javaconfig")
public class Config {

    @Bean(name = "reception")
    public Reception reception(){
        return new Reception();
    }

    @Bean(name="polyclinic")
    public Polyclinic polyclinic(Reception reception){
        return new Polyclinic(reception);
    }

    @Bean(name = "client")
    public Client client(@Value("Petr")String name, @Value("30") int age){
        return new Client(name, age);
    }
}
