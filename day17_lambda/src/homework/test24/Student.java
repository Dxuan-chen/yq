package homework.test24;

/**
 *
 */
public class Student {
    private String name;
    private int score;

    public Student() {
    }

    public Student(String name, int score) {
        if(score < 0){
            throw new NoScoreException("分数不能为负数:"+score);
        }
        this.name = name;
        this.score = score;
    }

    public void setScore(int score) {
        if(score < 0){
            throw new NoScoreException("分数不能为负数:"+score);
        }
        this.score = score;
    }

    public void setName(String name) {
        this.name = name;
    }
}
