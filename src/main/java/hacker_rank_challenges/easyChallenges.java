package hacker_rank_challenges;

import com.google.common.collect.HashBiMap;

import java.util.*;

public class easyChallenges {
    public static void main(String args[]) {
        int[] input = new int[]{1, 1, 1, 0, 1, 1, 0, 0, 0, 0};
        System.out.println(jumpingOnClouds(input, 3));
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

    static void countApplesAndOranges(int s, int t, int a, int b, int[] apples, int[] oranges) {
        int appleCounter = 0;
        int orangeCounter = 0;
        for (int apple : apples) {
            if ((a + apple) >= s && (a + apple) <= t) {
                appleCounter++;
            }
        }
        for (int orange : oranges) {
            if ((b + orange) >= s && (b + orange) <= t) {
                orangeCounter++;
            }
        }
        System.out.println(appleCounter);
        System.out.println(orangeCounter);
    }

    static String kangaroo(int x1, int v1, int x2, int v2) {
        String encounter = "NO";
        if (v1 == v2) {
            return encounter;
        } else if ((x2 - x1) % (v2 - v1) == 0 && (x2 - x1) * (v2 - v1) < 0) {
            encounter = "YES";
        }
        return encounter;
    }

    static int[] breakingRecords(int[] scores) {
        int counterHighest = 0;
        int counterLowest = 0;
        int highest = scores[0];
        int lowest = scores[0];
        int[] output = new int[2];
        for (int score : scores) {
            if (score > highest) {
                highest = score;
                counterHighest++;
            } else if (score < lowest) {
                lowest = score;
                counterLowest++;
            }
        }
        output[0] = counterHighest;
        output[1] = counterLowest;
        return output;
    }

    static int divisibleSumPairs(int n, int k, int[] ar) {
        int counter = 0;
        for (int i = 0; i < ar.length; i++) {
            for (int j = i + 1; j < ar.length; j++) {
                if ((ar[i] + ar[j]) % k == 0) {
                    counter++;
                }
            }
        }
        return counter;
    }

//    static int birthday(ArrayList<Integer> s, int d, int m) {
//        int output = 0;
//        for (int i = 0; i < s.size(); i++) {
//            int sum = 0;
//            for (int j = 0; j < m; j++) {
//                sum += s.get(j+i);
//            }
//            if (sum == d) {
//                output++;
//            }
//        }
//        return output;
//    }

    static int migratoryBirds(int[] arr) {
        int winner = 0;
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int bird : arr) {
            int count = map.containsKey(bird) ? map.get(bird) : 0;
            map.put(bird, count + 1);
        }
//        for (Map.Entry<Integer, Integer> bird : map.entrySet()) {
//            if (bird.getValue() > winner) {
//                winner = bird.getKey();
//            }
//        }
//        return winner;
        // Found looking through discussions on the problem, but don't really know how it works
        return Collections.max(map.entrySet(), Map.Entry.comparingByValue()).getKey();
    }

    static void bonAppetit(int[] bill, int k, int b) {
        int dinner = 0;
        for (int i = 0; i < bill.length; i++) {
            if (i == k) {
                continue;
            }
            dinner += bill[i];
        }
        dinner = dinner / 2;
        if (dinner == b) {
            System.out.println("Bon Appetit");
        } else {
            System.out.println(b - dinner);
        }
    }

    static int sockMerchant(int n, int[] ar) {
        int pairs = 0;
        HashSet<Integer> socks = new HashSet<>();
        for (int i = 0; i < ar.length; i++) {
            if (!socks.contains(ar[i])) {
                socks.add(ar[i]);
            } else {
                pairs++;
                socks.remove(ar[i]);
            }
        }
        return pairs;
    }

    static int pageCount(int n, int p) {
        int backCount = 0;
        int frontCount = (p / 2);
        if (n - p == 1 && n % 2 == 0) {
            backCount = (n - p);
        } else if (n - p == 1 && n % 2 != 0) {
            return backCount;
        } else {
            backCount = (n - p) / 2;
        }
        return Math.min(frontCount, backCount);
    }

