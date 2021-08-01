package lambda.lambda01;

/**
 *
 */
public class Start {
    private Task task;

    public Start(Task task){
        this.task = task;
    }

    public void run(){
        //执行task任务
        task.task();
    }
}
