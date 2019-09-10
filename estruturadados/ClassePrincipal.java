package estruturadados;

public class ClassePrincipal {
    public static void main(String[] args) {
        NoBinario raiz = new NoBinario(3);
        raiz.insereNo(new NoBinario(1));
        raiz.insereNo(new NoBinario(2));
        raiz.insereNo(new NoBinario(0));
        raiz.insereNo(new NoBinario(4));
        raiz.imprimePreOrdem();

        NoBinario no2 = raiz.encontraNo(1);
        System.out.println(no2.getAltura());
    }
}