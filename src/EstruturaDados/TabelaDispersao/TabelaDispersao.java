package EstruturaDados.TabelaDispersao;

import java.util.ArrayList;

public class TabelaDispersao<T> {
    private final ArrayList<NoDispersao<T>> buckets; 
    private final int numBuckets;
    public int tamanho; 
  
    public TabelaDispersao(int tamanho){ 
        this.buckets = new ArrayList<>(tamanho);
        for (int i = 0; i < tamanho; i++) buckets.add(null);
        this.numBuckets = tamanho; 
        this.tamanho = 0;
    }
  
    private int retornaIndice(T chave){
        return chave.hashCode() % this.numBuckets;
    } 
    
    public Integer buscaValor(T chave){ 
        int indice = this.retornaIndice(chave); 
        NoDispersao<T> no = this.buckets.get(indice);
        
        return no == null ? null : no.buscaValor(chave);
    } 
    
    public void adicionaValor(T chave, int valor){ 
        int indice = this.retornaIndice(chave); 
        
        NoDispersao<T> noAtual = this.buckets.get(indice);
  
        this.tamanho++;
        NoDispersao<T> novoNo = new NoDispersao<>(chave, valor); 
        novoNo.proximo = noAtual; 
        this.buckets.set(indice, novoNo);
    }
  
    public Integer removeChave(T chave){ 
        int indice = this.retornaIndice(chave);
        NoDispersao<T> noAtual = this.buckets.get(indice); 
        NoDispersao<T> noAnterior = null; 
        
        while (noAtual != null){
            if (noAtual.chave == chave) break; 
  
            noAnterior = noAtual; 
            noAtual = noAtual.proximo; 
        } 
  
        if (noAtual == null) return null; 
  
        this.tamanho--; 
  
        if (noAnterior != null) 
            noAnterior.proximo = noAtual.proximo; 
        else
            this.buckets.set(indice, noAtual.proximo); 
  
        return noAtual.valor; 
    }
    
    public static void main(String[] args){
        TabelaDispersao<String> t = new TabelaDispersao<>(5);
        t.adicionaValor("this", 1); 
        t.adicionaValor("coder", 2); 
        t.adicionaValor("this", 4); 
        t.adicionaValor("hi", 5); 
        
        System.out.println("Tamanho: " + t.tamanho); 
        System.out.println("Chave 'this': " + t.buscaValor("this"));
        System.out.println("Removendo chave 'this'...");
        t.removeChave("this"); 
        System.out.println("Chave 'this': " + t.buscaValor("this"));
        t.removeChave("this");  
        System.out.println("Tamanho: " + t.tamanho); 
    }
} 