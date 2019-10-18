package estruturaDados;

public class NoBinario extends No {
    
    public NoBinario(int chave){
        filhos = new No[2];
        this.chave = chave;
    }

    @Override
    public boolean insereNo(No n){
        if (n.chave == this.chave) return false;
        int indice = n.chave < this.chave ? 0 : 1;
        
        if (filhos[indice] == null){
            this.filhos[indice] = n;
            n.pai = this;
            return true;
            
        } else return filhos[indice].insereNo(n);   
    }

    @Override
    public No buscaNo(int chave) {
        if (chave == this.chave) return this;
        int indice = chave < this.chave ? 0 : 1;
        
        if (this.filhos[indice] == null) return null;
        return this.filhos[indice].buscaNo(chave);
    }

    @Override
    protected void imprimePreOrdem(Boolean b){
        System.out.print(chave + " ");
        
        if (this.filhos[0] != null) this.filhos[0].imprimePreOrdem(b);
        if (this.filhos[1] != null) this.filhos[1].imprimePreOrdem(b);
    }
    
    @Override
    public int getAltura(){
        int alturaEsq, alturaDir;
        
        if (this.filhos[0] == null) alturaEsq = 0;
        else alturaEsq = this.filhos[0].getAltura();
        
        if (this.filhos[1] == null) alturaDir = 0;
        else alturaDir = this.filhos[1].getAltura();
        
        return 1 + (alturaEsq > alturaDir ? alturaEsq : alturaDir);
    }
    
}
