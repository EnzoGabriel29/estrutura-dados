package projetosii;

public class Arvore {
    
    private No raiz;

    public Arvore(No raiz){
        this.raiz = raiz;
    }
    
    public void imprimirPreOrdem(){
        raiz.imprimirPreOrdem();
    }
    
    public boolean inserirNo(No no){
        return raiz.inserirNo(no);
    }
    
    public No buscarNo(int chave){
        return raiz.buscarNo(chave);
    }
    
}
