package zadanie20;

import java.util.HashMap;
import java.util.Map;

public class Liczby {
    private int fromNumber = 1;
    private int toNumber = 30;

    public Map<Integer, Boolean> mapIntToPrime() {
        Map<Integer, Boolean> primes = new HashMap<>();
        for (int i = fromNumber; i < toNumber; i++) {
            primes.put(i, isPrime(i));
        }

        return primes;
    }

    boolean isPrime(int n) {
        int start = fromNumber;
        if (fromNumber <= 1) {
            start = 2;
        }
        for (int i = start; i < toNumber; i++) {
            if (i != n && n % i == 0) {
                return false;
            }
        }

        return true;
    }
}

     class Main {

        public static void main(String[] args) {
            Liczby pc = new Liczby();
            for (int i = 1; i <= 30; i++) {
                System.out.println(i + ": " + pc.isPrime(i));
            }
            Liczby liczby = new Liczby();

            Map<Integer, Boolean> primes = pc.mapIntToPrime();
            for (Map.Entry<Integer, Boolean> prime : primes.entrySet()) {
                System.out.println(prime.getKey() + ": " + prime.getValue());
            }
        }
    }















