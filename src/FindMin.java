import java.util.Arrays;

public class FindMin extends Thread {
    private int[] th_a;
    private int min;

    FindMin(int[] in) {
        if (in.length <= 0) {
            return;
        }
        th_a = in;
        System.out.println(Arrays.toString(th_a));
    }

    public void run() {
        min = th_a[0];
        for (int value : th_a) {
            if (value < min) {
                min = value;
            }
        }
    }

    int getMin() {
        System.out.print(Arrays.toString(th_a));
        System.out.println(": "+min);
        return min;
    }
}
