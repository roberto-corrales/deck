class Card {
    private String palo;
    private String color;
    private String valor;

    public Card(String palo, String valor){
        this.palo = palo;
        this.color = palo.equals( "treboles") || palo.equals("picas") ? "negro" : "rojo";
        this.valor = valor;
    }

    @Override
    public String toString() {
        return (palo + ", " + color + ", " + valor);
    }
}
