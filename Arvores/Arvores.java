package Arvores;

public class Arvores {
    public static void main(String[] args) {
        NoBinario raiz = new NoBinario(3);
        Arvore arvore = new Arvore(raiz);
        
        arvore.inserirNo(new NoBinario(2));
        arvore.inserirNo(new NoBinario(5));
        arvore.inserirNo(new NoBinario(10));
        arvore.inserirNo(new NoBinario(7));
        
        arvore.imprimirPreOrdem();
        System.out.println();
    }
}
