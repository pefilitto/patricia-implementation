package Fila;

import PatriciaTree.No;

public class Elemento {
    private No info;
    private Elemento prox;

    public Elemento(No info){
        this.info = info;
        this.prox = null;
    }

    public No getInfo() {
        return info;
    }

    public void setInfo(No info) {
        this.info = info;
    }

    public Elemento getProx() {
        return prox;
    }

    public void setProx(Elemento prox) {
        this.prox = prox;
    }
}
