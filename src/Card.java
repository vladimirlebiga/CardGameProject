public class Card {
    // Fields for variables
    private final String suit;
    private final String face;

    // Constructor
    public Card(String suit, String face) {
        this.suit = suit;
        this.face = face;
    }

    // Getters
    public String getSuit() {
        return suit;
    }

    public String getFace() {
        return face;
    }

    // @Overide toString() method from the Object class
    public String toString() {
        return face + " of " + suit;
    }

    public void showCard() {
        System.out.println(this);
    }
}



