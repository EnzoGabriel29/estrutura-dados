package EstruturaDados.PesquisaDigital;

public class ArvoreTrie { 
    public final int tamanho; 
    public NoTrie raiz;  

    public ArvoreTrie(int tamanho){
        this.tamanho = tamanho;
    }
    
    public void insereChave(String chave){ 
        if (this.raiz == null)
            this.raiz = new NoTrie(tamanho);
        
        int indice; 
        int tamanhoChave = chave.length();
       
        NoTrie noAtual = raiz; 
       
        for (int nivel = 0; nivel < tamanhoChave; nivel++){ 
            indice = chave.charAt(nivel) - 'a'; 
            if (noAtual.filhos[indice] == null) 
                noAtual.filhos[indice] = new NoTrie(this.tamanho); 
       
            noAtual = noAtual.filhos[indice]; 
        } 
       
        noAtual.isFimPalavra = true; 
    } 
       
    public boolean buscaChave(String chave){ 
        int indice; 
        int tamanhoChave = chave.length(); 
        NoTrie noAtual = raiz; 
       
        for (int nivel = 0; nivel < tamanhoChave; nivel++) { 
            indice = chave.charAt(nivel) - 'a'; 
            if (noAtual.filhos[indice] == null) 
                return false; 
       
            noAtual = noAtual.filhos[indice]; 
        } 
       
        return noAtual != null && noAtual.isFimPalavra; 
    } 
    
    public void removeNo(String chave){
        this.removeNo(this.raiz, chave, 0);
    }
    
    private void removeNo(NoTrie no, String chave, int nivel){
        if (no == null) return;
        
        int indice = chave.charAt(nivel) - 'a';
        NoTrie noFilho = no.filhos[indice];
        
        if (nivel == chave.length()-1){
            if (noFilho.isFimPalavra)
                noFilho.isFimPalavra = false;
            
            no.filhos[indice] = null;
            
        } else {
            this.removeNo(noFilho, chave, nivel+1);
            
            if (noFilho.isVazio() && !noFilho.isFimPalavra)
                no.filhos[indice] = null;
        }
    }
       
    public static void main(String args[]){
        System.out.println("Inserção:");
        String chaves1[] = {"the", "a", "there",
            "answer", "any", "by", "bye", "their"}; 
       
        ArvoreTrie a1 = new ArvoreTrie(26);
       
        for (String chave: chaves1)
            a1.insereChave(chave); 
        
        mostraBusca(a1, "the");
        mostraBusca(a1, "these");
        mostraBusca(a1, "their");
        mostraBusca(a1, "thaw");
        mostraBusca(a1, "ans");
        mostraBusca(a1, "answer");
        
        System.out.println("Remoção:");
        String chaves2[] = {"the", "a", "there", "answer", "any",
            "by", "bye", "their", "hero", "heroplane"}; 
        
        ArvoreTrie a2 = new ArvoreTrie(26);
       
        for (String chave: chaves2)
            a2.insereChave(chave); 
        
        mostraBusca(a2, "the");
        mostraBusca(a2, "these");
        a2.removeNo("heroplane");
        mostraBusca(a2, "heroplane");
        mostraBusca(a2, "hero");
    } 
    
    public static void mostraBusca(ArvoreTrie a, String chave){
        String saida[] = {"Presente", "Ausente"}; 
        int i = a.buscaChave(chave) ? 0 : 1;
        System.out.println(chave + " --- " + saida[i]);
    }
} 