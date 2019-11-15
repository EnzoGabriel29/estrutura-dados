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

    @Override
    public String toString(){
        String strCor = this.cor == Cor.PRETO ? "P" : "V";
        return this.chave + " (" + strCor + ")";
    }
}
