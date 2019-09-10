package projalgsii;

abstract public class No<T extends No> {
    protected int chave;
    protected T[] filhos;

    abstract public void insereNo(T n);
    abstract public int getAltura();
    abstract public void imprimePreOrdem();
    abstract protected void imprimePreOrdem(boolean v);
    abstract public T encontraNo(int chave);
}