    public static int countingValleys(int steps, String path) {
        String[] newPath = path.split("");
        int counter = 0;
        int hike = 0;
        for (String direction : newPath) {
            if (direction.equals("U")) {
                hike++;
            } else if (direction.equals("D")) {
                hike--;
            }
            if ((hike == 0 && direction.equals("U"))) {
                counter++;
            }
        }
        return counter;
    }

    static int getMoneySpent(int[] keyboards, int[] drives, int b) {
        int cost;
        int largestCost = 0;
        for (int i = 0; i < keyboards.length; i++) {
            for (int j = 0; j < drives.length; j++) {
                cost = keyboards[i] + drives[j];
                if (cost <= b && cost > largestCost) {
                    largestCost = cost;
                }
            }
        }
        if(largestCost == 0) {
            return -1;
        } else {
            return largestCost;
        }
    }

    static String catAndMouse(int x, int y, int z) {
        String output = "";
        if (Math.abs(z - x) > Math.abs(z - y)) {
            output = "Cat B";
        } else if (Math.abs(z - x) < Math.abs(z - y)) {
            output = "Cat A";
        } else {
            output = "Mouse C";
        }
        return output;
    }

    static int hurdleRace(int k, int[] height) {
        int doses = 0;
        int maxHurdle = 0;
        for (int hurdle : height) {
            if (hurdle > k && hurdle > maxHurdle) {
                doses = hurdle - k;
                maxHurdle = hurdle;
            }
        }
        return doses;
    }

    static int designerPdfViewer(int[] h, String word) {
        String[] alphabet = new String[]{"a", "b", "c", "d", "e", "f", "g", "h", "i", "j", "k",
                "l", "m", "n", "o", "p", "q", "r", "s", "t", "u", "v", "w", "x", "y", "z",};
        String[] letters = word.split("");
        int output = letters.length;
        int largestHeight = 0;
        for (String letter : letters) {
            for (String alphaLetter : alphabet) {
                if (letter.equals(alphaLetter)) {
                    int indexHeight;
                    indexHeight = Arrays.asList(alphabet).indexOf(alphaLetter);
                    if (h[indexHeight] > largestHeight) {
                        largestHeight = h[indexHeight];
                    }
                }
            }
        }
        output = largestHeight * output;
        return output;
    }

    static int utopianTree(int n) {
        int height = 1;
        if (n != 0) {
            for (int i = 1; i <= n; i++) {
                if (i % 2 == 0) {
                    height++;
                } else {
                    height = height * 2;
                }
            }
        }
        return height;
    }

    static String angryProfessor(int k, int[] a) {
        int presentStudents = 0;
        for (int present : a) {
            if (present <= 0) {
                presentStudents++;
            }
        }
        return (presentStudents >= k) ? "NO" : "YES";
    }

    static int beautifulDays(int i, int j, int k) {
        int counter = 0;
        for (int day = i; day <= j; day++) {
            StringBuilder temp = new StringBuilder();
            temp.append(day);
            temp = temp.reverse();
            String temp1 = temp.toString();
            int reverse = Integer.parseInt(temp1);
            int beautiful = Math.abs(day - reverse);
            if (beautiful % k == 0) {
                counter++;
            }
        }
        return counter;
    }

    static int viralAdvertising(int n) {
        double totalLikes = 0;
        double likes;
        double recipients = 5;
        for (int i = 1; i <= n; i++) {
            likes = Math.floor(recipients/2);
            recipients = 3 * likes;
            totalLikes += likes;
        }
        return (int) totalLikes;
    }

    static int saveThePrisoner(int n, int m, int s) {
        return (s + m - 2) % n + 1;
    }

//    static int[] permutationEquation(int[] p) {
//        System.out.println(p.length);
//        int[] output = new int[p.length];
//        for (int i = 1; i < p.length; i++) {
//            output[i - 1] = p[p[i] - 1] - 1;
//        }
//        return output;
//    }

    static int jumpingOnClouds(int[] c, int k) {
        int totalEnergy = 100;
        int n = c.length;
        int i = k % n;
        totalEnergy -= c[i] * 2 + 1;
        while (i != 0) {
            i = (i + k) % n;
            totalEnergy--;
            if (c[i] == 1) {
                totalEnergy = totalEnergy - 2;
            }
        }
        return totalEnergy;
    }
}
