import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while (true) {
            try {
                System.out.println("\nВведите путь к файлу или \"1\" чтобы выйти: ");
                String filePath = scanner.nextLine();

                if (filePath.equals("1")) {
                    System.out.println("До следующей встречи!");
                    System.exit(0);
                }

                Organiser organiser = new Organiser();
                int[][] costGrid = organiser.getGrid(filePath);

                Solution.getResult(costGrid);
            } catch (Exception ignored) {}
        }
    }
}
