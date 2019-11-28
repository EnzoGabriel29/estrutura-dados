package EstruturaDados.PesquisaDigital;

public class NoTrie { 
    public NoTrie[] filhos; 
    public final int tamanho;
    public boolean isFimPalavra; 
          
    public NoTrie(int tamanho){ 
        this.tamanho = tamanho;
        this.filhos = new NoTrie[tamanho];
        this.isFimPalavra = false;
    } 
    
    public boolean isVazio(){ 
        for (int i = 0; i < tamanho; i++) 
            if (this.filhos[i] != null) 
                return false; 
        
        return true; 
    } 
}; 