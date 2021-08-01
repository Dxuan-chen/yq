package homework.test25;

/**
 *
 */
public class Son extends Father {

//    @Override //重写方法不能抛出与父类平级的其他异常
//    public void eat() throws TonguePainException {
//        throw new TonguePainException();
//    }

//    @Override //重写方法不能抛出比父类高级的异常
//    public void eat() throws PainException {
//        throw new PainException();
//    }

//    @Override //重写方法可以抛出和父类同样的异常
//    public void eat() throws ToothPainException {
//        throw new ToothPainException();
//    }

//    @Override //重写方法:可以抛出父类抛出异常的子类异常
//    public void eat() throws BigToothPainException {
//        throw new BigToothPainException();
//    }

//    @Override //重写方法:可以抛出父类抛出异常的子类异常
//    public void eat() throws BigToothPainException, FrontToothPainExcption {
//        if(true){
//            throw new BigToothPainException("大牙疼");
//        }
//        throw new FrontToothPainExcption("门牙疼");
//    }

//    @Override //父类不抛出异常,子类也不能抛出异常(编译时异常)
//    public void drink(){
//        throw new ToothPainException();
//    }

    @Override //如果子类内部抛出了异常
    public void drink(int water){
        try {
            if(water == 100){
                throw new TonguePainException();
            }
        }catch (TonguePainException e){
            e.printStackTrace();
        }
    }

}
