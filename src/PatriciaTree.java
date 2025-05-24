public class PatriciaTree {
    private No raiz;

    public PatriciaTree(){
        raiz = null;
    }

    public void inserir(String palavra){
        if(raiz == null){
            raiz = new No("");
            No novoNo = new No(palavra);
            int pos = encontraPosicaovLigPeloAlfabeto(palavra.charAt(0));
            raiz.setvLig(pos, novoNo);
            raiz.setTL(1);
        }
        else{
            char primeiraLetra = palavra.charAt(0);

            No prefixo = encontraPrefixoRaiz(primeiraLetra);
            if(prefixo != null){
                dividirNoExistente(prefixo, palavra);
            }
            else{
                No novoNo = new No(palavra);
                int pos = encontraPosicaovLigPeloAlfabeto(palavra.charAt(0));
                raiz.setvLig(pos, novoNo);
                raiz.setTL(raiz.getTL() + 1);
            }
        }
    }

    private void dividirNoExistente(No prefixo, String palavra) {
        String igualdadePalavras = retornaIgualdadePalavras(prefixo.getInfo(), palavra);

        No novoNo = new No(igualdadePalavras);

        No restantePalavra1 = new No(prefixo.getInfo().substring(igualdadePalavras.length()));
        No restantePalavra2 = new No(palavra.substring(igualdadePalavras.length()));

        int pos1 = encontraPosicaovLigPeloAlfabeto(restantePalavra1.getInfo().charAt(0));
        int pos2 = encontraPosicaovLigPeloAlfabeto(restantePalavra2.getInfo().charAt(0));

        novoNo.setvLig(pos1, restantePalavra1);
        novoNo.setvLig(pos2, restantePalavra2);
        novoNo.setTL(novoNo.getTL() + 2);

        int posvLigRaiz = encontraPosicaovLigPeloAlfabeto(novoNo.getInfo().charAt(0));
        raiz.setvLig(posvLigRaiz, novoNo);
    }


    private int encontraPosicaovLigPeloAlfabeto(char primeiraLetra){
        for (int i = 0; i < No.alfabeto.length; i++) {
            if(No.alfabeto[i] == primeiraLetra)
                return i;
        }
        return -1;
    }

    private No encontraPrefixoRaiz(char letra){
        return raiz.getvLig(encontraPosicaovLigPeloAlfabeto(letra));
    }

    private String retornaIgualdadePalavras(String string1, String string2) {
        String igualdade = "";
        boolean flag = false;
        for (int i = 0; i < string1.length() && i < string2.length() && !flag; i++) {
            if (string1.charAt(i) == string2.charAt(i))
                igualdade = igualdade.concat(String.valueOf(string1.charAt(i)));
            else
                flag = true;
        }
        return igualdade;
    }
}
