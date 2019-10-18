package estruturaDados;

public class ArvoreAVL {
    
    private No raiz;

    public ArvoreAVL(NoAVL raiz){
        this.raiz = raiz;
    }
    
    public void imprimePreOrdem(){
        raiz.imprimePreOrdem();
    }
    
    public boolean insereNo(No no){
        boolean res = this.raiz.insereNo(no);
        
        while (this.raiz.pai != null)
            this.raiz = this.raiz.pai;
        
        return res;
    }
    
    public No buscaNo(int chave){
        return raiz.buscaNo(chave);
    }
    
    public void mostraArvore(){
        raiz.mostraArvore();
    }
    
}
