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
