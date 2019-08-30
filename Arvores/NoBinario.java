package Arvores;

public class NoBinario extends No {
    public NoBinario(int dado){
        this.dado = dado;
        this.filhos = new No[2];
    }

    @Override
    public void inserirNo(No no) {
        int indice = (no.dado > this.dado) ? 1 : 0;
        if (this.filhos[indice] == null) this.filhos[indice] = no;
        else this.filhos[indice].inserirNo(no);
    }

    @Override
    public void imprimirPreOrdem() {
        System.out.print(this.dado + " ");
        if (filhos[0] != null) filhos[0].imprimirPreOrdem();
        if (filhos[1] != null) filhos[1].imprimirPreOrdem();
    }
}