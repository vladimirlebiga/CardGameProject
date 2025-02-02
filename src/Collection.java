import java.util.*;

import static java.util.Map.entry;


public class Collection {
    private final ArrayList<Card> cards;

    public static Map<String, Integer> cardFaces = Map.ofEntries(
            entry("6", 6),
            entry("7", 7),
            entry("8", 8),
            entry("9", 9),
            entry("10", 10),
            entry("Jack", 11),
            entry("Queen", 12),
            entry("King", 13),
            entry("Ace", 14)
    );


    // Main Constructor
    public Collection(boolean includeJokers, boolean isRussian){
        cards = new ArrayList<>();

        String[] suits = {"Hearts", "Diamonds", "Clubs", "Spades"};

        if(!isRussian){
            cardFaces.putAll(Map.ofEntries(
                    entry("2", 2),
                    entry("3", 3),
                    entry("4", 4),
                    entry("5", 5)
            ));
        }

        String[] faces = (new ArrayList<>(cardFaces.keySet())).toArray(new String[0]);

//        ArrayList<String> allFaces = new ArrayList<>(cardFaces.keySet());
//        Collections.sort(allFaces);
//        String[] faces = isRussian
//                ? (allFaces.subList(5, cardFaces.size())).toArray(new String[0])
//                : allFaces.toArray(new String[0]);

        for (String suit : suits){
            for (String face : faces) {
                cards.add(new Card(suit, face));
            }
        }

        // if statment
        if (includeJokers){
            cards.add(new Card("red", "Joker"));
            cards.add(new Card("black", "Joker"));
        }
    }
// empty container for player
    public Collection(){
        cards = new ArrayList<>();
    }

    // method
    public int size(){
        return cards.size();
    }

    @Override
        public String toString(){
        return String.join("\n", Arrays.stream(cards.toArray())
                .map(Object::toString)
                .toArray(String[]::new)); // lambda shortcut
    }



    public void shuffle() {
        Random random = new Random();
        for (int i = cards.size() - 1; i > 0; i--){
            int j = random.nextInt(i + 1);
            Card temp = cards.get(i);
            cards.set(i, cards.get(j));
            cards.set(j, temp);
        }
    }

    public Card getTopCard(){
        if (!cards.isEmpty()){
            return cards.removeFirst();
        } else {
            return null;
        }
    }


    public void addCard(Card card, boolean toTop){
        if (toTop){cards.addFirst(card);
        }else {
            cards.addLast(card);
        }

    }

    public void addCard(Card card){
        addCard(card,  true);
    }

    // new method Compare
    public static boolean beats(Card a, Card b){
        if (!a.getSuit().equals(b.getSuit())){
            return false;
        }
        return cardFaces.get(a.getFace()) > cardFaces.get(b.getFace());
    }

    //
    public Card[] getCards(){
        return cards.toArray(new Card[0]);
    }


    
}

