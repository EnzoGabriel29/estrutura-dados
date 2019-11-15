package AVL;

public class ArvoreAVL {
    private static ArvoreAVL arvore;
    private ArvoreAVL(){}
    public static ArvoreAVL getInstance(){
        if (arvore == null)
            arvore = new ArvoreAVL();
        
        return arvore;
    }
    
    public NoAVL raiz;
  
    public void insereNo(int chave){
        System.out.println("Inserindo a chave " + chave + ":");
        
        if (this.raiz == null)
            this.raiz = new NoAVL(chave);

        else {
            this.raiz.insereNo(chave);
            this.atualizaRaiz();
        }
        
        this.mostraArvore();
    }
    
    public void setRaiz(NoAVL raiz){
        this.raiz = raiz;
    }
    
    public void removeNo(int chave){
        System.out.println("Removendo a chave " + chave + ":");
        this.raiz.removeNo(chave);
        this.atualizaRaiz();
        this.mostraArvore();
    }
    
    public void atualizaRaiz(){
        while (this.raiz.pai != null)
            this.raiz = this.raiz.pai;
    }
    
    public void mostraArvore(){
        this.raiz.mostraArvore();
    }

    public static void main(String[] args) { 
        ArvoreAVL a = ArvoreAVL.getInstance();
  
        a.insereNo(9);
        a.insereNo(5); 
        a.insereNo(10);
        a.insereNo(0); 
        a.insereNo(6); 
        a.insereNo(11); 
        a.insereNo(-1); 
        a.insereNo(1); 
        a.insereNo(2);
        
        a.removeNo(10);
        a.removeNo(2);
        a.removeNo(0);
        a.removeNo(9);
        a.removeNo(5);
    } 
}