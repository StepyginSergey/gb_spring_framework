package practic_1;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Scope;

@Configuration
@ComponentScan("practic_1")
public class AppConfig {
    @Bean(name ="cameraRoll")
    public CameraRoll cameraRoll(){
        return new BlackAndWhiteCameraRoll();
    }

    @Bean(name="camera")
    @Scope("prototype")
     public Camera camera(CameraRoll cameraRoll){
        Camera camera = new CameraImpl();
        ((CameraImpl) camera).setCameraRoll(cameraRoll);
        return camera;
    }
}
