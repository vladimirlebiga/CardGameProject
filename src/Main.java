import java.sql.SQLOutput;
import java.util.ArrayList;
import java.util.List;

public class Main {

    static int maxCards = 6;

    public static void main(String[] args) {

        // Instance of class Collection
        Collection myDeck = new Collection(false, true);
        Collection playerOne = new Collection();
        Collection playerTwo = new Collection();

        System.out.println("\nBefore shuffling:");
        System.out.println(myDeck);

        // Calling method Shuffle the deck
        myDeck.shuffle();

        System.out.println("\nAfter shuffling:");
        System.out.println(myDeck);

        // dealing player cards
        while (playerOne.size() < maxCards){
            playerOne.addCard(myDeck.getTopCard());
        }

        while (playerTwo.size() < maxCards){
            playerTwo.addCard(myDeck.getTopCard());
        }

        System.out.println("\nHands player One: ");
        System.out.println(playerOne);

        System.out.println("\nHands player Two: ");
        System.out.println(playerTwo);

        // Define a trump card (top card from remaining deck)
        Card trumpCard = myDeck.getTopCard();
        System.out.println("\nTrump card is: " + trumpCard);

        // Put the trump card back under the deck
        if (trumpCard != null) {
            myDeck.addCard(trumpCard, false); // Add to the bottom of the deck
        }


        System.out.println("\nNew deck with trump card:");
        System.out.println(myDeck);



        // Homework
        // Compare the first cards of each player
        Card playerOneCard = playerOne.getTopCard();
//        Card playerTwoCard = playerTwo.getTopCard();


        System.out.println("\nTrump card is: " + trumpCard);

        List<Card> playerOneTrumpCards = getTrumpCards(playerOne, trumpCard.getSuit());
        if (!playerOneTrumpCards.isEmpty()) {
            System.out.println("Player One's trump cards: " + playerOneTrumpCards);
        } else {
            System.out.println("Player One has no trump cards.");
        }

        List<Card> playerTwoTrumpCards = getTrumpCards(playerTwo, trumpCard.getSuit());
        if (!playerTwoTrumpCards.isEmpty()) {
            System.out.println("Player Two's trump cards: " + playerTwoTrumpCards);
        } else {
            System.out.println("Player Two has no trump cards.");
        }


        System.out.println("\nPlayer One's card: " + playerOneCard);
//        System.out.println("Player Two's card: " + playerTwoCard);

        //
        for(Card defendCard: playerTwo.getCards()) {
            System.out.println(defendCard + " " + canBeat(defendCard, playerOneCard, trumpCard.getSuit()));
        }


        // Testing
//        if (playerOneCard != null && playerTwoCard != null) {
//            String trumpSuit = (trumpCard != null) ? trumpCard.getSuit() : null;
//            boolean result = canBeat(playerOneCard, playerTwoCard, trumpSuit);
//
//            if(result) {
//                System.out.println("Player One's card beats Player Two's card!");
//            } else {
//                System.out.println("Player Two's card beats Player One's card!");
//            }
//        } else {
//            System.out.println("nothing to compare");
//        }



        //        // Peek at new deck
        //        System.out.println("\nNew Deck: ");
        //        System.out.println(myDeck);



// TODO: test canBeat from collection
        // Peek at the new top card
//        Card newTopCard = myDeck.peekTopCard();
//        System.out.println("\nNew top Card is: " + newTopCard);


//        System.out.println(myDeck);

    }

public static boolean canBeat(Card a, Card b, String trumpSuit){

        if(a.getSuit().equals(b.getSuit())){
            return Collection.cardFaces.get(a.getFace()) > Collection.cardFaces.get(b.getFace());

        } else if (a.getSuit().equals(trumpSuit)) {
            // b is a trump card: b wins
            return true;
        } else {
            // b is not trump and suits don't match: a wins
            return false;
        }
    }

    public static List<Card> getTrumpCards(Collection player, String trumpSuit) {
        List<Card> trumpCards = new ArrayList<>();
        for (Card card : player.getCards()) {
            if (card.getSuit().equals(trumpSuit)) {
                trumpCards.add(card);
            }
        }
        return trumpCards;
    }

}



