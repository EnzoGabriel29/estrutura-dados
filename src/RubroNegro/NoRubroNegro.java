package RubroNegro;
import No.No;
import Balanceado.NoBalanceado;

public class NoRubroNegro extends NoBalanceado {
    public Cor cor;
    public ArvoreRubroNegra arvore;
    
    public static NoRubroNegro retornaNo(int chave){
        return new NoRubroNegro(chave);
    }
    
    public NoRubroNegro(int chave) {
        super(chave);
        this.cor = Cor.VERMELHO;
        this.arvore = ArvoreRubroNegra.getInstance();
    }
    
    @Override
    public void insereNo(No no){
       super.insereNo(no);
    }    
    
    public void recoloriza(NoRubroNegro no){
        System.out.println("Recolorizando árvore:");
        
        NoRubroNegro noPai, noAvo, noTio;

        while (no != this.arvore.raiz && no.cor != Cor.PRETO &&
                ((NoRubroNegro) no.pai).cor == Cor.VERMELHO){
            noPai = (NoRubroNegro) no.pai;
            noAvo = (NoRubroNegro) no.pai.pai;

            if (noPai == noAvo.filhos[0]){
                noTio = (NoRubroNegro) noAvo.filhos[1];

                if (noTio != null && noTio.cor == Cor.VERMELHO){
                    noAvo.cor = Cor.VERMELHO;
                    noPai.cor = Cor.PRETO;
                    noTio.cor = Cor.PRETO;
                    no = noAvo;

                } else {
                    if (no == noPai.filhos[1]){
                        noPai.rotacionaEsquerda();
                        no = noPai;
                        noPai = (NoRubroNegro) no.pai;
                    }
                    
                    noAvo.rotacionaDireita();
                    Cor aux = noPai.cor;
                    noPai.cor = noAvo.cor;
                    noAvo.cor = aux;
                    this.arvore.setRaiz(noPai);
                }

            } else {
                noTio = (NoRubroNegro) noAvo.filhos[0];

                if (noTio != null && noTio.cor == Cor.VERMELHO){
                    noAvo.cor = Cor.VERMELHO;
                    noPai.cor = Cor.PRETO;
                    noTio.cor = Cor.PRETO;
                    no = noAvo;

                } else {
                    if (no == noPai.filhos[0]){
                        noPai.rotacionaDireita();
                        no = noPai;
                        noPai = (NoRubroNegro) no.pai;
                    }

                    noAvo.rotacionaEsquerda();
                    Cor aux = noPai.cor;
                    noPai.cor = noAvo.cor;
                    noAvo.cor = aux;
                    this.arvore.setRaiz(noPai);
                }
            }
        }

        this.arvore.raiz.cor = Cor.PRETO;
    }
    
    public NoRubroNegro getMaiorNo(){
        NoRubroNegro atual = this;

        while (atual.filhos[1] != null)
            atual = (NoRubroNegro) atual.filhos[1];

        return atual;
    }
    
    public NoRubroNegro getSubstituto(){
        boolean isFilhoEsq = this.filhos[0] != null;
        boolean isFilhoDir = this.filhos[1] != null;

        if (isFilhoEsq && isFilhoDir)
            return ((NoRubroNegro) this.filhos[0]).getMaiorNo();

        if (!isFilhoEsq && !isFilhoDir)
            return null;

        if (isFilhoEsq)
            return (NoRubroNegro) this.filhos[0];
        
        return (NoRubroNegro) this.filhos[1];
    }
    
    public boolean isFilhoEsquerdo(){
        return this == this.pai.filhos[0];
    }
    
    public NoRubroNegro getIrmao(){
        if (this.pai == null) return null;

        int i = this.isFilhoEsquerdo() ? 1 : 0;
        return (NoRubroNegro) this.pai.filhos[i];        
    }
    
    public void removeNo(NoRubroNegro no){
        NoRubroNegro noSub = no.getSubstituto();

        boolean isAmbosPretos = ((noSub == null ||
            noSub.cor == Cor.PRETO) && no.cor == Cor.PRETO);

        NoRubroNegro noPai = (NoRubroNegro) no.pai;

        if (noSub == null){
            if (no == this.arvore.raiz)
                this.arvore.raiz = null;

            else {
                if (isAmbosPretos)
                    this.recoloriza(no);

                else if (no.getIrmao() != null)
                    no.getIrmao().cor = Cor.VERMELHO;

                int i = no.isFilhoEsquerdo() ? 0 : 1;
                noPai.filhos[i] = null;
            }

        } else if (no.filhos[0] == null || no.filhos[1] == null){
            if (no == this.arvore.raiz)
                this.arvore.raiz = noSub;

            else {
                int i = no.isFilhoEsquerdo() ? 0 : 1;
                noPai.filhos[i] = noSub;

                noSub.pai = noPai;

                if (isAmbosPretos)
                    this.recoloriza(noSub);

                else noSub.cor = Cor.PRETO;
            }

        } else {            
            int aux = noSub.chave;
            noSub.chave = no.chave;
            no.chave = aux;
            
            this.removeNo(noSub);
        }
    }
    
    @Override
    public void removeNo(int chave){
        NoRubroNegro no = (NoRubroNegro) this.buscaNo(chave);
        this.removeNo(no);
    }

    @Override
    public String toString(){
        String strCor = this.cor == Cor.PRETO ? "P" : "V";
        return this.chave + " (" + strCor + ")";
    }
}
