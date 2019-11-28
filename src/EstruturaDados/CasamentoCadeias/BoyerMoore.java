package EstruturaDados.CasamentoCadeias;

public class BoyerMoore {
    private final int R;
    private final int[] vetorSalto;

    private char[] vetPadrao;
    private String strPadrao;   

    public BoyerMoore(String padrao){
        this.R = 256;
        this.strPadrao = padrao;

        vetorSalto = new int[R];
        for (int c = 0; c < R; c++)
            this.vetorSalto[c] = -1;
        
        for (int j = 0; j < padrao.length(); j++)
            this.vetorSalto[padrao.charAt(j)] = j;
    }

    public BoyerMoore(char[] pattern, int R) {
        this.R = R;
        this.vetPadrao = new char[pattern.length];
        System.arraycopy(pattern, 0, this.vetPadrao, 0, pattern.length);

        this.vetorSalto = new int[R];
        for (int c = 0; c < R; c++)
            this.vetorSalto[c] = -1;
        
        for (int j = 0; j < pattern.length; j++)
            this.vetorSalto[pattern[j]] = j;
    }

    public int procuraEmTexto(String texto){
        int nPadrao = this.strPadrao.length();
        int nTexto = texto.length();
        int salto;
        
        for (int i = 0; i <= nTexto - nPadrao; i += salto) {
            salto = 0;
            
            for (int j = nPadrao-1; j >= 0; j--) {
                if (this.strPadrao.charAt(j) != texto.charAt(i+j)) {
                    salto = Math.max(1, j - this.vetorSalto[texto.charAt(i+j)]);
                    break;
                }
            }
            
            if (salto == 0) return i;
        }
        return nTexto;                   
    }

    public int procuraEmTexto(char[] texto) {
        int nPadrao = this.vetPadrao.length;
        int nTexto = texto.length;
        int salto;
        
        for (int i = 0; i <= nTexto - nPadrao; i += salto) {
            salto = 0;
            for (int j = nPadrao-1; j >= 0; j--) {
                if (this.vetPadrao[j] != texto[i+j]) {
                    salto = Math.max(1, j - this.vetorSalto[texto[i+j]]);
                    break;
                }
            }
            
            if (salto == 0) return i;  
        }
        return nTexto;                 
    }
}