package EstruturaDados.Arvore;

public class NoBalanceado extends NoBinario {
    public NoBalanceado(int chave){
        super(chave);
    }
    
    public void rotacionaEsquerda(){        
        NoBalanceado filhoDir = (NoBalanceado) this.filhos[1]; 
        NoBalanceado netoEsq;
        if (filhoDir == null) netoEsq = null;
        else netoEsq = (NoBalanceado) filhoDir.filhos[0]; 
    
        if (filhoDir != null){
            if (this.pai == null)
                filhoDir.pai = null;
            
            else if (this.pai.filhos[0] == this)
                ((NoBalanceado) this.pai).setFilho(filhoDir, 0);
            
            else if (this.pai.filhos[1] == this)
                ((NoBalanceado) this.pai).setFilho(filhoDir, 1);

            filhoDir.setFilho(this, 0);
        }
        
        this.setFilho(netoEsq, 1);
    } 

    public void rotacionaDireita(){        
        NoBalanceado filhoEsq = (NoBalanceado) this.filhos[0];
        NoBalanceado netoDir;
        if (filhoEsq == null) netoDir = null;
        else netoDir = (NoBalanceado) filhoEsq.filhos[1]; 
        
        if (filhoEsq != null){
            if (this.pai == null)
                filhoEsq.pai = null;
            
            else if (this.pai.filhos[0] == this)
                ((NoBalanceado) this.pai).setFilho(filhoEsq, 0);
            
            else if (this.pai.filhos[1] == this)
                ((NoBalanceado) this.pai).setFilho(filhoEsq, 1);

            filhoEsq.setFilho(this, 1);
        }

        this.setFilho(netoDir, 0);
    }     
}
