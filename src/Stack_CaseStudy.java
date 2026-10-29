import java.util.*;

public class Stack_CaseStudy {
    static void main() {
        Scanner sc = new Scanner(System.in);
        Random random = new Random();

        Stack<Integer> stack = new Stack<>();
        ArrayList<Integer> cards = new ArrayList<>();
        LinkedList<Integer> randomizedCards = new LinkedList<>();
        Queue<Integer> queue = new LinkedList<>();

        IO.println("==LUCKY NINE CARD GAME==");
        IO.println("Enter number of cards (8-40): ");
        int number = sc.nextInt();

        if (number < 8 || number > 40) {
            IO.println("Invalid input!");
            return;
        }

        for (int i = 0; i < number; i++) {
            stack.push(random.nextInt(10)+1);
        }
        while (!stack.isEmpty()) {
            cards.add(stack.pop());
        }

        Collections.shuffle(cards);
        randomizedCards.addAll(cards);
        queue.addAll(randomizedCards);

        int[][] playerCards = new int [4][2];
        int[] totals = new int[4];
        int[] scores = new int[4];

        int player = 0;
        while (player < 4) {
            playerCards[player][0] = queue.poll();
            playerCards[player][1] = queue.poll();

            totals[player] = playerCards[player][0] + playerCards[player][1];
            scores[player] = totals[player] % 10;
            player++;
        }

        IO.println("\n==GAME RESULTS==");
        int bestScore = -1;
        boolean luckyNineFound = false;

        for (int i = 0; i < 4; i++) {
            IO.println("Player " + (i + 1) + ": " + playerCards[i][0] + " + " + playerCards[i][1] + " = " + totals[i] + " | Score: " + scores[i]);

            if (scores[i] == 9) {
                luckyNineFound = true;
            }

            if (scores[i] > bestScore) {
                bestScore = scores[i];
            }
        }

        if (luckyNineFound) {
            bestScore = 9;
        }

        IO.println("\n==WINNER==");
        int winnerCount = 0;

        for (int i = 0; i < 4; i++) {
            if (scores[i] == bestScore) {
                winnerCount++;
            }
        }

        if (winnerCount > 1) {
            IO.println("It's a tie!");
        }

        for (int i = 0; i < 4; i++) {
            if (scores[i] == bestScore) {
                IO.println("Player " + (i + 1) + " is a winner!");
                IO.println("Cards: " + playerCards[i][0] + " and " + playerCards[i][1]);
                IO.println("Total: " + totals[i]);
                IO.println("Final Score: " + scores[i]);

                if (scores[i] == 9) {
                    IO.println("Combination Lucky Nine!");
                } else {
                    IO.println("Combination Closest to Nine.");
                }
                IO.println();
            }
        }
    }
}
