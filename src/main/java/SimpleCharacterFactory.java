public class SimpleCharacterFactory {

    /**
     * @param characterName - имя героя, которому нужно будет пройти путь от клетки до клетки
     * @return - экземпляр героя, если true, иначе null
     */
    public static Character createCharacter(String characterName) {
        Character character;

        if (characterName.equalsIgnoreCase("human")) {
            character = new Human();
        } else if (characterName.equalsIgnoreCase("swamper")) {
            character = new Swamper();
        } else if (characterName.equalsIgnoreCase("woodman")) {
            character = new Woodman();
        } else {
            character = null;
        }

        return character;
    }
}
