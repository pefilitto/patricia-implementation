package PatriciaTree;

import Fila.Fila;

public class PatriciaTree {
    private No raiz;

    public PatriciaTree() {
        raiz = null;
    }

    private No buscarPai(No alvo) {
        return buscarPaiRecursivo(raiz, alvo);
    }

    private No buscarPaiRecursivo(No atual, No alvo) {
        No paiEncontrado = null;
        if (atual != null) {
            int i = 0;
            while (i < 26 && paiEncontrado == null) {
                No filho = atual.getvLig(i);
                if (filho != null) {
                    if (filho == alvo) {
                        paiEncontrado = atual;
                    } else {
                        paiEncontrado = buscarPaiRecursivo(filho, alvo);
                    }
                }
                i++;
            }
        }
        return paiEncontrado;
    }

    public void inserir(String palavra) {
        if (palavra != null && !palavra.isEmpty()) {
            if (raiz == null) {
                raiz = new No("");
                No novoNo = new No(palavra);
                novoNo.setFolha(true);
                int pos = raiz.encontraPosicaovLigPeloAlfabeto(palavra.charAt(0));
                raiz.setvLig(pos, novoNo);
                raiz.setTL(1);
            } else {
                No atual = raiz;
                String restante = palavra;
                boolean inserido = false;

                while (!inserido) {
                    char primeiraLetra = restante.charAt(0);
                    int pos = atual.encontraPosicaovLigPeloAlfabeto(primeiraLetra);
                    No filho = atual.getvLig(pos);

                    if (filho == null) {
                        No novoNo = new No(restante);
                        novoNo.setFolha(true);
                        atual.setvLig(pos, novoNo);
                        atual.setTL(atual.getTL() + 1);
                        inserido = true;
                    } else {
                        String igualdade = retornaIgualdadePalavras(filho.getInfo(), restante);

                        if (igualdade.length() == restante.length()) {
                            if (igualdade.length() == filho.getInfo().length()) {
                                filho.setFolha(true);
                            } else {
                                dividirNoExistente(filho, restante);
                            }
                            inserido = true;
                        } else if (igualdade.length() == filho.getInfo().length()) {
                            restante = restante.substring(igualdade.length());
                            atual = filho;
                        } else {
                            dividirNoExistente(filho, restante);
                            inserido = true;
                        }
                    }
                }
            }
        }
    }

    private void dividirNoExistente(No noExistente, String palavraNova) {
        String infoExistente = noExistente.getInfo();
        String igualdade = retornaIgualdadePalavras(infoExistente, palavraNova);

        String restanteInfoExistente = infoExistente.substring(igualdade.length());
        String restantePalavraNova = palavraNova.substring(igualdade.length());

        No pai = buscarPai(noExistente);
        if (pai == null) {
            pai = this.raiz;
        }
        int posPai = pai.encontraPosicaovLigPeloAlfabeto(infoExistente.charAt(0));

        No novoPai = new No(igualdade);
        pai.setvLig(posPai, novoPai);

        No novoFilhoExistente = new No(restanteInfoExistente);
        novoFilhoExistente.setvLig(noExistente.getTodovLig());
        novoFilhoExistente.setTL(noExistente.getTL());
        novoFilhoExistente.setFolha(noExistente.isFolha());

        int posFilhoExistente = novoPai.encontraPosicaovLigPeloAlfabeto(restanteInfoExistente.charAt(0));
        novoPai.setvLig(posFilhoExistente, novoFilhoExistente);
        novoPai.setTL(novoPai.getTL() + 1);

        if (restantePalavraNova.isEmpty()) {
            novoPai.setFolha(true);
        } else {
            No novoFilhoNovo = new No(restantePalavraNova);
            novoFilhoNovo.setFolha(true);
            int posFilhoNovo = novoPai.encontraPosicaovLigPeloAlfabeto(restantePalavraNova.charAt(0));
            novoPai.setvLig(posFilhoNovo, novoFilhoNovo);
            novoPai.setTL(novoPai.getTL() + 1);
        }
    }

    private String retornaIgualdadePalavras(String string1, String string2) {
        StringBuilder igualdade = new StringBuilder();
        boolean flag = false;
        int i = 0;
        int minLength = Math.min(string1.length(), string2.length());

        while(i < minLength && !flag) {
            if (string1.charAt(i) == string2.charAt(i)) {
                igualdade.append(string1.charAt(i));
            } else {
                flag = true;
            }
            i++;
        }
        return igualdade.toString();
    }

    public void inOrdem() {
        inOrdem(raiz, "");
    }

    private void inOrdem(No no, String acumulado) {
        if (no != null) {
            String novaPalavra = no == raiz ? "" : acumulado + no.getInfo();

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

    public void exibePorNivel() {
        if (raiz != null) {
            Fila fila = new Fila();
            fila.enqueue(raiz);
            fila.enqueue(null);

            while (!fila.isEmpty()) {
                No aux = fila.dequeue().getInfo();

                if (aux == null) {
                    System.out.println();
                    if (!fila.isEmpty()) {
                        fila.enqueue(null);
                    }
                } else {
                    if (aux != raiz && !aux.getInfo().isEmpty()) {
                        String info = aux.getInfo() + (aux.isFolha() ? "[F]" : "");
                        System.out.print(info + " ");
                    } else if (aux == raiz) {
                        System.out.print("RAIZ ");
                    }

                    for (int i = 0; i < aux.getTodovLig().length; i++) {
                        No filho = aux.getvLig(i);
                        if (filho != null) {
                            fila.enqueue(filho);
                        }
                    }
                }
            }
        }
    }
}