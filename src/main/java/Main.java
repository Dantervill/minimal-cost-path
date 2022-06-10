import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while (true) {
            try {
                System.out.println("\nEnter a path to file or \"1\" to quit: ");
                String filePath = scanner.nextLine();

                if (filePath.equals("1")) {
                    System.out.println("See you next time!");
                    System.exit(0);
                }

                Organiser organiser = new Organiser();
                int[][] costGrid = organiser.getGrid(filePath);

                Solution.getResult(costGrid);
            } catch (Exception ignored) {}
        }
    }
}
