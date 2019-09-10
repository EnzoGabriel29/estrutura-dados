package arvores;

public class ClassePrincipal {
    public static void main(String[] args) {
        NoBinario raiz = new NoBinario(5);
        Arvore arvore = new Arvore(raiz);
        
        arvore.inserirNo(new NoBinario(3));
        arvore.inserirNo(new NoBinario(2));
        
        arvore.imprimirPreOrdem();
        System.out.println();

        No noAux = arvore.buscarNo(2);
        System.out.println(noAux.retornaFB());
    }
}
