package hacker_rank_challenges;

public class easyChallenges {
    public static void main(String args[]) {
        int[][] poop = new int[][] {{11, 2, 4}, {4, 5, 6}, {10, 8, -12}};
        diagonalDifference(poop);
        System.out.println(diagonalDifference(poop));
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

    
}
