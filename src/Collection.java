import java.util.ArrayList;
import java.util.Arrays;
import java.util.Random;


public class Collection {
    private final ArrayList<Card> cards;

    // Main Constructor
    public Collection(boolean includeJokers, boolean isRussian){
        cards = new ArrayList<>();

        String[] suits = {"Hearts", "Diamonds", "Clubs", "Spades"};
        String[] faces = isRussian
                ? new String[]{"Ace", "6", "7", "8", "9", "10", "Jack", "Queen", "King"}
                : new String[]{"Ace", "2", "3", "4", "5", "6", "7", "8", "9", "10", "Jack", "Queen", "King"};


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

//    public void moveTopCardToBottom (){
//        Card topCard = getTopCard();
//        if( topCard != null){
//            addCard(topCard, false);
//        }
//    }

}

