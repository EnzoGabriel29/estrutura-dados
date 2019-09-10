<<<<<<< HEAD
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
=======
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
>>>>>>> 2bd4ab6bf5934b0c610fecff72efbf00b737b79a
