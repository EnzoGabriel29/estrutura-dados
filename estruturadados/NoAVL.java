package projalgsii;

public class NoAVL extends No<NoAVL> {
    
    public NoAVL(int chave){
        this.chave = chave;
        this.filhos = new NoAVL[2];
    }

    @Override
    public void insereNo(NoAVL n){
        int indice = n.chave < this.chave ? 0 : 1;

        if (filhos[indice] == null) filhos[indice] = n;
        else filhos[indice].insereNo(n);
        
        // TODO - balanceia arvore
    }

    @Override
    public int getAltura(){
        int alturaEsquerda = this.filhos[0] == null ? 0 : this.filhos[0].getAltura();
        int alturaDireita = this.filhos[1] == null ? 0 : this.filhos[1].getAltura();
        return 1 + (alturaEsquerda > alturaDireita ? alturaEsquerda : alturaDireita);       
    }
    
    @Override
    public void imprimePreOrdem(){
        this.imprimePreOrdem(true);
        System.out.println();
    }

    @Override
    protected void imprimePreOrdem(boolean v){
        System.out.print(this.chave + " ");
        if (this.filhos[0] != null) this.filhos[0].imprimePreOrdem(true);
        if (this.filhos[1] != null) this.filhos[1].imprimePreOrdem(true);
    }

    @Override
    public NoAVL encontraNo(int chave){
        if (this.chave == chave) return this;

        int indice = this.chave > chave ? 0 : 1;
        if (this.filhos[indice] == null) return null;
        else return this.filhos[indice].encontraNo(chave); 
    }
    
    public int getFB(){
        int alturaEsquerda = this.filhos[0] == null ? 0 : this.filhos[0].getAltura();
        int alturaDireita = this.filhos[1] == null ? 0 : this.filhos[1].getAltura();
        return alturaEsquerda - alturaDireita;
    }
        
    public void balanceiaNo(NoAVL noPai){
        int indice = this.getFB() > -1 ? 0 : 1;
        NoAVL noFilho = this.filhos[indice];
        NoAVL noNeto;
        
        // rotação à direita
        noNeto = noFilho.filhos[0];
        if (noFilho.getFB() >= 1 && noNeto.getFB() >= 1){
            if (noPai != null){
                noPai.filhos[0] = noFilho;
                this.filhos[0] = noFilho.filhos[1];
                noFilho.filhos[1] = this;
            }
        }
    }   
}
