public class Main {
    public static void main(String[] args) {
        PatriciaTree arv = new PatriciaTree();

        arv.inserir("bear");
        arv.inserir("bid");
        arv.inserir("bell");
        arv.inserir("bull");
        arv.inserir("buy");
        arv.inserir("sell");
        arv.inserir("stock");
        arv.inserir("stop");

        arv.inOrdem();
    }
}