package adapter;

/**
 * 功能描述：
 *
 * @author 陈铉锋
 * @date 2021/7/20
 */
public class CardReaderAdapter implements Usb {
    Card card;

    //根据传入不同类型的内存卡，读卡器进行读写转换操作
    public CardReaderAdapter(Card card) {
        this.card = card;
    }

    public CardReaderAdapter() {
    }

    @Override
    public void read() {
        System.out.println("读卡器开始工作...");
        card.readCard();//使用内存卡
    }

    @Override
    public void write() {

    }
}
