package EstruturaDados;

import java.util.Arrays;

public class ListaPrioridade { 
    private final Integer[] vetor; 
    private int numElementos; 
    private final int maxElementos; 
  
    public ListaPrioridade(int maxElementos){ 
        this.maxElementos = maxElementos; 
        this.numElementos = 0; 
        this.vetor = new Integer[this.maxElementos]; 
    } 
    
    public ListaPrioridade(Integer[] elementos){
        this.maxElementos = elementos.length;
        this.numElementos = 0;
        for (Integer elemento: elementos){
            if (elemento != null)
                this.numElementos++;
        }
        
        this.vetor = elementos;
        this.mostraArvore();
        for (int i = this.numElementos/2-1; i >= 0; i--){
            System.out.println(i);
            this.decrementaChave(i);
            this.mostraArvore();
        }
            
    }
    
    public void alteraPrioridade(int pos, int novaChave){
        this.vetor[pos] = novaChave;
        
        if (this.vetor[pos] > novaChave)
            this.decrementaChave(pos);
        
        else this.incrementaChave(pos);
    }
    
    public void decrementaChave(int pos){
        int i = 2 * pos + 2;
        
        int aux, maiorInd;
        while (i < this.numElementos){
            maiorInd = i;
            if (maiorInd < this.numElementos-1 && this.vetor[maiorInd] < this.vetor[maiorInd+1]) 
                maiorInd++;
            
            if (this.vetor[pos] < this.vetor[maiorInd]){
                aux = this.vetor[pos];
                this.vetor[pos] = this.vetor[maiorInd];
                this.vetor[maiorInd] = aux;
                
                pos = maiorInd;
                i = 2 * pos + 2;
            
            } else i = this.numElementos + 1;
        }
    }
    
    public void incrementaChave(int pos){
        int aux, i = pos / 2;
        while (pos > 1 && this.vetor[i] < this.vetor[pos]){
            aux = this.vetor[pos];
            this.vetor[pos] = this.vetor[i];
            this.vetor[i] = aux;
            
            pos = i;
            i = pos / 2;
        }
    }
    
    public void insereChave(int chave){
        this.vetor[this.numElementos++] = chave;
        this.incrementaChave(this.numElementos);
    }
    
    public int removeMax(){
        if (this.numElementos == 0) throw new IndexOutOfBoundsException();
        int valorMax = this.vetor[0];
        this.numElementos--;
        this.decrementaChave(0);
        return valorMax;
    }
    
    public void mostraArvore(){
        System.out.println(Arrays.toString(this.vetor));
    }
    
    public static void main(String[] args){
        Integer[] vetor = {4, 1, 3, 2, 16, 9, 10};
        ListaPrioridade l = new ListaPrioridade(vetor);
        l.mostraArvore();
    }
} 
