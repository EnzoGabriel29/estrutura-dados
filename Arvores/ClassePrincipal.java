<<<<<<< HEAD:Arvores/ClassePrincipal.java
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
=======
package Arvores;

public class Arvores {
    public static void main(String[] args){
        NoBinario raiz = new NoBinario(3);
        Arvore arvore = new Arvore(raiz);    
        
        arvore.inserirNo(new NoBinario(2));
        arvore.inserirNo(new NoBinario(5));
        arvore.inserirNo(new NoBinario(10));
        arvore.inserirNo(new NoBinario(7));
        arvore.imprimirPreOrdem();
        System.out.println();
        
        No no5 = arvore.buscarNo(5);
        no5.imprimirPreOrdem();
        System.out.println();
        
        arvore.inserirNo(new NoBinario(4));
        no5.imprimirPreOrdem();
        System.out.println();
        
        boolean res = arvore.inserirNo(new NoBinario(4));
        System.out.println("Nova inserção com mesma chave: " + res);
    }   
}
>>>>>>> 2bd4ab6bf5934b0c610fecff72efbf00b737b79a:Arvores/Arvores.java
