import java.util.Arrays;
import java.util.Scanner;

public class MultiThread {
    private static int n, m, max, min;
    private static int[][] a;
    private static FindMin[] th;


    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("n = ");
        n = sc.nextInt();
        System.out.print("m = ");
        m = sc.nextInt();

        th = new FindMin[n];

        a = new int[n][m];

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                System.out.print("a["+i+"]["+j+"] = ");
                a[i][j] = sc.nextInt();
            }
        }

        for (int i = 0; i < n; i++) {
            System.out.println(i+": "+Arrays.toString(a[i]));
            th[i] = new FindMin(a[i]);
            th[i].start();
        }
        for (int i = 0; i < n; i++) {
            try {
                th[i].join();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            if(i==0) max = th[i].getMin();
            else {
                min = th[i].getMin();
                if (min > max) max = min;
            }
        }
        System.out.println(max);

    }

}
