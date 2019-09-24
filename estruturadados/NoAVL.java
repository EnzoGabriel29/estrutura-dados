package projetosii;

public class NoAVL extends NoBinario {

    int fatorBal;
    
    public NoAVL(int chave){
        super(chave);
        fatorBal = 0;
    }
    
    public No retornaValor(No n){
        return n == null ? null : n;
    }

    @Override
    public boolean inserirNo(No n) {
        if (super.inserirNo(n)){
            ajustaBal(n);
            return true; 
        }
        
        return false;
    }
    
    private void ajustaBal(No n){
        NoAVL navl = (NoAVL) n;
        if (n.pai == null) return;

        NoAVL nAVLPai = (NoAVL) n.pai;
        if(navl.fatorBal+1 > nAVLPai.fatorBal){
            nAVLPai.fatorBal = navl.fatorBal+1;
            ajustaBal(nAVLPai);
        }
    }

    @Override
    public void imprimirPreOrdem() {
        System.out.print(chave + "(" + fatorBal + ") ");
        
        if (filhos[0] != null) filhos[0].imprimirPreOrdem();
        if (filhos[1] != null) filhos[1].imprimirPreOrdem();
    }
    
    public void balanceiaNo(){
        int indice = this.fatorBal > -1 ? 0 : 1;
        NoAVL noFilho = (NoAVL) this.filhos[indice];
        NoAVL noNeto;
        
        noNeto = (NoAVL) noFilho.filhos[indice];
        
        if (indice == 0){
            // rotação à direita
            if (noFilho.fatorBal >= 1 && noNeto.fatorBal >= 1){
                if (this.pai != null) this.pai.filhos[0] = noFilho;

                this.filhos[0] = noFilho.filhos[1];
                noFilho.filhos[1] = this;

            // rotação dupla à direita
            } else {
                if (this.pai != null) this.pai = noNeto;
                
                noNeto.filhos[0] = noFilho;
                noNeto.filhos[1] = this;
                this.filhos[0] = noNeto.filhos[1];
                noFilho.filhos[1] = noNeto.filhos[0];
            }
            
        } else {
            // rotação à esquerda
            if (noFilho.fatorBal <= -1 && noNeto.fatorBal <= -1){
                if (this.pai != null) this.pai.filhos[0] = noFilho;
                
                this.filhos[1] = noFilho.filhos[0];
                noFilho.filhos[0] = this;
                
            // rotação dupla à esquerda
            } else {
                if (this.pai != null) this.pai = noNeto;
                
                this.filhos[1] = noNeto == null ? null : noNeto.filhos[0];
                
                if (noFilho != null)
                    noFilho.filhos[0] = noNeto == null ? null : noNeto.filhos[1];
                
                if (noNeto != null){
                    noNeto.filhos[0] = this;
                    noNeto.filhos[1] = noFilho == null ? null : noFilho;
                }
            }
        }
        
    }
        
}
