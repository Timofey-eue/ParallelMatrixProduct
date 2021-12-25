import java.math.BigDecimal;
import java.util.Arrays;
import java.util.Random;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Main {

    public static void main(String[] args) throws InterruptedException {
        UsualMatrix a = new UsualMatrix(1111, 1111, 0);
        a.randNum();
  //      System.out.println(a.toString());
        UsualMatrix b = new UsualMatrix(1111,1111, 0);
        b.randNum();
  //      System.out.println(b.toString());
        UsualMatrix res1;
        UsualMatrix res2;


        long startTime = System.currentTimeMillis();
        res1 = a.mult(b);
        System.out.println("__________________________________");
  //      System.out.println(res1.toString());
        long estimatedTime = System.currentTimeMillis() - startTime;
        System.out.println("Время обычного умножения: " + estimatedTime + "ms");

        ParallelMatrixProduct test = new ParallelMatrixProduct(a, b, Runtime.getRuntime().availableProcessors());
        long startTime1 = System.currentTimeMillis();
        res2 = test.parallelProduct();
  //      System.out.println(res2.toString());
        long estimatedTime1 = System.currentTimeMillis() - startTime1;
        System.out.println("Время с потоком: " + estimatedTime1 + "ms");
    }

}