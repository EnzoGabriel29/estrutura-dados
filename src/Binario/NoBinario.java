package Binario;
import No.No;

public class NoBinario extends No {
    public int chave;
    
    public NoBinario(int chave){
        this.filhos = new NoBinario[2];
        this.chave = chave;
    }
        
    @Override
    public void insereNo(No n){
        NoBinario no = (NoBinario) n;
        if (this.chave == no.chave) return;
        
        int i = no.chave < this.chave ? 0 : 1;
        
        if (this.filhos[i] == null)
            this.setFilho(no, i);
        
        else this.filhos[i].insereNo(no);
    }

    @Override
    public void removeNo(int chave) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public No buscaNo(int chave){
        if (chave == this.chave) return this;
        
        int i = chave < this.chave ? 0 : 1;
        if (this.filhos[i] == null) return null;
        return this.filhos[i].buscaNo(chave);
    }
    
    @Override
    public void setFilho(No no, int pos){
        this.filhos[pos] = no;
        if (no != null) no.pai = this;
    }
    
    // FONTE: How to print binary tree diagram?
    // AUTOR: Laurent Demailly
    // https://stackoverflow.com/a/19484210/
    @Override
    public void mostraArvore(){
        if (this.filhos[1] != null)
            ((NoBinario) this.filhos[1]).mostraArvore(true, "");
        
       System.out.println(this.toString());
       
        if (this.filhos[0] != null)
            ((NoBinario) this.filhos[0]).mostraArvore(false, "");
        
        System.out.println();
    }  
    
    private void mostraArvore(boolean isDireita, String identacao){
        if (this.filhos[1] != null){
            String identacao1 = identacao + (isDireita ? "        " : " |      ");
            ((NoBinario) this.filhos[1]).mostraArvore(true, identacao1);
        }
        
        System.out.print(identacao);
        System.out.print(isDireita ? " ," : " `");
        System.out.print("----- ");
        
        System.out.println(this.toString());
        
        if (this.filhos[0] != null){
            String identacao2 = identacao + (isDireita ? " |      " : "        ");
            ((NoBinario) this.filhos[0]).mostraArvore(false, identacao2);
        }
    }
}
