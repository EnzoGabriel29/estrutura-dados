package AVL;

public class ArvoreAVL {
    private static ArvoreAVL arvore;
    private ArvoreAVL(){}
    public static ArvoreAVL getInstance(){
        if (arvore == null)
            arvore = new ArvoreAVL();
        
        return arvore;
    }
    
    public NoAVL raiz;
  
    public void insereNo(int chave){
        System.out.println("Inserindo a chave " + chave + ":");
        
        if (this.raiz == null)
            this.raiz = new NoAVL(chave);

        else {
            this.raiz.insereNo(chave);
            this.atualizaRaiz();
        }
        
        this.mostraArvore();
    }
    
    public void setRaiz(NoAVL no){
        this.raiz = no;
    }
    
    public void removeNo(int chave){
        System.out.println("Removendo a chave " + chave + ":");
        this.raiz.removeNo(chave);
        this.atualizaRaiz();
        this.mostraArvore();
    }
    
    public void atualizaRaiz(){
        while (this.raiz.pai != null)
            this.raiz = this.raiz.pai;
    }
    
    public void mostraArvore(){
        this.raiz.mostraArvore();
    }

    public static void main(String[] args) { 
        ArvoreAVL a = ArvoreAVL.getInstance();
  
        a.insereNo(9);
        a.insereNo(5); 
        a.insereNo(10);
        a.insereNo(0); 
        a.insereNo(6); 
        a.insereNo(11); 
        a.insereNo(-1); 
        a.insereNo(1); 
        a.insereNo(2);
        
        a.removeNo(10);
        a.removeNo(2);
        a.removeNo(0);
        a.removeNo(9);
        a.removeNo(5);
    } 
} 

/*
Inserindo a chave 10:
10 (0)

Inserindo a chave 20:
 ,----- 20 (0)
10 (-1)

Inserindo a chave 30:
         ,----- 30 (0)
 ,----- 20 (-1)
10 (-2)

Rotacionando o nó 10 à esquerda:
 ,----- 30 (0)
20 (0)
 `----- 10 (0)

Inserindo a chave 40:
         ,----- 40 (0)
 ,----- 30 (-1)
20 (-1)
 `----- 10 (0)

Inserindo a chave 50:
                 ,----- 50 (0)
         ,----- 40 (-1)
 ,----- 30 (-2)
20 (-2)
 `----- 10 (0)

Rotacionando o nó 30 à esquerda:
         ,----- 50 (0)
 ,----- 40 (0)
 |       `----- 30 (0)
20 (-1)
 `----- 10 (0)

Inserindo a chave 25:
         ,----- 50 (0)
 ,----- 40 (1)
 |       `----- 30 (1)
 |               `----- 25 (0)
20 (-2)
 `----- 10 (0)

Rotacionando o nó 40 à direita:
                 ,----- 50 (0)
         ,----- 40 (-1)
 ,----- 30 (-1)
 |       `----- 25 (0)
20 (-2)
 `----- 10 (0)

Rotacionando o nó 20 à esquerda:
         ,----- 50 (0)
 ,----- 40 (-1)
30 (0)
 |       ,----- 25 (0)
 `----- 20 (0)
         `----- 10 (0)
*/

/*
CASO DE TESTE:
    Inserindo 9, 5, 10, 0, 6, 11, -1, 1 e 2.
    Removendo 10, 2, 0 e 9.

SAÍDA:
    Inserindo a chave 9:
    9 (0)

    Inserindo a chave 5:
    9 (1)
     `----- 5 (0)

    Inserindo a chave 10:
     ,----- 10 (0)
    9 (0)
     `----- 5 (0)

    Inserindo a chave 0:
     ,----- 10 (0)
    9 (1)
     `----- 5 (1)
             `----- 0 (0)

    Inserindo a chave 6:
     ,----- 10 (0)
    9 (1)
     |       ,----- 6 (0)
     `----- 5 (0)
             `----- 0 (0)

    Inserindo a chave 11:
             ,----- 11 (0)
     ,----- 10 (-1)
    9 (0)
     |       ,----- 6 (0)
     `----- 5 (0)
             `----- 0 (0)

    Inserindo a chave -1:
             ,----- 11 (0)
     ,----- 10 (-1)
    9 (1)
     |       ,----- 6 (0)
     `----- 5 (1)
             `----- 0 (1)
                     `----- -1 (0)

    Inserindo a chave 1:
             ,----- 11 (0)
     ,----- 10 (-1)
    9 (1)
     |       ,----- 6 (0)
     `----- 5 (1)
             |       ,----- 1 (0)
             `----- 0 (0)
                     `----- -1 (0)

    Inserindo a chave 2:
             ,----- 11 (0)
     ,----- 10 (-1)
    9 (2)
     |       ,----- 6 (0)
     `----- 5 (2)
             |               ,----- 2 (0)
             |       ,----- 1 (-1)
             `----- 0 (-1)
                     `----- -1 (0)

    Rotacionando o nó 0 à esquerda:
             ,----- 11 (0)
     ,----- 10 (-1)
    9 (2)
     |       ,----- 6 (0)
     `----- 5 (2)
             |       ,----- 2 (0)
             `----- 1 (1)
                     `----- 0 (1)
                             `----- -1 (0)

    Rotacionando o nó 5 à direita:
             ,----- 11 (0)
     ,----- 10 (-1)
    9 (1)
     |               ,----- 6 (0)
     |       ,----- 5 (0)
     |       |       `----- 2 (0)
     `----- 1 (0)
             `----- 0 (1)
                     `----- -1 (0)

    Removendo a chave 10:
     ,----- 11 (0)
    9 (2)
     |               ,----- 6 (0)
     |       ,----- 5 (0)
     |       |       `----- 2 (0)
     `----- 1 (0)
             `----- 0 (1)
                     `----- -1 (0)

    Rotacionando o nó 9 à direita:
             ,----- 11 (0)
     ,----- 9 (1)
     |       |       ,----- 6 (0)
     |       `----- 5 (0)
     |               `----- 2 (0)
    1 (-1)
     `----- 0 (1)
             `----- -1 (0)

    Removendo a chave 2:
             ,----- 11 (0)
     ,----- 9 (1)
     |       |       ,----- 6 (0)
     |       `----- 5 (-1)
    1 (-1)
     `----- 0 (1)
             `----- -1 (0)

    Removendo a chave 0:
             ,----- 11 (0)
     ,----- 9 (1)
     |       |       ,----- 6 (0)
     |       `----- 5 (-1)
    1 (-2)
     `----- -1 (0)

    Rotacionando o nó 9 à direita:
                     ,----- 11 (0)
             ,----- 9 (0)
             |       `----- 6 (0)
     ,----- 5 (-2)
    1 (-2)
     `----- -1 (0)

    Rotacionando o nó 1 à esquerda:
             ,----- 11 (0)
     ,----- 9 (0)
     |       `----- 6 (0)
    5 (0)
     `----- 1 (1)
             `----- -1 (0)

    Removendo a chave 9:
     ,----- 11 (1)
     |       `----- 6 (0)
    5 (1)
     `----- 1 (1)
             `----- -1 (0)
*/