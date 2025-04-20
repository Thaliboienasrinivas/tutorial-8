import java.util.concurrent.*;

class SumTask {
    public static void main(String[] args) {
        ExecutorService executor = Executors.newSingleThreadExecutor();

        Callable<Integer> task = () -> {
            int a = 10, b = 20;
            return a + b;
        };

        Future<Integer> result = executor.submit(task);

        try {
            System.out.println("Sum: " + result.get());
        } catch (InterruptedException | ExecutionException e) {
            e.printStackTrace();
        } finally {
            executor.shutdown();
        }
    }
}
