package arvores;

public class NoBinario extends No {
    public NoBinario(int chave){
        this.chave = chave;
        this.filhos = new No[2];
    }

    @Override
    public void inserirNo(No no) {
        int indice = (no.chave > this.chave) ? 1 : 0;
        if (this.filhos[indice] == null) this.filhos[indice] = no;
        else this.filhos[indice].inserirNo(no);
    }

    @Override
    public void imprimirPreOrdem() {
        System.out.print(this.chave + " ");
        if (filhos[0] != null) filhos[0].imprimirPreOrdem();
        if (filhos[1] != null) filhos[1].imprimirPreOrdem();
    }

    @Override
    public void imprimirOrdemSim() {
        System.out.print(this.chave + " ");
        if (filhos[0] != null) filhos[0].imprimirOrdemSim();
        if (filhos[1] != null) filhos[1].imprimirOrdemSim();
    }

    @Override
    public void imprimirPosOrdem() {
        if (filhos[0] != null) filhos[0].imprimirPosOrdem();
        if (filhos[1] != null) filhos[1].imprimirPosOrdem();
        System.out.print(this.chave + " ");
    }

    @Override
    public No buscarNo(int chave) {
        if (chave == this.chave) return this;
        
        int indice = chave < this.chave ? 0 : 1;
        return filhos[indice] == null ? null : filhos[indice].buscarNo(chave);        
    }

    @Override
    public int retornaAltura(){
        int alturaEsq = 0, alturaDir = 0;
        if (filhos[0] == null && filhos[1] == null) return 1;
        if (filhos[0] != null) alturaEsq = filhos[0].retornaAltura();
        if (filhos[1] != null) alturaDir = filhos[1].retornaAltura();
        return 1 + (alturaEsq > alturaDir ? alturaEsq : alturaDir);
    }

    @Override
    public int retornaFB(){
        return filhos[0].retornaAltura() - filhos[1].retornaAltura();
    }
}