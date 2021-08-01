package template;

/**
 * 造房子模板方法
 * buildHouse:定义了造房子的顺序，但是无法确定造房子的某个功能的具体实现
 */
public abstract class BuildHouseTemplate {

    public abstract void buildWindows();
    public abstract void buildWall();
    public abstract void buildFundation();

    //模板方法:将使用不同的方法完成对房子的建造
    public void buildHouse(){
        System.out.println("开始造房子");
        buildFundation();
        buildWall();
        buildWindows();
    }

}
