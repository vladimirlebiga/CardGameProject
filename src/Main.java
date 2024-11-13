public class Main {
    public static void main(String[] args) {

        // Instance of class Collection
        Collection myDeck = new Collection(false, true);
        Collection playerOne = new Collection();
        Collection playerTwo = new Collection();

//        System.out.println("\nBefore shuffling:");
//        System.out.println(myDeck);
//        myDeck.showDeck();


        // Calling method Shuffle the deck
        myDeck.shuffle();

        System.out.println("\nAfter shuffling:");
        System.out.println(myDeck);

        while (playerOne.size() < 6){
            playerOne.addCard(myDeck.getTopCard());
        }

        while (playerTwo.size() < 6){
            playerTwo.addCard(myDeck.getTopCard());
        }

        // Get the top card
//        Card topCard = myDeck.getTopCard();
//        System.out.println("\nTop Card is: " + topCard);
//
//        // Put top card to the playerOne
//        playerOne.addCard(topCard);

        System.out.println("\nHands player One: ");
        System.out.println(playerOne);

        // Put "next" top card to the playerTwo
//        topCard = myDeck.getTopCard();
//        playerTwo.addCard(topCard);

        System.out.println("\nHands player Two: ");
        System.out.println(playerTwo);

        // Peek at new deck
        System.out.println("\nNew Deck: ");
        System.out.println(myDeck);

        Card topCard = myDeck.getTopCard();
        System.out.println("\nTrump card is: " + topCard);

        if (topCard != null) {
            myDeck.addCard(topCard, false);
        }




        System.out.println("\nNew deck with trump card:");
        System.out.println(myDeck);


        // Peek at the new top card
//        Card newTopCard = myDeck.peekTopCard();
//        System.out.println("\nNew top Card is: " + newTopCard);


//        System.out.println(myDeck);

    }

    public static boolean canBeat(Card a, Card b){
        return false;
    }
}



