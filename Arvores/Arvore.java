package Arvores;

public class Arvore {
    private No raiz;
    
    public Arvore(No raiz){
        this.raiz = raiz;
    }
    
    public void imprimirPreOrdem(){
        raiz.imprimirPreOrdem();
    }
    
    public void inserirNo(No no){
        raiz.inserirNo(no);
    }
}
