package hacker_rank_challenges;

import com.google.common.collect.HashBiMap;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;

public class easyChallenges {
    public static void main(String args[]) {
        ArrayList<Integer> grades = new ArrayList<>();
        grades.add(73);
        grades.add(67);
        grades.add(38);
        grades.add(33);
        System.out.println(gradingStudents(grades));
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
        if (s.contains("AM") && s.contains("12")) {
            String change = s.substring(0, 2);
            int num = Integer.parseInt(change);
            int newNum = num - 12;
            String newString = Integer.toString(newNum);
            String newString2 = newString + "0";
            String newS = s.replace(change, newString2);
            String[] pm = newS.split("AM");
            for (String value : pm) {
                output += value;
            }
        } else if (s.contains("AM")) {
            String[] am = s.split("AM");
            for (String value : am) {
                output += value;
            }
        } else if (s.contains("PM") && s.contains("12")) {
            String[] pm = s.split("PM");
            for (String value : pm) {
                output += value;
            }
        } else {
            String change = s.substring(0, 2);
            int num = Integer.parseInt(change);
            int newNum = num + 12;
            String newString = Integer.toString(newNum);
            String newS = s.replace(change, newString);
            String[] pm = newS.split("PM");
            for (String value : pm) {
                output += value;
            }
        }
        return output;
    }

    static String gameOfThrones(String s) {
        String answer = "";
        char[] letter = s.toCharArray();
        char[] letter2 = s.toCharArray();
        boolean moreThanOne = false;
        HashMap<Character, Integer> map = new HashMap<Character, Integer>();
        HashMap<Character, Integer> map2 = new HashMap<Character, Integer>();
        for (Character letters : letter) {
            int count = map.containsKey(letters) ? map.get(letters) : 0;
            map.put(letters, count + 1);
        }
        for (Character letters : letter) {
            if (map.get(letters) > 1) {
                moreThanOne = true;
                break;
            }
        }
        for (int i = 0; i < letter2.length / 2; i++) {
            char temp = letter2[i];
            letter2[i] = letter2[letter2.length - 1 - i];
            letter2[letter2.length - 1 - i] = temp;
        }
        for (Character letters : letter2) {
            int count = map2.containsKey(letters) ? map2.get(letters) : 0;
            map2.put(letters, count + 1);
        }
        System.out.println(map.values());
        System.out.println(map2.values());
        answer =
                new ArrayList<>(map.values()).equals(new ArrayList<>(map2.values())) &&
                        moreThanOne ?
                "YES" :
                "NO";
        return answer;
    }

    public static ArrayList<Integer> gradingStudents(ArrayList<Integer> grades) {
        ArrayList<Integer> numbers = new ArrayList<Integer>();
        for (int grade : grades) {
            if (grade < 38 || grade % 5 < 3) {
                numbers.add(grade);
            } else {
                numbers.add(grade + (5 - (grade % 5)));
            }
        }
        return numbers;
    }
}
