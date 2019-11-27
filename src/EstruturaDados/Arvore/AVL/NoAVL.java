package EstruturaDados.Arvore.AVL;
import EstruturaDados.Arvore.No;
import EstruturaDados.Arvore.NoBalanceado;

public class NoAVL extends NoBalanceado { 
    public int altura;
    private final ArvoreAVL arvore;
    
    public static NoAVL retornaNo(int chave){
        return new NoAVL(chave);
    }
  
    public static void getInfo(NoAVL no, boolean isRecursivo){
        if (no == null) return;
        NoAVL noPai = (NoAVL) no.pai;
        NoAVL noEsq = (NoAVL) no.filhos[0];
        NoAVL noDir = (NoAVL) no.filhos[1];
                
        System.out.println("Pai: " + (noPai == null ? "null" : noPai.chave));
        System.out.println("Chave: " + no.chave);
        System.out.println("Filho esquerdo: " + (noEsq == null ? "null" : noEsq.chave));
        System.out.println("Filho direito: " + (noDir == null ? "null" : noDir.chave));
        System.out.println("Altura: " + (no.altura));
        System.out.println("Fator de balanceamento: " + (no.getFatorBal()));
        if (isRecursivo) System.out.println();

        if (isRecursivo) NoAVL.getInfo((NoAVL) no.filhos[0], true);
        if (isRecursivo) NoAVL.getInfo((NoAVL) no.filhos[1], true);
    }

    public NoAVL(int chave){
        super(chave);
        this.altura = 1;
        this.arvore = ArvoreAVL.getInstance();
    }

    @Override
    public void rotacionaEsquerda(){
        this.arvore.mostraArvore();
        System.out.println("Rotacionando o nó " + this.chave + " à esquerda:");
        
        NoAVL filhoDir = (NoAVL) this.filhos[1];
        
        super.rotacionaEsquerda();
        
        this.atualizaAltura();
        if (filhoDir != null) filhoDir.atualizaAltura();
    } 

    @Override
    public void rotacionaDireita(){
        this.arvore.mostraArvore();
        System.out.println("Rotacionando o nó " + this.chave + " à direita:");
        
        NoAVL filhoEsq = (NoAVL) this.filhos[0];
        
        super.rotacionaDireita();
        
        this.atualizaAltura();

        if (filhoEsq != null)
            filhoEsq.atualizaAltura();
    } 

    public int getFatorBal(){ 
        NoAVL filhoEsq = (NoAVL) this.filhos[0];
        NoAVL filhoDir = (NoAVL) this.filhos[1];
        
        int alturaEsq = filhoEsq == null ? 0 : filhoEsq.altura;
        int alturaDir = filhoDir == null ? 0 : filhoDir.altura;
        return alturaEsq - alturaDir; 
    }
        
    @Override
    public void insereNo(No no){
        super.insereNo(no);
        
        this.atualizaAltura();
        this.ajustaRotacao();
    }
    
    public void atualizaAltura(){
        NoAVL filhoEsq = (NoAVL) this.filhos[0];
        NoAVL filhoDir = (NoAVL) this.filhos[1];
        
        int alturaEsq = filhoEsq == null ? 0 : filhoEsq.altura;
        int alturaDir = filhoDir == null ? 0 : filhoDir.altura;
        this.altura = Math.max(alturaEsq, alturaDir) + 1;  
    }
    
    public void ajustaRotacao(){
        int fatorBal = this.getFatorBal();
        NoAVL filhoEsq = (NoAVL) this.filhos[0];
        NoAVL filhoDir = (NoAVL) this.filhos[1];
  
        if (fatorBal > 1 && filhoEsq.getFatorBal() >= 0)
            this.rotacionaDireita();
  
        else if (fatorBal < -1 && filhoDir.getFatorBal() <= 0)  
            this.rotacionaEsquerda();
        
        else if (fatorBal > 1 && filhoEsq.getFatorBal() < 0){  
            filhoEsq.rotacionaEsquerda();
            this.rotacionaDireita();
            
        } else if (fatorBal < -1 && filhoDir.getFatorBal() > 0){  
            filhoDir.rotacionaDireita();
            this.rotacionaEsquerda(); 
        }
    }
    
    public NoAVL getMenorNo(){  
        NoAVL atual = this;  
  
        while (atual.filhos[0] != null)  
            atual = (NoAVL) atual.filhos[0];  
  
        return atual;  
    }  
    
    @Override
    public void removeNo(int chave){
        NoAVL novaRaiz = null;
        
        if (chave < this.chave)
            this.filhos[0].removeNo(chave);
  
        else if (chave > this.chave)  
            this.filhos[1].removeNo(chave);

        else {  
            if (this.filhos[0] == null && this.filhos[1] == null){
                int i = this.pai.filhos[0] == this ? 0 : 1;
                ((NoAVL) this.pai).setFilho(null, i);
                return;
                
            } else if (this.filhos[0] == null || this.filhos[1] == null){
                int indFilho = this.filhos[0] == null ? 1 : 0;
                NoAVL filho = (NoAVL) this.filhos[indFilho];
                
                int i = this.pai.filhos[0] == this ? 0 : 1;
                ((NoAVL) this.pai).setFilho(filho, i);
                return;
                
            } else {  
                NoAVL neto = ((NoAVL) this.filhos[1]).getMenorNo(); 
                NoAVL filhoEsq = (NoAVL) this.filhos[0];
                
                boolean isRaiz = this.pai == null;
                
                if (!isRaiz){
                    int i = this.pai.filhos[0] == this ? 0 : 1;
                    ((NoAVL) this.pai).setFilho(neto, i);  
                } 
                
                neto.setFilho(filhoEsq, 0);
               
                if (isRaiz){
                    novaRaiz = (NoAVL) this.filhos[1];
                    this.setFilho(null, 0);
                    this.setFilho(null, 1);
                    novaRaiz.pai = null;
                    this.arvore.setRaiz(novaRaiz);
                }
            }  
        }
        
        if (novaRaiz == null)
            novaRaiz = this;
        
        if (novaRaiz.filhos[0] != null)
            ((NoAVL) novaRaiz.filhos[0]).atualizaAltura();
        
        if (novaRaiz.filhos[1] != null)
            ((NoAVL) novaRaiz.filhos[1]).atualizaAltura();
            
        novaRaiz.atualizaAltura();
        novaRaiz.ajustaRotacao();
    } 

    @Override
    public String toString(){
        return this.chave + " (" + this.getFatorBal() + ")";
    }
}
 