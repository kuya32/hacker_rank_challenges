package hacker_rank_challenges;

import java.util.*;

public class easyChallenges {
    public static void main(String args[]) {
        LinkedList<Integer> list = new LinkedList<>();
        list.add(1);
        list.add(2);
        list.add(3);
        System.out.println(list);
        System.out.println(removeDuplicates(list));
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

    static int[] reverseArray(int[] a) {
        int temp;
        for (int i = 0; i < a.length / 2; i++) {
            temp = a[i];
            a[i] = a[a.length - i - 1];
            a[a.length - i - 1] = temp;
        }
        return a;
    }

    static int hourglassSum(int[][] arr) {
        int largestSum = -64;
        int sum;
        for (int i = 0; i < 4; i++) {
            for (int j = 0; j < 4; j++) {
                sum =
                        arr[i][j] + arr[i][j + 1] + arr[i][j + 2] + arr[i + 1][j + 1] + arr[i + 2][j] + arr[i + 2][j + 1] + arr[i + 2][j + 2];
                if (sum > largestSum) {
                    largestSum = sum;
                }
            }
        }
        return largestSum;
    }

    public static List<Integer> rotateLeft(int d, List<Integer> arr) {
        while (d != 0) {
            rotateOneLeft(arr);
            d--;
        }
        return arr;
    }

    public static void rotateOneLeft(List<Integer> arr) {
        int i;
        int temp;
        temp = arr.get(0);
        for (i = 0; i < arr.size() - 1; i++){
            arr.set(i, arr.get(i + 1));
        }
        arr.set(i, temp);
    }

    static int[] matchingStrings(String[] strings, String[] queries) {
        int[] result = new int[queries.length];

        for(int i = 0; i < queries.length; i++) {
            for (String string : strings) {
                if (queries[i].equals(string)) {
                    result[i]++;
                }

            }
        }
        return result;
    }

    static void printLinkedList(Node head) {
        Node n = head;
        while (n != null) {
            System.out.println(n.data);
            n = n.next;
        }
    }

    static Node insertNodeAtTail(Node head, int data) {
        Node newNode = new Node(data);
        if (head == null) {
            head = newNode;
        } else {
            Node temp;
            temp = head;
            while (temp.next != null) {
                temp = temp.next;
            }
            temp.next = newNode;
        }
        newNode.next = null;
        return head;
    }

    static Node insertNodeAtHead(Node llist, int i, int data) {
        Node newNode = new Node(data);
        newNode.next = llist;
        llist = newNode;
        return llist;
    }

    static Node insertNodeAtPosition(Node head, int data, int position) {
        Node temp = head;
        Node newNode = new Node(data);
        if (head == null) {
            return newNode;
        }
        if (position == 0) {
            newNode.next = head;
            return newNode;
        }
        int counter = 0;
        while (counter++ < position - 1) {
            temp = temp.next;
        }
        newNode.next = temp.next;
        temp.next = newNode;
        return head;
    }

    static Node deleteNode(Node head, int position) {
        Node temp = head;
        if (position == 0) {
            head = head.next;
        }
        int counter = 0;
        while (counter++ < position - 1) {
            temp = temp.next;
        }
        temp.next = temp.next.next;
        return head;
    }

    static void reversePrintStack(Node head) {
        Stack<Node> stack = new Stack<>();
        if (head != null) {
            Node temp = head;
            while (temp != null) {
                stack.push(temp);
                temp = temp.next;
            }
            while(!stack.isEmpty()) {
                System.out.println(stack.pop().data);
            }
        }
    }

    static void reversePrint(Node head) {
        Node temp = head;
        Node next = null;
        Node prev = null;
        while (temp != null) {
            next = temp.next;
            temp.next = prev;
            prev = temp;
            temp = next;
        }
        head = prev;
    }

    static boolean compareLists(Node head1, Node head2) {
        Node temp = head1;
        Node temp2 = head2;
        if (temp == null && temp2 == null) {
            return true;
        } else if ((temp == null && temp2 != null) || temp != null && temp2 == null) {
            return false;
        } else {
            while (temp.next != null) {
                if (temp.data != temp2.data || temp2.next == null) {
                    return false;
                }
                temp = temp.next;
                temp2 = temp2.next;
            }
            return temp2.next == null;
        }
    }

    static Node mergeLists(Node head1, Node head2) {
        Node temp = head1;
        Node temp2 = head2;
        if (temp == null && temp2 == null) {
            return null;
        } else if (temp == null && temp2 != null) {
            return temp2;
        } else if (temp != null && temp2 == null) {
            return temp;
        } else {
            if (temp.data < temp2.data) {
                temp.next = mergeLists(temp.next, temp2);
                return temp;
            } else {
                temp2.next = mergeLists(temp, temp2.next);
                return temp2;
            }
        }
    }

    static int getNode(Node head, int positionFromTail) {
        int length = 0;
        Node temp = head;

        while (temp != null) {
            temp = temp.next;
            length++;
        }

        if(length > positionFromTail) {
            temp = head;
            for (int i = 1; i < length - positionFromTail ; i++) {
                temp = temp.next;
            }
        }
        return temp.data;
    }

    static Node removeDuplicates(Node head) {
        Node temp = head;
        while (temp.next != null) {
            if (temp.data == temp.next.data) {
                temp.next = temp.next.next;
            } else {
                temp = temp.next;
            }
        }
        return head;
    }

//    static boolean hasCycle(Node head) {
//        Node temp = head;
//        if (temp == null) {
//            return false;
//        }
//        HashSet<Integer> set = new HashSet<>();
//        while (temp.next != null) {
//            if (!set.add(temp.data)) {
//                return true;
//            }
//            temp = temp.next;
//        }
//        return false;
//    }

    static int findMergeNode(Node head1, Node head2) {
        int lengthHead1 = findLength(head1);
        int lengthHead2 = findLength(head2);
        int d = lengthHead2 - lengthHead1;
        if (lengthHead1 > lengthHead2) {
            Node temp = head1;
            head1 = head2;
            head2 = temp;
            d = lengthHead1 - lengthHead2;
        }

        for (int i = 0; i < d; i++) {
            head2 = head2.next;
        }

        while (head1 != null && head2 != null) {
            if (head1 == head2) {
                return head1.data;
            }
            head1 = head1.next;
            head2 = head2.next;
        }
        return head1.data;
    }

    static Node sortedInsert(Node head, int data) {
        Node newNode = new Node(data);
        if (head == null) {
            return newNode;
        } else if (newNode.data <= head.data) {
            newNode.next = head;
            head.prev = newNode;
            return newNode;
        } else {
            Node temp = sortedInsert(head.next, data);
            head.next = temp;
            temp.prev = head;
            return head;
        }
    }

    static Node reverse(Node head) {
        Node temp = head;
        Node newHead = head;
        if (temp == null) {
            return null;
        }
        while (temp != null) {
            Node prev = temp.prev;
            temp.prev = temp.next;
            temp.next = prev;
            newHead = temp;
            temp = temp.prev;
        }
        return newHead;
    }

    public static void preOrder(Node root) {
        if (root == null) return;
        System.out.print(root.data + " ");
        preOrder(root.left);
        preOrder(root.right);
    }

    static int findLength(Node head) {
        int length = 0;
        while (head != null) {
            length++;
            head = head.next;
        }
        return length;
    }

    public static void postOrder(Node root) {
        if (root == null) return;
        postOrder(root.left);
        postOrder(root.right);
        System.out.print(root.data + " ");
    }

    public static int height(Node root) {
        if (root == null) return -1;

        int left = 1 + height(root.left);
        int right = 1 + height(root.right);

        return left > right ? left:right;
    }

    public static void topView(Node root) {
        leftView(root.left);
        System.out.print(root.data + " ");
        rightView(root.right);
    }

    public static void leftView(Node root) {
        if (root == null) return;
        leftView(root.left);
        System.out.print(root.data + " ");
    }

    public static void rightView(Node root) {
        if (root == null) return;
        System.out.print(root.data + " ");
        rightView(root.right);

    }

    public static void levelOrder(Node root) {
        Node current = root;
        if (current == null) return;
        Queue<Node> que = new LinkedList<>();
        que.add(current);
        while (!que.isEmpty()) {
            current = que.peek();
            que.remove();
            System.out.print(current.data + " ");
            if (current.left != null) {
                que.add(current.left);
            }
            if (current.right != null) {
                que.add(current.right);
            }
        }
    }

    public static Node insert(Node root,int data) {
        if (root == null) {
            Node newNode = new Node(data);
            root = newNode;
            root.left = null;
            root.right = null;
            root = newNode;
        } else if (root.data > data) {
            root.left = insert(root.left, data);
        } else {
            root.right = insert(root.right, data);
        }
        return root;
    }

    public static Node lca(Node root, int v1, int v2) {
        while (root != null) {
            if (root.data > v1 && root.data > v2) {
                root = root.left;
            } else if (root.data < v1 && root.data < v2) {
                root = root.right;
            } else {
                break;
            }
        }
        return root;
    }

    void decode(String s, Node root) {
        Node temp = root;
        String[] numbers = s.split("");
        for (int i = 0; i < numbers.length; i++) {
            temp = numbers[i].equals("0") ? temp.left : temp.right;
            if (temp.left == null && temp.right == null) {
                System.out.print(temp.data);
                temp = root;
            }
        }
    }

    boolean checkBST(Node root) {
        Node temp = root;
        return false;
    }



    public static class Node {
        int data;
        Node next;
        Node prev;
        Node left;
        Node right;
        Node(int d) {
            data = d;
            next = null;
            prev = null;
            left = null;
            right = null;
        }
    }


}
