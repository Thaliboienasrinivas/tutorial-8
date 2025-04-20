import java.util.concurrent.*;

class SumNaturalNumbers {
    public static void main(String[] args) {
        ExecutorService executor = Executors.newSingleThreadExecutor();

        int N = 100;
        Callable<Integer> task = () -> {
            int sum = 0;
            for (int i = 1; i <= N; i++) {
                sum += i;
            }
            return sum;
        };

        Future<Integer> result = executor.submit(task);

        try {
            System.out.println("Sum of first " + N + " natural numbers: " + result.get());
        } catch (InterruptedException | ExecutionException e) {
            e.printStackTrace();
        } finally {
            executor.shutdown();
        }
    }
}
