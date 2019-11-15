package No;

abstract public class No {
    public No pai;
    public No[] filhos;

    abstract public void insereNo(No no);
    abstract public void removeNo(int chave);
    abstract public No buscaNo(int chave);
    abstract public void setFilho(No no, int pos);
    abstract public void mostraArvore();
}
