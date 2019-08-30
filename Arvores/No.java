package Arvores;

abstract public class No {
    protected int dado;
    protected No pai;
    protected No[] filhos;
    
    public abstract void inserirNo(No n);
    public abstract void imprimirPreOrdem();
}
