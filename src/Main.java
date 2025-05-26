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

        arv.inserir("casa");
        arv.inserir("casaco");
        arv.inserir("casinha");
        arv.inserir("caso");
        arv.inserir("pessoa");
        arv.inserir("pesquisa");
        arv.inserir("perigo");
        arv.inserir("pedra");

//        arv.inserir("galo");
//        arv.inserir("gala");
//        arv.inserir("galocha");
//        arv.inserir("galeria");
//        arv.inserir("gel");
//        arv.inserir("gelado");
//        arv.inserir("geladeira");
//        arv.inserir("gelatina");
//        arv.inserir("sola");
//        arv.inserir("solo");
//        arv.inserir("sol");
//        arv.inserir("solado");
//        arv.inserir("soldado");
//        arv.inserir("somente");
//        arv.inserir("sombra");
//        arv.inserir("bolo");
//        arv.inserir("bola");
//        arv.inserir("bolero");
//        arv.inserir("botao");
//        arv.inserir("botija");

        arv.inOrdem();
        System.out.println();
        arv.exibePorNivel();
    }
}