package projetosii;

public abstract class No {
    
    protected int chave;
    protected No pai;
    protected No[] filhos;
    
    public abstract boolean inserirNo(No n);
    public abstract No buscarNo(int chave);
    public abstract void imprimirPreOrdem();
    
}
