package homework.test03;

/**
 * 功能描述：
 *
 * @author 陈铉锋
 * @date 2021/7/20
 */
public class ElecAdapther implements Motor {
    ElectricMotor elec;

    public ElecAdapther(ElectricMotor elec) {
        this.elec = elec;
    }

    public ElecAdapther() {
    }

    @Override
    public void drive() {
        elec.electricDrive();
    }
}
