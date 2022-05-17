import java.util.Hashtable;

public class Blackjack {

    public static void main(String[] args) {
        
    }

    static Hashtable<String, Integer> deckOfCards = new Hashtable<>();

    public int parseCard(String card) {
        deckOfCards.put("one", 1);
        deckOfCards.put("two", 2);
        deckOfCards.put("three", 3);
        deckOfCards.put("four", 4);
        deckOfCards.put("five", 5);
        deckOfCards.put("six", 6);
        deckOfCards.put("seven", 7);
        deckOfCards.put("eight", 8);
        deckOfCards.put("nine", 9);
        deckOfCards.put("ten", 10);
        deckOfCards.put("jack", 10);
        deckOfCards.put("queen", 10);
        deckOfCards.put("king", 10);
        deckOfCards.put("ace", 11);
        deckOfCards.put("other", 0);

        //System.out.println(deckOfCards.get(card));
        return deckOfCards.get(card);
    }

    public boolean isBlackjack(String card1, String card2) {
        int handVal = parseCard(card1) + parseCard(card2);
        if(handVal == 21){
            return true;
        } else {
            return false;
        }
    }

    /**
     Implement a function that returns the string representation of a decision given your cards.
     This function is only called if the `handScore` is larger than 20. It will receive 2 arguments:
     `isBlackJack` and `dealerScore`. It should implement the bulletpoints in the category "Large Hand" above.

     ```
     java
     isBlackJack = true
     dealerScore = 7
     largeHand(isBlackJack, dealerScore)
     // returns "W"
    ```
     */
    public String largeHand(boolean isBlackjack, int dealerScore) {
        String win = "W";
        String split = "P";
        String stand = "S";
        
        if(isBlackjack && (dealerScore >= 10)){
            return stand;
        } else if(isBlackjack && (dealerScore < 10)){
            return win;
        } else{
            return split;
        }
    }

    public String smallHand(int handScore, int dealerScore) {
        String stand = "S";
        String hit = "H";

        if(handScore >= 17){
            return stand;
        } else if(handScore >= 12 && handScore <= 16 && dealerScore < 7){
            return stand;
        } else if(handScore >= 12 && handScore <= 16 && dealerScore > 7){
            return hit;
        } else{
            return hit;
        }
    }

    // FirstTurn returns the semi-optimal decision for the first turn, given the cards of the player and the dealer.
    // This function is already implemented and does not need to be edited. It pulls the other functions together in a
    // complete decision tree for the first turn.
    public String firstTurn(String card1, String card2, String dealerCard) {
        int handScore = parseCard(card1) + parseCard(card2);
        int dealerScore = parseCard(dealerCard);

        if (20 < handScore) {
            return largeHand(isBlackjack(card1, card2), dealerScore);
        } else {
            return smallHand(handScore, dealerScore);
        }
    }
}
