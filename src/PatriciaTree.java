public class PatriciaTree {
    private No raiz;

    public PatriciaTree(){
        raiz = null;
    }

    private No buscarPai(No alvo) {
        return buscarPaiRecursivo(raiz, alvo);
    }

    private No buscarPaiRecursivo(No atual, No alvo) {
        if (atual == null) return null;

        for (int i = 0; i < 26; i++) {
            No filho = atual.getvLig(i);
            if (filho != null) {
                if (filho == alvo) {
                    return atual;
                }
                No resultado = buscarPaiRecursivo(filho, alvo);
                if (resultado != null) {
                    return resultado;
                }
            }
        }

        return null;
    }

    public void inserir(String palavra) {
        if (raiz == null) {
            raiz = new No("");
            No novoNo = new No(palavra);
            int pos = raiz.encontraPosicaovLigPeloAlfabeto(palavra.charAt(0));
            raiz.setvLig(pos, novoNo);
            raiz.setTL(1);
        } else {
            char primeiraLetra = palavra.charAt(0);
            No prefixo = encontraPrefixoRaiz(primeiraLetra);

            if (prefixo != null) {
                String igualdade = retornaIgualdadePalavras(prefixo.getInfo(), palavra);

                if (igualdade.length() == prefixo.getInfo().length()) {
                    String restante = palavra.substring(igualdade.length());

                    if (!restante.isEmpty()) {
                        No atual = prefixo;
                        while (!restante.isEmpty()) {
                            char letra = restante.charAt(0);
                            int pos = atual.encontraPosicaovLigPeloAlfabeto(letra);
                            No filho = atual.getvLig(pos);

                            if (filho == null) {
                                No novo = new No(restante);
                                atual.setvLig(pos, novo);
                                atual.setTL(atual.getTL() + 1);
                                restante = "";
                            } else {
                                String igualdadeFilho = retornaIgualdadePalavras(filho.getInfo(), restante);

                                if (igualdadeFilho.isEmpty() || igualdadeFilho.length() < filho.getInfo().length()) {
                                    dividirNoExistente(filho, restante);
                                    restante = "";
                                } else {
                                    restante = restante.substring(igualdadeFilho.length());
                                    atual = filho;
                                }
                            }
                        }
                    }
                } else {
                    dividirNoExistente(prefixo, palavra);
                }
            } else {
                No novoNo = new No(palavra);
                int pos = raiz.encontraPosicaovLigPeloAlfabeto(palavra.charAt(0));
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

        int pos1 = novoNo.encontraPosicaovLigPeloAlfabeto(restantePalavra1.getInfo().charAt(0));
        int pos2 = novoNo.encontraPosicaovLigPeloAlfabeto(restantePalavra2.getInfo().charAt(0));

        novoNo.setvLig(pos1, restantePalavra1);
        novoNo.setvLig(pos2, restantePalavra2);

        if (prefixo.getTL() == 0) {
            restantePalavra1.setFolha(true);
            restantePalavra2.setFolha(true);
            novoNo.setTL(2);
        }
        else {
            for (int i = 0; i < prefixo.getTodovLig().length; i++) {
                No filho = prefixo.getvLig(i);
                if (filho != null) {
                    restantePalavra1.setvLig(i, filho);
                    restantePalavra1.setTL(restantePalavra1.getTL() + 1);
                }
            }
        }

        No pai = buscarPai(prefixo);
        if (pai != null) {
            int pos = pai.encontraPosicaovLigPeloAlfabeto(prefixo.getInfo().charAt(0));
            pai.setvLig(pos, novoNo);
        } else {
            int pos = raiz.encontraPosicaovLigPeloAlfabeto(prefixo.getInfo().charAt(0));
            raiz.setvLig(pos, novoNo);
        }
    }

    private No encontraPrefixoRaiz(char letra){
        int pos = raiz.encontraPosicaovLigPeloAlfabeto(letra);
        return raiz.getvLig(pos);
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

    public void inOrdem() {
        inOrdem(raiz, "");
    }

    private void inOrdem(No no, String acumulado) {
        if (no == null) return;

        String novaPalavra = acumulado + no.getInfo();

        if (no.isFolha()) {
            System.out.println(novaPalavra);
        }

        for (int i = 0; i < 26; i++) {
            No filho = no.getvLig(i);
            if (filho != null) {
                inOrdem(filho, novaPalavra);
            }
        }
    }

}
