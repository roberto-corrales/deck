import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Random;

class Deck {
    private List<Card> cartas;
    private static final String[] palos = {"treboles", "corazones", "picas", "diamantes"};
    public static final String[] valores = {"A", "2", "3", "4", "5", "6", "7", "8", "9", "10", "J", "Q", "K"};

    public Deck(){
        cartas = new ArrayList<>();
        for (String palo : palos){
            for (String valor : valores){
                cartas.add(new Card(palo, valor));
            }
        }
    }

    public void shuffle(){
        Collections.shuffle(cartas);
        System.out.println("Se mezcló el deck");
    }

    public void head() {
        if ( cartas.isEmpty() ) {
            deckVacio();
        } else {
            Card cartaRemovida  = cartas.remove(0);
            System.out.println(cartaRemovida);
            cartasRestantes();
        }
    }

    public void pick(){
        if ( cartas.isEmpty() ){
            deckVacio();
        } else {
            int indexRandom = new Random().nextInt(cartas.size());
            Card cartaSeleccionada = cartas.remove(indexRandom);
            System.out.println("Carta seleccionada: " + cartaSeleccionada);
            cartasRestantes();
        }
    }

    public Card[] hand(){
        if ( cartas.size() < 5 ) {
            System.out.println("No hay suficientes cartas para crear una mano");
            return new Card[0];
        } else {
            Card[] hand = new Card[5];
            for(int i = 0; i < 5; i++){
                hand[i] = cartas.remove(0);
                System.out.println(hand[i]);
            }
            cartasRestantes();
            return hand;
        }
    }

    private void cartasRestantes(){
        System.out.println("Quedan " + cartas.size() + " cartas");
    }

    private void deckVacio(){
        System.out.println("No quedan cartas en el deck");
    }

    public static void main(String[] args) {

        Deck deck = new Deck();
        deck.shuffle();
        deck.head();
        deck.pick();
        deck.hand();
    }
}
