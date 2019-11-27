package EstruturaDados.Arvore.B;

import EstruturaDados.Arvore.No;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;

public class NoB extends No {
    public ArvoreB arvore;
    public Integer[] chaves;
    public ArrayList<NoB> filhos;
    public int grau;
    public int numChaves;
    public boolean isFolha;
    
    public NoB(int grau, boolean isFolha){
        this.grau = grau;
        this.isFolha = isFolha;
        this.chaves = new Integer[2*grau - 1];
        this.filhos = new ArrayList<>();
        this.numChaves = 0;
        this.arvore = ArvoreB.getInstance(3);
    }
        
    @Override
    public No buscaNo(int chave) {
        int i = 0;
        for (; i < this.numChaves && chave > this.chaves[i]; i++){}
        
        if (this.chaves[i] == chave) return this;
        if (this.isFolha) return null;
        return this.filhos.get(i).buscaNo(chave);
    }

    @Override
    public void insereNo(No no){
        
    }
    
    @Override
    public void insereChave(int chave){
        int i = this.numChaves - 1;
        
        if (this.isFolha){
            while (i >= 0 && this.chaves[i] > chave){
                this.chaves[i+1] = this.chaves[i];
                i--;
            }
            
            this.chaves[i+1] = chave;
            this.numChaves++;
            
        } else {
            while (i >= 0 && this.chaves[i] > chave)
                i--;
            
            if (this.filhos.get(i+1).numChaves == 2*this.grau - 1){
                this.divideFilho(i+1, this.filhos.get(i+1));
                 
                if (this.chaves[i+1] < chave) i++;
            }
            
            this.filhos.get(i+1).insereChave(chave);
        }
    }
    
    public void divideFilho(int indice, NoB no){
        NoB novoNo = new NoB(no.grau, no.isFolha);
        novoNo.numChaves = this.grau - 1;
        
        
        
        for (int i = 0; i < this.grau - 1; i++){
            novoNo.chaves[i] = no.chaves[i + this.grau];
            no.chaves[i + this.grau] = null;
        }
            
        if (!no.isFolha){
            NoB noFilho;
            
            for (int i = 0; i < this.grau; i++){
                noFilho = no.filhos.get(i + this.grau);
                novoNo.filhos.set(i, noFilho);
            }
        }
        
        no.numChaves = this.grau - 1;
        
        for (int i = this.numChaves; i >= indice + 1; i--)
            this.filhos.set(i+1, this.filhos.get(i));
        
        this.filhos.add(novoNo);
       
        
        for (int i = this.numChaves - 1; i >= indice; i--)
            this.chaves[i+1] = this.chaves[i];
        
        this.chaves[indice] = no.chaves[this.grau - 1];
        no.chaves[this.grau - 1] = null;
        this.numChaves++;
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
        
        for (Iterator<NoB> it = this.filhos.iterator(); it.hasNext();){
            NoB no = it.next();
            if (it.hasNext())
                no.mostraArvore(prefixo2 + "   ├── ", prefixo2 + "   │   ");
            else
                no.mostraArvore(prefixo2 + "   └── ", prefixo2 + "       ");
        }
    }

    @Override
    public void setFilho(No no, int pos){}

    @Override
    public void removeNo(int chave){}   
}
