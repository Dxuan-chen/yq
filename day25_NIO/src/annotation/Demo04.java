package annotation;

/**
 * 功能描述：
 *
 * @author 陈铉锋
 * @date 2021/7/19
 */
@StudentAnnotation(name="张三",value = "1.0")
//value是默认属性，可以省略名字，但是其他属性必须有名字
@StudentAnnotation2("2.0")
public class Demo04 {

    @StudentAnnotation(name="张无忌",value = "1.0")
    @StudentAnnotation2(value="4.0")
    public static void main(@StudentAnnotation2("4.0") String[] args){

    }
}
