package projalgsii;

public class NoBinario extends No<NoBinario> {
    
    public NoBinario(int chave){
        this.chave = chave;
        this.filhos = new NoBinario[2];
    }

    @Override
    public void insereNo(NoBinario n){
        int indice = n.chave < this.chave ? 0 : 1;

        if (filhos[indice] == null) filhos[indice] = n;
        else filhos[indice].insereNo(n);
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
    public NoBinario encontraNo(int chave){
        if (this.chave == chave) return this;

        int indice = this.chave > chave ? 0 : 1;
        if (this.filhos[indice] == null) return null;
        else return this.filhos[indice].encontraNo(chave); 
    }
}