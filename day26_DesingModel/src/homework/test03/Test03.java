package homework.test03;

/**
 * 功能描述：
 *
 * @author 陈铉锋
 * @date 2021/7/20
 */
public class Test03 {
    public static void main(String[] args) {
        ElectricMotor elec = new ElectricMotor();
        Motor motor1 = new ElecAdapther(elec);
        motor1.drive();

        OpticalMotor opticalMotor = new OpticalMotor();
        Motor motor2 = new OpticalAdapther(opticalMotor);
        motor2.drive();
    }
}
