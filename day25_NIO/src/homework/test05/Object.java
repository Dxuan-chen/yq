package homework.test05;

/**
 * 功能描述：
 *
 * @author 陈铉锋
 * @date 2021/7/19
 */
public class Object {
    private java.lang.Object propertyName;

    public Object(java.lang.Object propertyName) {
        this.propertyName = propertyName;
    }

    public Object() {
    }

    public java.lang.Object getPropertyName() {
        return propertyName;
    }

    public void setPropertyName(java.lang.Object propertyName) {
        this.propertyName = propertyName;
    }

    @Override
    public String toString() {
        return "Object{" +
                "propertyName='" + propertyName + '\'' +
                '}';
    }
}
