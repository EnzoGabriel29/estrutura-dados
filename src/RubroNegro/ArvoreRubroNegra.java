package RubroNegro;

public class ArvoreRubroNegra {
    private static ArvoreRubroNegra arvore;
    private ArvoreRubroNegra(){}
    public static ArvoreRubroNegra getInstance(){
        if (arvore == null)
            arvore = new ArvoreRubroNegra();
        
        return arvore;
    }
    
    public NoRubroNegro raiz;
  
    public void insereNo(int chave){
        System.out.println("Inserindo a chave " + chave + ":");
        
        NoRubroNegro no = NoRubroNegro.retornaNo(chave);
        if (this.raiz == null)
            this.raiz = no;

        else {
            this.raiz.insereNo(no);
            this.atualizaRaiz();
        }
        this.mostraArvore();
        this.raiz.recoloriza(no);
        this.atualizaRaiz();
        this.mostraArvore();
        
    }
    
    public void setRaiz(NoRubroNegro raiz){        
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
            this.raiz = (NoRubroNegro) this.raiz.pai;
    }
    
    public void mostraArvore(){
        this.raiz.mostraArvore();
    }
    
    public static void main(String[] args) {
        ArvoreRubroNegra a = ArvoreRubroNegra.getInstance();
        a.insereNo(7); 
        a.insereNo(6); 
        a.insereNo(5); 
        a.insereNo(4); 
        a.insereNo(3); 
        a.insereNo(2); 
        a.insereNo(1); 
    }
}
