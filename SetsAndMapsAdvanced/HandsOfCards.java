import java.util.*;



public class HandsOfCards {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        Map<String, Set<String>> players = new LinkedHashMap<>();
        String input = scanner.nextLine();

        while (!input.equals("JOKER")) {
            String playerName = input.split(":\\s+")[0];
            String cards = input.split(":\\s+")[1];

            String[] arrayCards = cards.split(",\\s+");

            Set<String> currentCards = new LinkedHashSet<>();
            currentCards.addAll(Arrays.asList(arrayCards));

            // players.put(playerName,currentCards);

            if (!players.containsKey(playerName)) {
                players.put(playerName, currentCards);

            } else {
                Set<String> oldCards = players.get(playerName);
                oldCards.addAll(currentCards);
                players.put(playerName, oldCards);
            }

            input = scanner.nextLine();
        }

        //trqbva da se printira player: points
        //

        players.entrySet().forEach(entry -> {
            String name = entry.getKey();
            Set<String> cards = entry.getValue();
            int sumPoints = getCardsPoints(cards);
            System.out.printf("%s: %d%n", name, sumPoints);
        });
    }

    private static int getCardsPoints(Set<String> cards) {
        Map<Character, Integer> cardsPoints = getSymbolsValue();
        int sumPoints = 0;
        for (String card : cards) {
            int points=0;

            if(card.startsWith("10")){
                char type = card.charAt(2);
                points=10* getSymbolsValue().get(type);

            }else {
                //"4H"
                char power = card.charAt(0); //4
                char type = card.charAt(1); //H
                points = getSymbolsValue().get(power) * getSymbolsValue().get(type);
            }
            sumPoints+=points;
        }
        return sumPoints;
    }

    private static Map<Character, Integer> getSymbolsValue() {
        Map<Character, Integer> characterValues = new HashMap<>();
        characterValues.put('2', 2);
        characterValues.put('3', 3);
        characterValues.put('4', 4);
        characterValues.put('5', 5);
        characterValues.put('6', 6);
        characterValues.put('7', 7);
        characterValues.put('8', 8);
        characterValues.put('9', 9);
        characterValues.put('J', 11);
        characterValues.put('Q', 12);
        characterValues.put('K', 13);
        characterValues.put('A', 14);
        characterValues.put('S', 4);
        characterValues.put('H', 3);
        characterValues.put('D', 2);
        characterValues.put('C', 1);
        return characterValues;
    }
}
