package practic_1;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component("camera")
public class CameraImpl implements Camera{
    @Autowired
    @Qualifier("cameraRoll")
    private CameraRoll cameraRoll;

    @Value("false")
    private  boolean broken;

    public CameraRoll getCameraRoll() {
        return cameraRoll;
    }

    public void setCameraRoll(CameraRoll cameraRoll) {
        this.cameraRoll = cameraRoll;
    }

    public void doPhotograph(){
        if(isBroken()){
            System.out.println("Camera is broken");
            return;
        }
        System.out.println("click!");
        cameraRoll.processing();
    }

    @Override
    public void breaking() {
        this.broken = true;
    }

    @Override
    public boolean isBroken() {
        return broken;
    }
}
