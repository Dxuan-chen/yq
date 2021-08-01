package qq;

import java.io.Serializable;

/**
 * 功能描述：
 *
 * @author 陈铉锋
 * @date 2021/7/21
 */
public class Msg implements Serializable {
    private String srcIp;
    private String dstIp;
    private String message;

    public Msg(String srcIp, String dstIp, String message) {
        this.srcIp = srcIp;
        this.dstIp = dstIp;
        this.message = message;
    }

    public Msg() {
    }

    public String getSrcIp() {
        return srcIp;
    }

    public void setSrcIp(String srcIp) {
        this.srcIp = srcIp;
    }

    public String getDstIp() {
        return dstIp;
    }

    public void setDstIp(String dstIp) {
        this.dstIp = dstIp;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    @Override
    public String toString() {
        return "Msg{" +
                "srcIp='" + srcIp + '\'' +
                ", dstIp='" + dstIp + '\'' +
                ", message='" + message + '\'' +
                '}';
    }
}
