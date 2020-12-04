package hacker_rank_challenges;

import java.util.ArrayList;

public class easyChallenges {
    public static void main(String args[]) {
        String s = "07:05:45AM";
        System.out.println(timeConversion(s));
    }

    public static int diagonalDifference(int[][] arr) {
        int absolute;
        int num = 0;
        int primeDiagonal = 0;
        int secondDiagonal = 0;
        for (int i = 0; i < arr.length; i++) {
            for (int j = num; j < arr[i].length; j++) {
                primeDiagonal += arr[i][j];
                break;
            }
            num += 1;
        }

        num = 0;

        for (int i = 0; i < arr.length; i++) {
            for (int j = arr[i].length - 1 - num; j >= 0; j--) {
                secondDiagonal += arr[i][j];
                break;
            }
            num += 1;
        }
        absolute = Math.abs(primeDiagonal - secondDiagonal);
        return absolute;
    }

    static void plusMinus(int[] arr) {
        double size = arr.length;
        double negative = 0;
        double positive = 0;
        double zero = 0;

        for (int i = 0; i < size; i++) {
            if (arr[i] < 0) {
                negative++;
            } else if (arr[i] > 0) {
                positive++;
            } else {
                zero++;
            }
        }
        System.out.format("%.6f" + "%n" +
                "%.6f" + "%n" +
                "%.6f", positive/size, negative/size, zero/size);
    }

//    static void staircase(int n) {
//        String symbol = "# ";
//        for (int i = 1; i <= n; i++) {
//            for (int j = 0; j < i; j++) {
//                System.out.format("%s", symbol);
//            }
//            System.out.println("\n");
//        }
//
//    }

    static void miniMaxSum(long[] arr) {
        for (int i = 0; i < arr.length; i++) {
            for (int j = i + 1; j <arr.length; j++) {
                long temp = 0;
                if (arr[i] > arr[j]) {
                    temp = arr[i];
                    arr[i] = arr[j];
                    arr[j] = temp;
                }
            }
        }
        long min = 0;
        long max = 0;
        if (arr.length <= 1) {
            min = arr[0];
            max = arr[0];
        }
        for (int i = 0; i < arr.length - 1; i++) {
            min += arr[i];
        }
        for (int i = 1; i < arr.length; i++) {
            max += arr[i];
        }
        System.out.println(min + " " + max);
    }

    public static int birthdayCakeCandles(ArrayList<Integer> candles) {
        int tallest = 0;
        for (Integer candle : candles) {
            if (candle > tallest) {
                tallest = candle;
            }
        }
        System.out.println(tallest);
        int counter = 0;
        for (Integer candle : candles) {
            if (candle == tallest) {
                counter++;
            }
        }
        return counter;
    }

    static String timeConversion(String s) {
        String output = "";
        if (s.contains("AM")) {
            String[] arr = s.split("AM");
            for (int i = 0; i < arr.length; i++) {
                output += arr[i];
            }
        }
        
        return output;
    }
}
