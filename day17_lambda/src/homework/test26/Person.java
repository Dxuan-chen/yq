package homework.test26;

/**
 *
 */
public class Person {
    private String name;
    private int lifeValue;

    public Person() {
    }

    public Person(String name, int lifeValue) {
        if(lifeValue < 0){
            throw new NoLifeValueExption("生命值不能为负数:"+lifeValue);
        }
        this.name = name;
        this.lifeValue = lifeValue;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setLifeValue(int lifeValue) {
        if(lifeValue < 0){
            throw new NoLifeValueExption("生命值不能为负数:"+lifeValue);
        }
        this.lifeValue = lifeValue;
    }

    public String getName() {
        return name;
    }

    public int getLifeValue() {
        return lifeValue;
    }

    @Override
    public String toString() {
        return "Person{" +
                "name='" + name + '\'' +
                ", lifeValue=" + lifeValue +
                '}';
    }
}
