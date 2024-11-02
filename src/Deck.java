import java.util.Arrays;
import java.util.Random;

public class Deck {
    private final Card[] cards;
    private int cardCount;

    // Constructor
    public Deck(boolean includeJokers, boolean isRussian){
        int deckLength = isRussian ? 36 : 52;

        if(includeJokers){
            deckLength+=2;
        }

        cards = new Card[deckLength];
        cardCount = 0;


        String[] suits = {"Hearts", "Diamonds", "Clubs", "Spades"};
        String[] faces = isRussian
        ? new String[]{"Ace", "6", "7", "8", "9", "10", "Jack", "Queen", "King"}
        : new String[]{"Ace", "2", "3", "4", "5", "6", "7", "8", "9", "10", "Jack", "Queen", "King"};


        for (String suit : suits){
            for (String face : faces) {
                cards[cardCount] = new Card(suit, face);
                cardCount++;
            }
        }


        if (includeJokers){
            cards[cardCount++] = new Card("red", "Joker");
            cards[cardCount++] = new Card("black", "Joker");
        }
    }

//    public void showDeck() {
//        for (int i = 0; i < cardCount; i++){
//            System.out.println(cards[i]);
//
//        }
//    }

// First option
//    public String toString(){
//        String output = "";
//        for (int i = 0; i < cardCount; i++){
//            output += cards[i] + "\n";
//        }
//        return output;
//    };

//         Second option
    @Override
    public String toString(){
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < cardCount; i++){
            sb.append(cards[i]);
            sb.append("\n");
        }
        return sb.toString();
    };

    // Second+ option
//    public String toString(){
//        StringBuilder sb = new StringBuilder();
//        for (Card card : cards){
//            sb.append(card);
//            sb.append("\n");
//        }
//        return sb.toString();
//    };

// Third option
//public String toString(){
//  return String.join("\n", );
//
//
//};

//    public String toString(){
//        return String.join("\n", Arrays.stream(cards)
//                .map(Card::toString)
//                .toArray(String[]::new)); // lambda shortcut
//    };



    // Fisher-Yates shuffle algorithm

    public void shuffle() {
        Random random = new Random();
        for (int i = cardCount - 1; i > 0; i--){
            int j = random.nextInt(i + 1);
            Card temp = cards[i];
            cards[i] = cards[j];
            cards[j] = temp;
        }
    }

    public String getTopCard(){
    if (cardCount > 0){
        return cards[--cardCount].toString();
    } else {
        return "No cards left in the deck";
        }
    }

    // homework


    // there will be a top
    // method toString()

    // array or list or dictionary


    // collection of cards
    // by removing one card deck should shrink by one card
    // cards should have ordered

}


