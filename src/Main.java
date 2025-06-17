import java.sql.SQLOutput;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {

    static int maxCards = 6;

    public static void main(String[] args) {

        // Instance of class Collection
        Collection myDeck = new Collection(false, true);
        Collection playerOne = new Collection();
        Collection playerTwo = new Collection();
        Collection tableDefeated = new Collection();
        Collection tableToDefeat = new Collection();


        System.out.println("\nBefore shuffling:");
        System.out.println(myDeck);

        // Calling method Shuffle the deck
        myDeck.shuffle();

        System.out.println("\nAfter shuffling:");
        System.out.println(myDeck);

        // dealing player cards
        while (playerOne.size() < maxCards) {
            playerOne.addCard(myDeck.getTopCard());
        }

        while (playerTwo.size() < maxCards) {
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
//        Card playerOneCard = playerOne.getTopCard();
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

        // Find out who has the lowest trump card
        int playerWithLowestTrump = playersTurn(trumpCard.getSuit(), playerOne, playerTwo);
        System.out.println("Player " + (playerWithLowestTrump + 1) + " starts the game!");


//        System.out.println("\nPlayer One's card: " + playerOneCard);
//        System.out.println("Player Two's card: " + playerTwoCard);

        //
//        for (Card defendCard : playerTwo.getCards()) {
//            System.out.println(defendCard + " " + canBeat(defendCard, playerOneCard, trumpCard.getSuit()));
//        }

        makeChoice(playerOne.getCards());



    }

    public static boolean canBeat(Card a, Card b, String trumpSuit) {

        if (a.getSuit().equals(b.getSuit())) {
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


    public static int playersTurn(String trumpSuit, Collection... players) {
        int player = -1;
        int lowestVal = 15;
        Card lowestTrump = null;
        boolean exitEarly = false;
        for (int i = 0; i < players.length && !exitEarly; i++) {
            for (Card c : players[i].getCards()) {
                if (c.getSuit().equals(trumpSuit) && Collection.cardFaces.get(c.getFace()) < lowestVal) {
                    player = i;
                    lowestVal = Collection.cardFaces.get(c.getFace());
                    lowestTrump = c;
                    if (lowestVal == 2) {
                        exitEarly = true;
                        break;
                    }
                }
            }
        }
        if (player > -1) {
            System.out.println("player: " + (player + 1) + " has " + lowestTrump);
        } else {
            System.out.println("nobody has trump cards");
        }
        return player;
    }


    public static int makeChoice(Card[]  choices){
        System.out.println("0. Quit/Cancel" );
        for (int i = 0; i < choices.length; i++) {
            System.out.println((i+1) + ". " + choices[i]);
        }

        boolean choiceMade = false;
        Scanner scn = new Scanner(System.in);
        int choice = -1;

        while(!choiceMade){
            try {
                int temp = scn.nextInt();
                if(temp <= choices.length){
                    if(temp > 0 ){
                        choice = temp -1;
                    }
                    choiceMade = true;
                }else{
                   throw new Exception();
                }

            }catch(Exception e){

                System.out.println("Not a valid choice!");
                scn.nextLine();
            }

        }


        return choice;
    }

}

// HomeWork
// 0. printing chosen attacker card !!!
// 1. function attack
// 2. find out de underline !!!
// 3. function defend
// 4. player attack/defend loop >>> while loop
// 5. outerloop whole game loop
// 6. one more paramete for makeChoice (boolean) skippable if true 0. option => true / not skippable >> choice need to be a valid card


