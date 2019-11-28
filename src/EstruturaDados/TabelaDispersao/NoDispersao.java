package EstruturaDados.TabelaDispersao;

public class NoDispersao<T> {  
    public T chave; 
    public int valor; 
    public NoDispersao<T> proximo; 
  
    public NoDispersao(T chave, int valor){ 
        this.chave = chave; 
        this.valor = valor; 
    }
    
    public Integer buscaValor(T chave){
        NoDispersao<T> noAtual = this;
        
        while (noAtual != null) { 
            if (noAtual.chave == chave) 
                return noAtual.valor;

            noAtual = noAtual.proximo; 
        } 

        return null; 
    }
} 
