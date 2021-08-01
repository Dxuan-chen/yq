package enums;

/**
 * 功能描述：
 *
 * @author 陈铉锋
 * @date 2021/7/21
 */
public class Demo04 {
    public static void main(String[] args) {
        String desc = TaskEnum.getDesc(0);
        System.out.println(desc);
        String desc2 = TaskEnum.getDesc(1);
        System.out.println(desc2);
        String desc3 = TaskEnum.getDesc(2);
        System.out.println(desc3);
    }

}

enum TaskEnum{
    UN_START(0,"未开始"),
    PROGRESSING(1,"进行中"),
    COMPLETED(2,"已完成");

    int status;
    String desc;

    TaskEnum(){

    }

    TaskEnum(int status,String desc){
        this.status = status;
        this.desc = desc;
    }

    public static String getDesc(int status){
        TaskEnum[] values = TaskEnum.values();
        for (TaskEnum value : values) {
            if(value.status == status){
                return value.desc;
            }
        }
        return UN_START.desc;
    }
}