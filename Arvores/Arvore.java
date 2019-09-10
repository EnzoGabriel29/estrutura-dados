<<<<<<< HEAD
package arvores;

public class Arvore {
    protected No raiz;
    
    public Arvore(No raiz){
        this.raiz = raiz;
    }
    
    public void imprimirPreOrdem(){
        raiz.imprimirPreOrdem();
    }

    public void imprimirOrdemSim(){
        raiz.imprimirOrdemSim();
    }

    public void imprimirPosOrdem(){
        raiz.imprimirPosOrdem();
    }
    
    public void inserirNo(No no){
        raiz.inserirNo(no);
    }

    public No buscarNo(int chave){
        return raiz.buscarNo(chave);
    }
}
=======
package Arvores;

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
>>>>>>> 2bd4ab6bf5934b0c610fecff72efbf00b737b79a
