package projetosii;

public class NoBinario extends No {
    
    public NoBinario(int chave){
        filhos = new No[2];
        this.chave = chave;
    }

    @Override
    public boolean inserirNo(No n){
        if (n.chave == this.chave) return false;
        int indice = n.chave < this.chave ? 0 : 1;
        
        if (filhos[indice] == null){
            this.filhos[indice] = n;
            n.pai = this;
            return true;
            
        } else return filhos[indice].inserirNo(n);   
    }

    @Override
    public No buscarNo(int chave) {
        if (chave == this.chave) return this;
        int indice = chave < this.chave ? 0 : 1;
        
        if (this.filhos[indice] == null) return null;
        else return this.filhos[indice].buscarNo(chave);
    }

    @Override
    public void imprimirPreOrdem() {
        System.out.print(chave + " ");
        
        if (this.filhos[0] != null) this.filhos[0].imprimirPreOrdem();
        if (this.filhos[1] != null) this.filhos[1].imprimirPreOrdem();
    }
    
}
