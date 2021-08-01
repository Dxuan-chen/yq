package homework.test05;

/**
 * 功能描述：出国留学手续一般经过以下流程：索取学校资料，
 * 提出入学申请，办理因私出国护照、出境卡和公证，申请签证，
 * 体检、订机票、准备行装，抵达目标学校等，其中有些业务对各个学校是一样的，
 * 但有些业务因学校不同而不同.请用模板模式设计出出国留学类和英国留学类。
 *
 * 步骤说明
 *
 * 1.设计出出国留学的抽象类AbroadStudy
 *
 * 2.定义一个模板方法 handleProcedure(),该方法中需要包含办理出国留学手续流程中的各个基本方法:
 * 索取学校资料lookingForSchool，入学申请applyForEnrol，办理因私出国护照，出境卡和公证applyForPassport，
 * 申请签证applyForVisa，体检、订机票、准备行装readGo、抵达arriving
 *
 * 3.定义英国留学类StudyInEngland,编写其个性业务：索取学校资料(打印语句：英国入学资料)、提出入学申请(打印语句：英国入学申请)
 *
 * @author 陈铉锋
 * @date 2021/7/20
 */
public class Test05 {
    public static void main(String[] args) {
        StudyInEngland studyInEngland = new StudyInEngland();
        studyInEngland.yewu();
    }
}
