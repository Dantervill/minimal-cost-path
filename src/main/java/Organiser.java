import java.io.File;
import java.io.IOException;
import java.util.*;

public class Organiser {

    /**
     * @return список данных из файла
     */
    private List<String> getFileContent(String path) {
        List<String> fileContent = new ArrayList<>();

        File file = new File(path);

        try (Scanner scn = new Scanner(file)) {
            while (scn.hasNextLine()) {
                fileContent.add(scn.nextLine());
            }
        } catch (IOException e) {
            System.err.println("Path to your file is wrong!");
        }

        return fileContent;
    }

    /**
     * @return строку из игровых клеток, полученную из файла
     */
    private String getCellsCombination(List<String> fileContent) {
        String cellsCombination = "";
        String cellsRegex = "^[SWTP]{16}$";

        try {
            cellsCombination = fileContent.stream().filter(e -> e.matches(cellsRegex)).findAny().orElseThrow();
        } catch (NoSuchElementException e) {
            System.err.println("Cells' combination is wrong!");
        }

        return cellsCombination;
    }

    /**
     * @return имя персонажа, полученное из файла
     */
    private String getCharacterName(List<String> fileContent) {
        String characterName = "";
        String characterNameRegex = "^(?i)(human|swamper|woodman)$";

        try {
            characterName = fileContent.stream().filter(e -> e.matches(characterNameRegex)).findAny().orElseThrow();
        } catch (NoSuchElementException e) {
            System.err.println("Character's name is wrong");
        }

        return characterName;
    }

    /**
     * @return массив стоимостей перемещений
     */
    private String[] convertLetterCellsToDigits(List<String> fileContent) {
        Character character = SimpleCharacterFactory.createCharacter(getCharacterName(fileContent));   // получаем экземпляр класса по имени персонажа
        String letterCells = getCellsCombination(fileContent);    // получаем строку из игровых клеток
        String[] digitCellsArray = new String[letterCells.length()];    // создаем пустой массив для конвертации

        for (int i = 0; i < letterCells.length(); i++) {    // проходимся по каждому символу строки (клетке) и конвертируем его название на значение
            switch (letterCells.charAt(i)) {
                case 'S':
                    digitCellsArray[i] = String.valueOf(character.getS());
                    break;
                case 'W':
                    digitCellsArray[i] = String.valueOf(character.getW());
                    break;
                case 'T':
                    digitCellsArray[i] = String.valueOf(character.getT());
                    break;
                case 'P':
                    digitCellsArray[i] = String.valueOf(character.getP());
                    break;
            }
        }

        return digitCellsArray;
    }

    /**
     * @return длину двумерного квадратного массива
     */
    private int getGridLength(String[] grid) {
        if (Math.sqrt(grid.length) % 1 != 0 || grid.length == 1) {
            System.err.println("\nЧисло колонок не равно числу строк!");
            return 0;
        }

        return grid.length;
    }

    /**
     *
     * @return двумерный массив, состоящий из стоимостей перемещений
     */
    public int[][] getGrid(String filePath) {
        List<String> fileContent = getFileContent(filePath);
        String[] cellsCombination = convertLetterCellsToDigits(fileContent);
        int gridLength = getGridLength(cellsCombination);

        int row = (int) Math.sqrt(gridLength);
        int column = (int) Math.sqrt(gridLength);
        int[][] grid = new int[row][column];

        for (int i = 0; i < row; i++) {
            for (int j = 0; j < column; j++) {
                grid[i][j] = Integer.parseInt(cellsCombination[i * grid.length + j]);
            }
        }

        return grid;
    }
}
