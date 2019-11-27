package EstruturaDados.Arvore.B;

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
            
        } else this.raiz.insereChave(chave);
                
        /*
        if (this.raiz == null){ 
            this.raiz = new NoB(this.grau, true); 
            this.raiz.chaves[0] = chave; 
            this.raiz.numChaves = 1; 

        } else if (this.raiz.isCheio()){ 
            NoB novaRaiz = new NoB(this.grau, false); 
            novaRaiz.filhos.add(0, this.raiz); 
            novaRaiz.divideFilho(0, this.raiz); 

            int j = 0; 
            if (novaRaiz.chaves[0] < chave) j++; 
            novaRaiz.filhos.get(j).insereChave(chave); 
            this.raiz = novaRaiz; 
        
        } else this.raiz.insereChave(chave); 
                */
        this.atualizaRaiz();
        this.mostraArvore();
        System.out.println();
    }
    
    public void atualizaRaiz(){
        NoB aux = this.raiz;
        
        while (aux.pai != null)
            aux = (NoB) aux.pai;
        
        this.raiz = aux;
    }
    
    public void removeNo(int chave){
        System.out.println("Removendo o nó " + chave + ":");
        if (raiz == null) return;
        
        this.raiz.removeNo(chave);
        
        if (this.raiz.numChaves == 0)
            this.raiz = this.raiz.isFolha ? null : this.raiz.filhos.get(0);
        
        this.mostraArvore();
        System.out.println();
    }
    
    public static void main(String[] args){
        ArvoreB a = ArvoreB.getInstance(3);
        a.insereNo(1); 
        a.insereNo(3); 
        a.insereNo(7); 
        a.insereNo(10); 
        a.insereNo(11); 
        a.insereNo(13); 
        a.insereNo(14); 
        a.insereNo(15); 
        a.insereNo(18); 
        a.insereNo(16); 
        a.insereNo(19); 
        a.insereNo(24); 
        a.insereNo(25); 
        a.insereNo(26); 
        a.insereNo(21); 
        a.insereNo(4); 
        a.insereNo(5); 
        a.insereNo(20); 
        a.insereNo(22); 
        a.insereNo(2); 
        a.insereNo(17); 
        a.insereNo(12); 
        a.insereNo(6);
        
//        a.removeNo(6);
//        a.removeNo(13);
//        a.removeNo(7); 
//        a.removeNo(4);
//        a.removeNo(2);
//        a.removeNo(16);
    }
}
