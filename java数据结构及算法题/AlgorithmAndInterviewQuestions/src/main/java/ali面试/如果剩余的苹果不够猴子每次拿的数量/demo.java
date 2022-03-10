package ali面试.如果剩余的苹果不够猴子每次拿的数量;

/**
 * to do
 * 共计9个苹果，有2只猴子，一个猴子每次拿2个苹果，另外一个猴子每次拿3个苹果，
 * 如果剩余的苹果不够猴子每次拿的数量，则猴子停止拿苹果，请用java多线程模拟上面的描述。
 *
 * @author Hj
 * @date 2022/3/8
 */
public class demo {



    public static void main(String[] args) {

        Mk mk1 = new Mk("A",2);
        Mk mk2 = new Mk("B",3);

        CreateTh th1 = new CreateTh(mk1);
        CreateTh th2 = new CreateTh(mk2);

        th1.start();
        th2.start();

    }





}