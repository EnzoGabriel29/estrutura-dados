package estruturaDados;

public class NoAVL extends NoBinario {
    
    public NoAVL(int chave){
        super(chave);
    }
    
    public int getFatorBal(){
        int alturaEsq, alturaDir;
        
        if (this.filhos[0] == null) alturaEsq = 0;
        else alturaEsq = this.filhos[0].getAltura();
        
        if (this.filhos[1] == null) alturaDir = 0;
        else alturaDir = this.filhos[1].getAltura();
        
        return alturaEsq - alturaDir;
    }

    @Override
    public boolean insereNo(No n){
        if (super.insereNo(n)){            
            if (Math.abs(this.getFatorBal()) > 1){
                this.balanceiaNo();
                
            }
            
            return true;
        }
        
        return false;
    }

    @Override
    protected void imprimePreOrdem(Boolean b){
        System.out.print(this.chave + "(" + this.getFatorBal() + ") ");
        
        if (filhos[0] != null) filhos[0].imprimePreOrdem(b);
        if (filhos[1] != null) filhos[1].imprimePreOrdem(b);
    }
    
    public void balanceiaNo(){
        if (!(Math.abs(this.getFatorBal()) > 1)) return;
        
        int ind1 = this.getFatorBal() > 1 ? 0 : 1;
        NoAVL noFilho = (NoAVL) this.filhos[ind1];
        int ind2 = noFilho.getFatorBal() > 0 ? 0 : 1;
        
        // Rotação à direita, visto que a árvore está
        // desbalanceada para a esquerda em ambos os nós.
        if (ind1 == 0 && ind2 == 0){
            noFilho.pai = this.pai;
            this.pai.filhos[ind1] = noFilho;
            
            this.pai = noFilho;
            this.filhos[0] = this.pai.filhos[1];
            this.pai.filhos[1] = this;
        
        // Rotação à esquerda, visto que a árvore está
        // desbalanceada para a direita em ambos os nós.
        } else if (ind1 == 1 && ind2 == 1){
            noFilho.pai = this.pai;
            this.pai.filhos[ind1] = noFilho;
            this.pai = noFilho;
            this.filhos[1] = this.pai.filhos[0];
            this.pai.filhos[0] = this;
        }
    }
        
}
