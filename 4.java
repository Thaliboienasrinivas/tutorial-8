java
import java.util.concurrent.RecursiveTask;
import java.util.concurrent.ForkJoinPool;

class MaxTask extends RecursiveTask<Integer> {
    private int[] arr;
    private int start, end;

    public MaxTask(int[] arr, int start, int end) {
        this.arr = arr;
        this.start = start;
        this.end = end;
    }

    protected Integer compute() {
        if (end - start <= 100) { 
            int max = arr[start];
            for (int i = start + 1; i < end; i++) {
                max = Math.max(max, arr[i]);
            }
            return max;
        }

        int mid = (start + end) / 2;
        MaxTask left = new MaxTask(arr, start, mid);
        MaxTask right = new MaxTask(arr, mid, end);

        left.fork();
        int rightMax = right.compute();
        int leftMax = left.join();

        return Math.max(leftMax, rightMax);
    }
}

public class MaxFinder {
    public static void main(String[] args) {
        int[] arr = {3, 9, 27, 2, 16, 35, 20, 41};
        ForkJoinPool pool = new ForkJoinPool();
        int max = pool.invoke(new MaxTask(arr, 0, arr.length));

        System.out.println("Maximum value: " + max);
    }
}
