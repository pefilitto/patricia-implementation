package Fila;

import PatriciaTree.No;

public class Fila {
    private Elemento inicio;
    private Elemento fim;

    public Fila(){
        this.inicio = this.fim = null;
    }

    public Elemento getInicio() {
        return inicio;
    }

    public void setInicio(Elemento inicio) {
        this.inicio = inicio;
    }

    public Elemento getFim() {
        return fim;
    }

    public void setFim(Elemento fim) {
        this.fim = fim;
    }

    public void enqueue(No info){
        Elemento novoElemento = new Elemento(info);
        if(inicio == null && fim == null){
            inicio = fim = novoElemento;
            inicio.setProx(novoElemento);
        }
        else{
            fim.setProx(novoElemento);
            fim = fim.getProx();
        }
    }

    public Elemento dequeue(){
        Elemento inicio = this.inicio;
        this.inicio = this.inicio.getProx();
        return inicio;
    }

    public boolean isEmpty(){
        return inicio == null;
    }
}
