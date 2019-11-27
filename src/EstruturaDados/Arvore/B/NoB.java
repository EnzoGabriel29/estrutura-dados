package EstruturaDados.Arvore.B;

import EstruturaDados.Arvore.No;
import java.util.Arrays;

public class NoB extends No {
    public ArvoreB arvore;
    public final int grau;
    public final Integer[] chaves;
    public int numChaves, numFilhos;
    
    public NoB(int grau){
        this.arvore = ArvoreB.getInstance(grau);
        this.grau = grau;
        this.chaves = new Integer[2*grau-1];
        this.filhos = new NoB[2*grau];
        this.numChaves = 0;
        this.numFilhos = 0;
    }

    public boolean isFolha(){
        return this.filhos[0] == null;
    }

    public boolean isCheioChaves(){
        return this.numChaves == 2*this.grau - 1;
    }
    
    public boolean isCheioFilhos(){
        return this.numFilhos == 2*this.grau;
    }
    
    @Override
    public No buscaNo(int chave) {
        int i = 0;
        for (; i < this.numChaves && chave > this.chaves[i]; i++){}
        
        if (this.chaves[i] == chave) return this;
        if (this.isFolha()) return null;
        return this.filhos[i].buscaNo(chave);
    }

    public void divideNo(){
        NoB novoNo = new NoB(this.grau);
        int mediana = this.grau - 1;
        
        for (int i = 0; i < mediana; i++){
            novoNo.setChave(this.chaves[i+this.grau], i);
            this.setChave(null, i+this.grau);
        }

        if (!this.isFolha()){
            for (int i = 0; i < mediana+1; i++){
                novoNo.setFilho(this.filhos[i+this.grau], i);
                this.setFilho(null, i+this.grau);
            }
        }
        
        NoB noPai;
        if (this.pai == null){
            noPai = new NoB(this.grau);
            this.pai = noPai;
            noPai.insereNo(this);
        
        } else noPai = (NoB) this.pai;
        
        noPai.insereNo(novoNo);
                
        int i = 0;
        while (i < noPai.numChaves && this.chaves[mediana] > noPai.chaves[i]) i++;
        
        for (int j = noPai.numChaves-1; j >= i; j--){
            noPai.chaves[j+1] = noPai.chaves[j];
            noPai.chaves[j] = null;
        }
        
        noPai.chaves[i] = this.chaves[mediana];
        noPai.numChaves++;
        
        this.setChave(null, mediana);
        
        arvore.atualizaRaiz();
        arvore.mostraArvore();
    }
    
    public void setChave(Integer chave, int pos){
        if (this.chaves[pos] == null && chave != null) this.numChaves++;
        else if (this.chaves[pos] != null && chave == null) this.numChaves--;
        this.chaves[pos] = chave;
    }
    
    @Override
    public void setFilho(No n, int pos){
        NoB no = (NoB) n;
        if (this.filhos[pos] == null && no != null) this.numFilhos++;
        else if (this.filhos[pos] != null && no == null) this.numFilhos--;
        
        if (no != null) no.pai = this;
        this.filhos[pos] = no;
    }

    @Override
    public void insereChave(int chave){
        System.out.println("Inserindo a chave " + chave + ":");
        
        int i = 0;
        while (i < this.numChaves && chave > this.chaves[i]) i++;
        
        if (!this.isFolha()){
            System.out.println("Posição do filho a ser inserido: " + i);
            this.filhos[i].insereChave(chave);
            return;
        }
        
        if (this.isCheioChaves()){
            NoB noPai = (NoB) this.pai;
            
            if (noPai != null && noPai.isCheioFilhos()){
                System.out.println("Nó pai cheio, efetuando divisão:");
                noPai.divideNo();
            }
                
            System.out.println("Nó cheio, efetuando divisão:");
            this.divideNo();
            this.pai.insereChave(chave);
            return;
        }

        System.out.println("Posição da chave a ser inserida: " + i);
        for (int j = this.numChaves-1; j >= i; j--){
            this.chaves[j+1] = this.chaves[j];
            this.chaves[j] = null;
        }

        this.chaves[i] = chave;
        this.numChaves++;
    }
    
    @Override
    public void insereNo(No n){
        NoB no = (NoB) n;
        
        if (this.isCheioFilhos()){
            this.divideNo();
            this.pai.insereNo(no);
            return;
        }
        
        int i = 0;        
        while (i < this.numFilhos && no.chaves[0] > ((NoB) this.filhos[i]).chaves[0]) i++;
        
        for (int j = this.numFilhos-1; j >= i; j--){
            this.filhos[j+1] = this.filhos[j];
            this.filhos[j] = null;
        }
        
        this.setFilho(no, i);
    }

    @Override
    public void mostraArvore(){
        this.mostraArvore("", "");
    }

    // FONTE: How to print binary tree diagram?
    // AUTOR: VasiliNovikov
    // https://stackoverflow.com/a/8948691
    private void mostraArvore(String prefixo1, String prefixo2){
        String strArray = Arrays.toString(this.chaves).replace("null", "--");
        System.out.println(prefixo1 + strArray);
        
        NoB noFilho;
        for (int i = 0; i < numFilhos; i++){
            noFilho = (NoB) this.filhos[i];

            if (i < numFilhos-1)
                noFilho.mostraArvore(prefixo2 + "   ├── ", prefixo2 + "   │   ");
            else
                noFilho.mostraArvore(prefixo2 + "   └── ", prefixo2 + "       ");
        }
    }   

    @Override public void removeNo(int chave){}   
}
