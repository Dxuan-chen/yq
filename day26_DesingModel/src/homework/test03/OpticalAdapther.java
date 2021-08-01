package homework.test03;

/**
 * 功能描述：
 *
 * @author 陈铉锋
 * @date 2021/7/20
 */
public class OpticalAdapther implements Motor {
    OpticalMotor opticalMotor;

    public OpticalAdapther(OpticalMotor opticalMotor) {
        this.opticalMotor = opticalMotor;
    }

    public OpticalAdapther() {
    }

    @Override
    public void drive() {
        opticalMotor.opticalDrive();
    }
}
