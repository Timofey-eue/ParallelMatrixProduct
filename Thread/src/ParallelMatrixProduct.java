import java.math.BigDecimal;
import java.util.Arrays;
import java.util.Random;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class ParallelMatrixProduct {
    private int threads;
    private UsualMatrix x;
    private UsualMatrix y;
    private UsualMatrix result;

    private class myThread implements Runnable {
        private int index1;
        private int index2;

        public myThread(int i, int j) {
            this.index1 = i;
            this.index2 = j;
        }

        @Override
        public void run() {
            if (x.col == y.row) {
                for (int k = 0; k < y.col; k++) {
                    result.setEl(this.index1, this.index2, result.getEl(this.index1, this.index2) + x.getEl(this.index1, this.index2) * y.getEl(k, this.index2));
                }
            }
            else {
                System.out.println("-1000");
            }
        }
    }

    ParallelMatrixProduct(UsualMatrix x, UsualMatrix y, int threads) {
        this.x = x;
        this.y = y;
        this.threads = threads;
        this.result = new UsualMatrix(x.row, y.col, 0);
    }

    public UsualMatrix parallelProduct() throws InterruptedException {
        ExecutorService executorService = Executors.newFixedThreadPool(this.threads);
        for (int i = 0; i < x.row; i++) {
            for (int j = 0; j < y.col; j++) {
                executorService.execute(new myThread(i, j));
            }
        }
        executorService.shutdown();
        executorService.awaitTermination(1, TimeUnit.MILLISECONDS);
        return this.result;
    }
}