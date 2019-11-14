class NoAVL { 
    int chave, altura; 
    NoAVL[] filhos;
    NoAVL pai;
  
    public static void getInfo(NoAVL no, boolean isRecursivo){
        if (no == null) return;

        System.out.println("Pai: " + (no.pai == null ? "null" : no.pai.chave));
        System.out.println("Chave: " + no.chave);
        System.out.println("Filho esquerdo: " + (no.filhos[0] == null ? "null" : no.filhos[0].chave));
        System.out.println("Filho direito: " + (no.filhos[1] == null ? "null" : no.filhos[1].chave));
        if (isRecursivo) System.out.println();

        if (isRecursivo) NoAVL.getInfo(no.filhos[0], true);
        if (isRecursivo) NoAVL.getInfo(no.filhos[1], true);
    }

    public int max(int a, int b) { 
        return (a > b) ? a : b; 
    } 

    public NoAVL(int chave){
        this.filhos = new NoAVL[2]; 
        this.chave = chave; 
        this.altura = 1;
        this.pai = null;
    }

    public void rotacionaEsquerda(){ 
        int alturaEsq, alturaDir;

        NoAVL filhoDir = this.filhos[1]; 
        NoAVL netoEsq;
        if (filhoDir == null) netoEsq = null;
        else netoEsq = filhoDir.filhos[0]; 
    
        if (filhoDir != null){
            if (this.pai == null) filhoDir.pai = null;
            else if (this.pai.filhos[0].chave == this.chave) this.pai.setFilhoEsquerda(filhoDir);
            else if (this.pai.filhos[1].chave == this.chave) this.pai.setFilhoDireita(filhoDir);

            filhoDir.setFilhoEsquerda(this);
        }
        
        this.setFilhoDireita(netoEsq);
  
        alturaEsq = this.filhos[0] == null ? 0 : this.filhos[0].altura;
        alturaDir = this.filhos[1] == null ? 0 : this.filhos[1].altura;
        this.altura = max(alturaEsq, alturaDir) + 1;

        if (filhoDir != null){
            alturaEsq = filhoDir.filhos[0] == null ? 0 : filhoDir.filhos[0].altura;
            alturaDir = filhoDir.filhos[1] == null ? 0 : filhoDir.filhos[1].altura;
            filhoDir.altura = max(alturaEsq, alturaDir) + 1;
        }
    } 

    public void rotacionaDireita(){
        int alturaEsq, alturaDir;

        NoAVL filhoEsq = this.filhos[0];
        NoAVL netoDir;
        if (filhoEsq == null) netoDir = null;
        else netoDir = filhoEsq.filhos[1]; 
        
        if (filhoEsq != null){
            if (this.pai == null) filhoEsq.pai = null;
            else if (this.pai.filhos[0].chave == this.chave) this.pai.setFilhoEsquerda(filhoEsq);
            else if (this.pai.filhos[1].chave == this.chave) this.pai.setFilhoDireita(filhoEsq);

            filhoEsq.setFilhoDireita(this);
        }

        this.setFilhoEsquerda(netoDir); 
  
        alturaEsq = this.filhos[0] == null ? 0 : this.filhos[0].altura;
        alturaDir = this.filhos[1] == null ? 0 : this.filhos[1].altura;
        this.altura = max(alturaEsq, alturaDir) + 1;

        if (filhoEsq != null){
            alturaEsq = filhoEsq.filhos[0] == null ? 0 : filhoEsq.filhos[0].altura;
            alturaDir = filhoEsq.filhos[1] == null ? 0 : filhoEsq.filhos[1].altura;
            filhoEsq.altura = max(alturaEsq, alturaDir) + 1; 
        }
    } 

    public int getFatorBal() { 
        int alturaEsq = this.filhos[0] == null ? 0 : this.filhos[0].altura;
        int alturaDir = this.filhos[1] == null ? 0 : this.filhos[1].altura;
        return alturaEsq - alturaDir; 
    }

    public void insereNo(int chave){
        if (chave == this.chave) return;

        NoAVL no = new NoAVL(chave); 

        if (chave < this.chave){
            if (this.filhos[0] == null)
                this.setFilhoEsquerda(no);

            else this.filhos[0].insereNo(chave); 
        }

        else if (chave > this.chave){ 
            if (this.filhos[1] == null)
                this.setFilhoDireita(no);

            else this.filhos[1].insereNo(chave); 
        }
  
        int alturaEsq = this.filhos[0] == null ? 0 : this.filhos[0].altura;
        int alturaDir = this.filhos[1] == null ? 0 : this.filhos[1].altura;
        this.altura = 1 + max(alturaEsq, alturaDir); 
  
        int fatorBal = this.getFatorBal();
  
        if (fatorBal > 1 && chave < this.filhos[0].chave) 
            this.rotacionaDireita(); 
  
        else if (fatorBal < -1 && chave > this.filhos[1].chave) 
            this.rotacionaEsquerda(); 
  
        else if (fatorBal > 1 && chave > this.filhos[0].chave) { 
            this.filhos[0].rotacionaEsquerda();
            this.rotacionaDireita(); 
        } 
  
        else if (fatorBal < -1 && chave < this.filhos[1].chave) { 
            this.filhos[1].rotacionaDireita();
            this.rotacionaEsquerda(); 
        }
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

    public void setFilhoEsquerda(NoAVL no){
        this.filhos[0] = no;
        if (no != null) no.pai = this;
    }

    public void setFilhoDireita(NoAVL no){
        this.filhos[1] = no;
        if (no != null) no.pai = this;
    }
}
  
class ArvoreAVL { 
    public NoAVL raiz; 
  
    public int max(int a, int b) { 
        return (a > b) ? a : b; 
    } 
  
    public void insereNo(int chave){
        if (raiz == null)
            raiz = new NoAVL(chave);

        else {
            raiz.insereNo(chave);

            while (this.raiz.pai != null){
                this.raiz = this.raiz.pai;
            }
        }
    }

    public static void main(String[] args) { 
        ArvoreAVL arvore = new ArvoreAVL(); 
  
        arvore.insereNo(10);
        arvore.raiz.mostraArvore();

        arvore.insereNo(20); 
        arvore.raiz.mostraArvore();

        arvore.insereNo(30); 
        arvore.raiz.mostraArvore();

        arvore.insereNo(40); 
        arvore.raiz.mostraArvore();

        arvore.insereNo(50); 
        arvore.raiz.mostraArvore();

        arvore.insereNo(25);
        arvore.raiz.mostraArvore();
    } 
} 