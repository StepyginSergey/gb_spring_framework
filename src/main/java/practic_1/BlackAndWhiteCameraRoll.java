package practic_1;

import org.springframework.stereotype.Component;

@Component("cameraRoll")
@UnproducableCameraRoll(usingCameraRollClass = ColorCameraRoll.class)
public class BlackAndWhiteCameraRoll implements CameraRoll {
    @Override
    public void processing() {
        System.out.println("-1 Black and White Cadr");
    }
}
