package misc.summator;
import java.math.BigInteger;
import java.util.function.UnaryOperator;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class SummatorDemo {

    static final int[] THREADS_COUNTS = {4, 1, 2, 10};
    static final long[] NUMBERS_TO_SUM = {10, 100, 1_000, 100_000, 1_000_000};

    public static void main(String[] args) {

        for (int i = 0; i < THREADS_COUNTS.length; i++) {
            System.out.println("\nТест для количества потоков: " + THREADS_COUNTS[i]);
            Summator summator = new Summator(THREADS_COUNTS[i]);
            for (int j = 0; j < NUMBERS_TO_SUM.length; j++) {
                long startTime = System.currentTimeMillis();
                BigInteger result = summator.sum(BigInteger.valueOf(NUMBERS_TO_SUM[j]));
                System.out.println("sum(" + NUMBERS_TO_SUM[j] + ") = " + result + "; " +
                        (System.currentTimeMillis() - startTime) + " ms");
            }
        }


        System.out.println("\nТест Stream:");
        for (int j = 0; j < NUMBERS_TO_SUM.length; j++) {
            long startTime = System.currentTimeMillis();
            BigInteger result = Stream.iterate(BigInteger.ONE, b -> b.add(BigInteger.ONE)).limit(NUMBERS_TO_SUM[j]).reduce(BigInteger::add).orElse(BigInteger.ZERO);
            System.out.println("sum(" + NUMBERS_TO_SUM[j] + ") = " + result + "; " +
                    (System.currentTimeMillis() - startTime) + " ms");
        }

        System.out.println("\nТест parallelStream:");
        for (int j = 0; j < NUMBERS_TO_SUM.length; j++) {
            long startTime = System.currentTimeMillis();
            BigInteger result = Stream.iterate(BigInteger.ONE, b -> b.add(BigInteger.ONE)).parallel().limit(NUMBERS_TO_SUM[j]).reduce(BigInteger::add).orElse(BigInteger.ZERO);
            System.out.println("sum(" + NUMBERS_TO_SUM[j] + ") = " + result + "; " +
                    (System.currentTimeMillis() - startTime) + " ms");
        }
    }

}

/*
Тест для количества потоков: 4
sum(10) = 55; 23 ms
sum(100) = 5050; 0 ms
sum(1000) = 500500; 2 ms
sum(100000) = 5000050000; 23 ms
sum(1000000) = 500000500000; 156 ms

Тест для количества потоков: 1
sum(10) = 55; 0 ms
sum(100) = 5050; 0 ms
sum(1000) = 500500; 0 ms
sum(100000) = 5000050000; 8 ms
sum(1000000) = 500000500000; 71 ms

Тест для количества потоков: 2
sum(10) = 55; 0 ms
sum(100) = 5050; 0 ms
sum(1000) = 500500; 0 ms
sum(100000) = 5000050000; 3 ms
sum(1000000) = 500000500000; 41 ms

Тест для количества потоков: 10
sum(10) = 55; 1 ms
sum(100) = 5050; 0 ms
sum(1000) = 500500; 0 ms
sum(100000) = 5000050000; 6 ms
sum(1000000) = 500000500000; 48 ms

Тест Stream:
sum(10) = 55; 3 ms
sum(100) = 5050; 1 ms
sum(1000) = 500500; 1 ms
sum(100000) = 5000050000; 20 ms
sum(1000000) = 500000500000; 171 ms

Тест parallelStream:
sum(10) = 55; 22 ms
sum(100) = 5050; 4 ms
sum(1000) = 500500; 4 ms
sum(100000) = 5000050000; 28 ms
sum(1000000) = 500000500000; 291 ms
 */
