package org.example;

public class Main {
    public static void main(String[] args) {
        reverseWithStringBuilder("123456789");
        reverseWithInteger(123456789);
        simpleNumbers(445);
    }

    // if we receive our number as string, although we kind of using string operations here with string builder
    private static void reverseWithStringBuilder(String target) {
        System.out.println(new StringBuilder().append(target).reverse());
    }

    private static void reverseWithInteger(int target) {
        if (target < 10) {
            System.out.println(target % 10);
        } else {
            System.out.print(target % 10);
            reverseWithInteger(target / 10);
        }
    }

    private static void simpleNumbers(int target) {
        while(target > 1 && !isPrime(target)) {
            if (target % 2 == 0) {
                System.out.println(2);
                target = target / 2;
            } else {
                for (int i = 3; i < target; i++) {
                    if (isPrime(i) && target % i == 0){
                        System.out.print(i + " and ");
                        target = target / i;
                    }
                }
            }
            System.out.print(target);
        }
    }

    // but solution without loops, maybe we can utilize stream API, but it`s not as easy to came up with solution right now :(

    private static boolean isPrime(int number) {
        if (number <= 1) {
            return false;
        } else {
            for (int i = 2; i < number / 2; i++) {
                if (number % i == 0) {
                    return false;
                }
            }
            return true;
        }
    }
}