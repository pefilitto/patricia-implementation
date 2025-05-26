package PatriciaTree;

public class No {
    private String info;
    private boolean isFolha;
    private No[] vLig;
    public static char[] alfabeto = "abcdefghijklmnopqrstuvwxyz".toCharArray();
    private int TL;

    public No (String info){
        this.info = info;
        vLig = new No[26];
        TL = 0;
    }

    public String getInfo() {
        return info;
    }

    public void setInfo(String info) {
        this.info = info;
    }

    public boolean isFolha() {
        return isFolha;
    }

    public void setFolha(boolean folha) {
        isFolha = folha;
    }

    public No getvLig(int pos){
        return vLig[pos];
    }

    public void setvLig(int pos, No no){
        vLig[pos] = no;
    }

    public void setTL(int TL){
        this.TL = TL;
    }

    public int getTL(){
        return this.TL;
    }

    public int encontraPosicaovLigPeloAlfabeto(char primeiraLetra){
        for (int i = 0; i < alfabeto.length; i++) {
            if(alfabeto[i] == primeiraLetra)
                return i;
        }
        return -1;
    }

    public No[] getTodovLig(){
        return this.vLig;
    }
}
