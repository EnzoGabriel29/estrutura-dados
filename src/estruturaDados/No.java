package estruturaDados;

public abstract class No {
    
    protected int chave;
    protected No pai;
    protected No[] filhos;
    
    public abstract int getAltura();
    public abstract boolean insereNo(No n);
    public abstract No buscaNo(int chave);
    protected abstract void imprimePreOrdem(Boolean b);
    
    public void imprimePreOrdem(){
        this.imprimePreOrdem(true);
        System.out.println();
    }
    
    public void mostraArvore(){
        if (this.filhos[1] != null)
            this.filhos[1].mostraArvore(true, "");
        
       System.out.println(this.chave);
       
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
        
        System.out.println(this.chave);
        
        if (this.filhos[0] != null) {
            String identacao2 = identacao + (isDireita ? " |      " : "        ");
            this.filhos[0].mostraArvore(false, identacao2);
        }
    }
    
}
