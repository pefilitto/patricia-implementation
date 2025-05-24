public class No {
    private String info;
    private boolean isFolha;
    private No[] vLig;

    public No (String info){
        this.info = info;
        vLig = new No[26];
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
}
