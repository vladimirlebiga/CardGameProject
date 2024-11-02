public class Main {
    public static void main(String[] args) {

        // Create a new Deck object
        Collection myDeck = new Collection(false, true);


//        myDeck.showDeck();

        // Instance of class Collection
        Collection playerOne = new Collection();
        Collection playerTwo = new Collection();

        System.out.println("\nBefore shuffling:");
        System.out.println(myDeck);
//        myDeck.showDeck();


        // Shuffle the deck
        myDeck.shuffle();

        System.out.println("\nAfter shuffling:");
        System.out.println(myDeck);
//        myDeck.showDeck();

        // Get the top card

        Card topCard = myDeck.getTopCard();

        System.out.println("\nTop Card is: " + topCard);

        playerOne.addCard(topCard);


//        System.out.println(myDeck);

    }
}

// print out deck of player one and player two and left of the deck