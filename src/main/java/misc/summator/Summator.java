package misc.summator;

import java.math.BigInteger;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.*;

public class Summator {
    private final int threadCount;

    public Summator(int threadCount) {
        this.threadCount = threadCount;
    }

    public BigInteger sum(BigInteger number) {

        List<CompletableFuture<BigInteger>> tasks = new ArrayList<>(threadCount);

        BigInteger toNum = BigInteger.ZERO;
        for (int i = 0; i < threadCount; i++) {
            BigInteger fromNum = toNum.add(BigInteger.ONE);
            toNum = number.multiply(BigInteger.valueOf(i+1)).divide(BigInteger.valueOf(threadCount));
            BigInteger finalToNum = toNum;
            tasks.add(
                    CompletableFuture.supplyAsync(() -> {
                        BigInteger result = BigInteger.ZERO;
                        for (BigInteger count = fromNum; count.compareTo(finalToNum) <= 0; count = count.add(BigInteger.ONE)) {
                            result = result.add(count);
                        }
                        return result;
                    }));
        }

        BigInteger result = BigInteger.ZERO;
        try {
            for (CompletableFuture<BigInteger> task : tasks) {
                result = result.add(task.get());
            }
        } catch (ExecutionException | InterruptedException e) {
            throw new IllegalStateException(e);
        }
        return result;
    }

}
