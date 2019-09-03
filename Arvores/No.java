package Arvores;

public abstract class No {
    protected int chave;
    protected No pai;
    protected No[] filhos;

    @Override
    public String toString() {
        return this == null ? null : String.format("%d", chave);
    }
         
    public abstract boolean inserirNo(No n);
    public abstract No buscarNo(int chave);
    public abstract void imprimirPreOrdem();
}