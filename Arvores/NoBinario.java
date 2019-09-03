package Arvores;

public class NoBinario extends No {
    public NoBinario(int chave){
        filhos = new No[2];
        this.chave = chave;
    }

    @Override
    public boolean inserirNo(No n){
        if (n.chave == this.chave) return false;
        
        int indice = n.chave > chave ? 1 : 0;
        if (filhos[indice] == null){
            filhos[indice] = n;
            return true;
        } else return filhos[indice].inserirNo(n);
    }

    @Override
    public void imprimirPreOrdem(){
        System.out.print(chave + " ");
        
        if(filhos[0] != null) filhos[0].imprimirPreOrdem();
        if(filhos[1] != null) filhos[1].imprimirPreOrdem();
    } 

    @Override
    public No buscarNo(int chave){
        if (chave == this.chave) return this;
        
        int indice = chave > this.chave ? 1 : 0;
        return filhos[indice] == null ? null : filhos[indice].buscarNo(chave);
    }
}