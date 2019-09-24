package projetosii;

public class ProjetosII {

    public static void main(String[] args) {
        NoAVL raiz = new NoAVL(30);
        Arvore arvore = new Arvore(raiz);
        
        arvore.inserirNo(new NoAVL(5));
        arvore.inserirNo(new NoAVL(35));
        arvore.inserirNo(new NoAVL(32));
        arvore.inserirNo(new NoAVL(40));
   
        arvore.imprimirPreOrdem();
        System.out.println();
        
        arvore.inserirNo(new NoAVL(45));
        arvore.imprimirPreOrdem();
        
        NoAVL noDesbal = (NoAVL) arvore.buscarNo(30);
        noDesbal.balanceiaNo();
        arvore.imprimirPreOrdem();
        System.out.println();
        
    }
    
}
