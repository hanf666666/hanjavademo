package ali面试.如果剩余的苹果不够猴子每次拿的数量;

/**
 * to do
 *
 * @author Hj
 * @date 2022/3/10
 */
public class CreateTh extends Thread {
    public Mk mk;
    public volatile static int appCount = 9;

    public CreateTh(Mk mk) {
        this.mk = mk;

    }


    public void run() {
        while (appCount > 0 ) {
            appCount = appCount - mk.num;
            if(appCount<0){
                System.out.println("还剩：" +( appCount + mk.num )+ " 个苹果");

            }else{
                System.out.println("mk猴子"+mk.name+"拿了个"+mk.num+"苹果"+"还剩：" + appCount + " 个苹果");

            }
        }


    }
}


