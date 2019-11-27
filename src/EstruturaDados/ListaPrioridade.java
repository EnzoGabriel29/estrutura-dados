package EstruturaDados;

public class ListaPrioridade { 
    private final int[] vetor; 
    private int numElementos; 
    private final int maxElementos; 
  
    public ListaPrioridade(int maxElementos){ 
        this.maxElementos = maxElementos; 
        this.numElementos = 0; 
        this.vetor = new int[this.maxElementos + 1]; 
    } 
  
    private int getPai(int pos){ 
        return pos / 2; 
    } 
 
    private int getFilhoEsquerda(int pos){ 
        return 2 * pos; 
    } 
    
    private int getFilhoDireita(int pos){ 
        return 2 * pos + 1; 
    } 
  
    private boolean isFolha(int pos){ 
        return pos >= (this.numElementos / 2) && pos <= this.numElementos; 
    } 
  
    private void trocaNo(int pos1, int pos2){ 
        int aux; 
        aux = this.vetor[pos1]; 
        this.vetor[pos1] = this.vetor[pos2]; 
        this.vetor[pos2] = aux; 
    } 
  
    private void transformaMaxHeap(int pos){ 
        if (this.isFolha(pos)) return; 
        
        int posEsq = this.getFilhoEsquerda(pos);
        int posDir = this.getFilhoDireita(pos);
        if (this.vetor[pos] < this.vetor[posEsq] || this.vetor[pos] < this.vetor[posDir]) { 
            if (this.vetor[posEsq] > vetor[posDir]) { 
                this.trocaNo(pos, posEsq);
                posEsq = this.getFilhoEsquerda(pos);
                this.transformaMaxHeap(posEsq); 
            
            } else { 
                this.trocaNo(pos, posDir);
                posDir = this.getFilhoDireita(pos);
                this.transformaMaxHeap(posDir); 
            } 
        } 
    } 
  
    public void insereChave(int chave){ 
        if (this.numElementos == this.maxElementos) return;
        
        this.vetor[this.numElementos++] = chave; 
  
        int posAtual = this.numElementos; 
        while (this.vetor[posAtual] > this.vetor[getPai(posAtual)]) { 
            this.trocaNo(posAtual, this.getPai(posAtual)); 
            posAtual = this.getPai(posAtual); 
        } 
    } 
    
    public int getMaiorChave(){ 
        int elemento = this.vetor[0]; 
        this.vetor[0] = this.vetor[this.numElementos--]; 
        this.transformaMaxHeap(0); 
        return elemento; 
    } 
} 
