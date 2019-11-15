package B;

public class ArvoreB {
    private static ArvoreB arvore;
    
    private ArvoreB(int t){
        this.grau = t;
    }
    
    public static ArvoreB getInstance(int t){
        if (arvore == null)
             arvore = new ArvoreB(t);
        
        return arvore;
    }
    
    public static ArvoreB getInstance(){
        if (arvore != null) return arvore;
        return null;
    }
    
    public int grau;
    public NoB raiz = null;
    
    public void mostraArvore(){
        this.raiz.mostraArvore();
    }
    
    public void insereNo(int chave){
        System.out.println("Inserindo a chave " + chave + ":");
        
        if (this.raiz == null){
            this.raiz = new NoB(this.grau, true);
            this.raiz.chaves[0] = chave;
            this.raiz.numChaves = 1;
        
        } else if (this.raiz.numChaves == 2*this.grau - 1){
            NoB novaRaiz = new NoB(this.grau, false);
            novaRaiz.filhos.add(this.raiz);
            novaRaiz.divideFilho(0, this.raiz);
                
            int i = 0;
            if (novaRaiz.chaves[0] < chave) i++;
            novaRaiz.filhos.get(i).insereNo(chave);
                
            this.raiz = novaRaiz;
            
        } else this.raiz.insereNo(chave);
        
        this.mostraArvore();
        System.out.println();
    }
    
    public static void main(String[] args) {
        ArvoreB a = ArvoreB.getInstance(3);
        a.insereNo(10);
        a.insereNo(20);
        a.insereNo(5);
        a.insereNo(6);
        a.insereNo(12);
        a.insereNo(30);
        a.insereNo(7);
        a.insereNo(17);
        a.insereNo(40);
        a.insereNo(50);
    }
}
