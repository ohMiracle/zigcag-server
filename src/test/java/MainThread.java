/**
 * @Description:
 * @Author: zhengchang
 * @Date: 2020/9/8
 */
public class MainThread {
    public static void main(String[] args) {
        new Thread(new Runnable() {
            @Override
            public void run() {
                for (int i = 0; i < 20; i++) {
                    System.out.println(Thread.currentThread().getName()+"11");
                }
            }
        }).start();
        new Thread(new Runnable() {
            @Override
            public void run() {
                for (int i = 0; i < 20; i++) {
                    System.out.println(Thread.currentThread().getName()+"22");
                }
            }
        }).start();

        for (int i = 0; i < 20; i++) {
            System.out.println(Thread.currentThread().getName()+"33");
        }
    }
}
