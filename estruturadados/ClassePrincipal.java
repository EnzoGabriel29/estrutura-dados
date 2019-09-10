package projalgsii;

public class ClassePrincipal {
    public static void main(String[] args) {
        NoAVL raiz1 = new NoAVL(10);
        raiz1.insereNo(new NoAVL(6));
        raiz1.insereNo(new NoAVL(3));
        raiz1.insereNo(new NoAVL(7));
        raiz1.insereNo(new NoAVL(2));
        raiz1.insereNo(new NoAVL(4));
        raiz1.insereNo(new NoAVL(15));
        raiz1.insereNo(new NoAVL(17));
        raiz1.imprimePreOrdem();
        
        raiz1.insereNo(new NoAVL(1));
        raiz1.imprimePreOrdem();
        raiz1.encontraNo(6).balanceiaNo(raiz1);
        raiz1.imprimePreOrdem();
        
        System.out.println();
        
        NoAVL raiz2 = new NoAVL(32);
        raiz2.insereNo(new NoAVL(31));
        raiz2.insereNo(new NoAVL(35));
        raiz2.insereNo(new NoAVL(33));
        raiz2.insereNo(new NoAVL(36));
        raiz2.imprimePreOrdem();
        
        raiz2.insereNo(new NoAVL(38));
        raiz2.imprimePreOrdem();
    }
}