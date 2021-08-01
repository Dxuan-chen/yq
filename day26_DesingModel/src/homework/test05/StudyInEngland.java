package homework.test05;

/**
 * 功能描述：
 *
 * @author 陈铉锋
 * @date 2021/7/20
 */
public class StudyInEngland extends AbroadStudy {
    //索取学校资料
    @Override
    public void lookingForSchool() {
        System.out.println("英国入学资料");
    }

    @Override
    public void applyForEnrol() {
        System.out.println("英国入学申请");
    }

    @Override
    public void applyForPassport() {
    }

    @Override
    public void applyForVisa() {
    }

    @Override
    public void readGo() {
    }

    @Override
    public void arriving() {
    }

    public void yewu(){
        lookingForSchool();
        applyForEnrol();
    }

}
