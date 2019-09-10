package arvores;

abstract public class No {
    protected int chave;
    protected No pai;
    protected No[] filhos;
    
    public abstract void inserirNo(No n);
    public abstract void imprimirPreOrdem();
    public abstract void imprimirOrdemSim();
    public abstract void imprimirPosOrdem();
    public abstract No buscarNo(int chave);
    public abstract int retornaAltura();
    public abstract int retornaFB();
}
