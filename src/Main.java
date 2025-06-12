import PatriciaTree.PatriciaTree;

public class Main {
    public static void main(String[] args) {
        PatriciaTree arv = new PatriciaTree();

//        arv.inserir("bear");
//        arv.inserir("bid");
//        arv.inserir("bell");
//        arv.inserir("bull");
//        arv.inserir("buy");
//        arv.inserir("sell");
//        arv.inserir("stock");
//        arv.inserir("stop");

//        arv.inserir("casa");
//        arv.inserir("casaco");
//        arv.inserir("casinha");
//        arv.inserir("caso");
//        arv.inserir("pessoa");
//        arv.inserir("pesquisa");
//        arv.inserir("perigo");
//        arv.inserir("pedra");

        arv.inserir("oleo");
        arv.inserir("oleosidade");
        arv.inserir("olho");
        arv.inserir("olga");
        arv.inserir("pato");
        arv.inserir("patologia");
        arv.inserir("pedro");
        arv.inserir("palavra");
        arv.inserir("guarda");
        arv.inserir("guiana");
        arv.inserir("golang");
        arv.inserir("golaco");
        arv.inserir("gohan");

        arv.inOrdem();
        System.out.println();
        arv.exibePorNivel();
    }
}