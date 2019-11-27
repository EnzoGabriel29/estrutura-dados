package EstruturaDados.Arvore.B;

public class ArvoreB {
    private static ArvoreB arvore;
    private ArvoreB(int grau){
        this.grau = grau;
    }
    public static ArvoreB getInstance(int grau){
        if (ArvoreB.arvore == null)
            ArvoreB.arvore = new ArvoreB(grau);
            
        return ArvoreB.arvore;
    }
    
    protected int grau;
    protected NoB raiz;
    
    public void insereChave(int chave){
        if (this.raiz == null)
            this.raiz = new NoB(this.grau);
        
        this.raiz.insereChave(chave);
        this.atualizaRaiz();
        this.mostraArvore();
    }
    
    public void atualizaRaiz(){
        NoB noAux = this.raiz;
        
        while (noAux.pai != null)
            noAux = (NoB) noAux.pai;
        
        this.raiz = noAux;
    }
    
    public void mostraArvore(){
        this.raiz.mostraArvore();
        System.out.println();
    }
    
    public static void main(String[] args){
        ArvoreB a = ArvoreB.getInstance(2);
        a.insereChave(1); 
        a.insereChave(3); 
        a.insereChave(7); 
        a.insereChave(10); 
        a.insereChave(11); 
        a.insereChave(13); 
        a.insereChave(14); 
        a.insereChave(15); 
        a.insereChave(18); 
        a.insereChave(16); 
        a.insereChave(19); 
        a.insereChave(24); 
        a.insereChave(25); 
        a.insereChave(26); 
        a.insereChave(21); 
        a.insereChave(4); 
        a.insereChave(5); 
        a.insereChave(20); 
        a.insereChave(22); 
        a.insereChave(2); 
        a.insereChave(17); 
        a.insereChave(12); 
        a.insereChave(6);
        a.insereChave(25);
        
//        a.removeNo(6);
//        a.removeNo(13);
//        a.removeNo(7); 
//        a.removeNo(4);
//        a.removeNo(2);
//        a.removeNo(16);
    }
}
