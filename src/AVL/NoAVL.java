package AVL;

public class NoAVL { 
    public int chave, altura; 
    public NoAVL[] filhos;
    public NoAVL pai;
    private final ArvoreAVL arvore;
  
    public static void getInfo(NoAVL no, boolean isRecursivo){
        if (no == null) return;

        System.out.println("Pai: " + (no.pai == null ? "null" : no.pai.chave));
        System.out.println("Chave: " + no.chave);
        System.out.println("Filho esquerdo: " + (no.filhos[0] == null ? "null" : no.filhos[0].chave));
        System.out.println("Filho direito: " + (no.filhos[1] == null ? "null" : no.filhos[1].chave));
        System.out.println("Altura: " + (no.altura));
        System.out.println("Fator de balanceamento: " + (no.getFatorBal()));
        if (isRecursivo) System.out.println();

        if (isRecursivo) NoAVL.getInfo(no.filhos[0], true);
        if (isRecursivo) NoAVL.getInfo(no.filhos[1], true);
    }

    public NoAVL(int chave){
        this.filhos = new NoAVL[2]; 
        this.chave = chave; 
        this.altura = 1;
        this.arvore = ArvoreAVL.getInstance();
    }

    public void rotacionaEsquerda(){
        this.arvore.mostraArvore();
        System.out.println("Rotacionando o nó " + this.chave + " à esquerda:");
        
        NoAVL filhoDir = this.filhos[1]; 
        NoAVL netoEsq;
        if (filhoDir == null) netoEsq = null;
        else netoEsq = filhoDir.filhos[0]; 
    
        if (filhoDir != null){
            if (this.pai == null)
                filhoDir.pai = null;
            
            else if (this.pai.filhos[0].chave == this.chave)
                this.pai.setFilho(filhoDir, 0);
            
            else if (this.pai.filhos[1].chave == this.chave)
                this.pai.setFilho(filhoDir, 1);

            filhoDir.setFilho(this, 0);
        }
        
        this.setFilho(netoEsq, 1);
        this.atualizaAltura();

        if (filhoDir != null)
            filhoDir.atualizaAltura();
    } 

    public void rotacionaDireita(){
        this.arvore.mostraArvore();
        System.out.println("Rotacionando o nó " + this.chave + " à direita:");
        
        NoAVL filhoEsq = this.filhos[0];
        NoAVL netoDir;
        if (filhoEsq == null) netoDir = null;
        else netoDir = filhoEsq.filhos[1]; 
        
        if (filhoEsq != null){
            if (this.pai == null)
                filhoEsq.pai = null;
            
            else if (this.pai.filhos[0].chave == this.chave)
                this.pai.setFilho(filhoEsq, 0);
            
            else if (this.pai.filhos[1].chave == this.chave)
                this.pai.setFilho(filhoEsq, 1);

            filhoEsq.setFilho(this, 1);
        }

        this.setFilho(netoDir, 0); 
        this.atualizaAltura();

        if (filhoEsq != null)
            filhoEsq.atualizaAltura();
    } 

    public int getFatorBal() { 
        int alturaEsq = this.filhos[0] == null ? 0 : this.filhos[0].altura;
        int alturaDir = this.filhos[1] == null ? 0 : this.filhos[1].altura;
        return alturaEsq - alturaDir; 
    }
    
    public void insereNo(int chave){
        this.insereNo(new NoAVL(chave));
    }

    public void insereNo(NoAVL no){
        if (no.chave == this.chave) return;

        int indice = no.chave < this.chave ? 0 : 1;
        
        if (this.filhos[indice] == null)
            this.setFilho(no, indice);
        
        else this.filhos[indice].insereNo(no.chave);
          
        this.atualizaAltura();
        this.ajustaRotacao();
    } 
    
    public void setFilho(NoAVL no, int pos){
        this.filhos[pos] = no;
        if (no != null) no.pai = this;
    }

    public void mostraArvore(){
        if (this.filhos[1] != null)
            this.filhos[1].mostraArvore(true, "");
        
       System.out.println(this.chave + " (" + this.getFatorBal() + ")");
       
        if (this.filhos[0] != null)
            this.filhos[0].mostraArvore(false, "");
        
        System.out.println();
    }  
    
    private void mostraArvore(boolean isDireita, String identacao){
        if (this.filhos[1] != null){
            String identacao1 = identacao + (isDireita ? "        " : " |      ");
            this.filhos[1].mostraArvore(true, identacao1);
        }
        
        System.out.print(identacao);
        System.out.print(isDireita ? " ," : " `");
        System.out.print("----- ");
        
        System.out.println(this.chave + " (" + this.getFatorBal() + ")");
        
        if (this.filhos[0] != null){
            String identacao2 = identacao + (isDireita ? " |      " : "        ");
            this.filhos[0].mostraArvore(false, identacao2);
        }
    }
    
    public void atualizaAltura(){
        int alturaEsq = this.filhos[0] == null ? 0 : this.filhos[0].altura;
        int alturaDir = this.filhos[1] == null ? 0 : this.filhos[1].altura;
        this.altura = Math.max(alturaEsq, alturaDir) + 1;  
    }
    
    public void ajustaRotacao(){
        int fatorBal = this.getFatorBal();
  
        if (fatorBal > 1 && filhos[0].getFatorBal() >= 0)
            this.rotacionaDireita();
  
        else if (fatorBal < -1 && filhos[1].getFatorBal() <= 0)  
            this.rotacionaEsquerda();
        
        else if (fatorBal > 1 && filhos[0].getFatorBal() < 0){  
            this.filhos[0].rotacionaEsquerda();
            this.rotacionaDireita();
            
        } else if (fatorBal < -1 && filhos[1].getFatorBal() > 0){  
            this.filhos[1].rotacionaDireita();
            this.rotacionaEsquerda(); 
        }
    }
    
    public NoAVL getMenorNo() {  
        NoAVL atual = this;  
  
        while (atual.filhos[0] != null)  
            atual = atual.filhos[0];  
  
        return atual;  
    }  
    
    public void removeNo(int chave){
        NoAVL novaRaiz = null;
        
        if (chave < this.chave)
            this.filhos[0].removeNo(chave);
  
        else if (chave > this.chave)  
            this.filhos[1].removeNo(chave);

        else {  
            if (this.filhos[0] == null && this.filhos[1] == null){
                int i = this.pai.filhos[0].chave == this.chave ? 0 : 1;
                this.pai.setFilho(null, i);
                return;
                
            } else if (this.filhos[0] == null || this.filhos[1] == null){
                NoAVL filho = this.filhos[0] == null ? this.filhos[1] : this.filhos[0];
                int i = this.pai.filhos[0].chave == this.chave ? 0 : 1;
                this.pai.setFilho(filho, i);
                return;
                
            } else {  
                NoAVL neto = this.filhos[1].getMenorNo(); 
                NoAVL filhoEsq = this.filhos[0];
                
                boolean isRaiz = this.pai == null;
                
                if (!isRaiz){
                    int i = this.pai.filhos[0].chave == this.chave ? 0 : 1;
                    this.pai.setFilho(neto, i);  
                } 
                
                neto.setFilho(filhoEsq, 0);
               
                if (isRaiz){
                    novaRaiz = this.filhos[1];
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
            novaRaiz.filhos[0].atualizaAltura();
        
        if (novaRaiz.filhos[1] != null)
            novaRaiz.filhos[1].atualizaAltura();
            
        novaRaiz.atualizaAltura();
        novaRaiz.ajustaRotacao();
    } 
}
 