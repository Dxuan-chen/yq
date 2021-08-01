package homework.test05;

/**
 * 功能描述：
 *
 * @author 陈铉锋
 * @date 2021/7/20
 */
public abstract class AbroadStudy {
    //索取学校资料
    public abstract void lookingForSchool();
    //入学申请
    public abstract void applyForEnrol();
    //办理因私出国护照，出境卡和公证
    public abstract void applyForPassport();
    //申请签证
    public abstract void applyForVisa();
    //体检、订机票、准备行装
    public abstract void readGo();
    //抵达
    public abstract void arriving();

    public void handleProcedure(){
        System.out.println("出国留学");
        lookingForSchool();
        applyForEnrol();
        applyForPassport();
        applyForVisa();
        readGo();
        arriving();
    }

}
