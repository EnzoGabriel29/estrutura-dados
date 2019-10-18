package estruturaDados;

public class ClassePrincipal {
    
    public static void main(String[] args) {
        ArvoreAVL a1 = new ArvoreAVL(new NoAVL(9));
        a1.mostraArvore();
        
        a1.insereNo(new NoAVL(11));
        a1.mostraArvore();
        
        a1.insereNo(new NoAVL(7));
        a1.mostraArvore();
        
        a1.insereNo(new NoAVL(5));
        a1.mostraArvore();
        
        a1.insereNo(new NoAVL(3));
        a1.mostraArvore();
        
        a1.insereNo(new NoAVL(13));
        a1.mostraArvore();
        
        a1.insereNo(new NoAVL(15));
        a1.mostraArvore();
    }
    
}