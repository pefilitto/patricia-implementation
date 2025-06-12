package PatriciaTree;

public class No {
    private String info;
    private boolean isFolha;
    private No[] vLig;
    public static char[] alfabeto = "abcdefghijklmnopqrstuvwxyz".toCharArray();
    private int TL;

    public No (String info){
        this.info = info;
        this.vLig = new No[26];
        this.TL = 0;
        this.isFolha = false;
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

    public void setvLig(No[] vLig) {
        this.vLig = vLig;
    }

    public void setTL(int TL){
        this.TL = TL;
    }

    public int getTL(){
        return this.TL;
    }

    // Refatorado para não usar return dentro do laço
    public int encontraPosicaovLigPeloAlfabeto(char primeiraLetra){
        int pos = -1;
        int i = 0;
        // Laço continua enquanto a posição não for encontrada ou o alfabeto não acabar
        while (i < alfabeto.length && pos == -1) {
            if(alfabeto[i] == primeiraLetra) {
                pos = i;
            }
            i++;
        }
        return pos;
    }

    public No[] getTodovLig(){
        return this.vLig;
    }
}