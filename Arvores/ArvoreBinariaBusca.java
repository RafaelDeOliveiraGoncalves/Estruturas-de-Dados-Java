public class ArvoreBinariaBusca<T extends Comparable<T>>{
    private NoArvore<T> raiz;
    
    //Construtor
    public ArvoreBinariaBusca(){
        this.raiz = null;
    }
    public ArvoreBinariaBusca(NoArvore<T> raiz){
        this.raiz = raiz;
    }

    public NoArvore<T> getRaiz(){
        return this.raiz;
    }

    public void setRaiz(NoArvore<T> raiz){
        this.raiz = raiz;
    }

    private NoArvore<T> insere(NoArvore<T> raiz, T chave){
        if(raiz == null){
            return new NoArvore<>(chave);
        }
        else{
            if(chave.compareTo(raiz.getChave())<0){
                raiz.setLe(insere(raiz.getLe(),chave));
            }
            else if(chave.compareTo(raiz.getChave())>0){
                raiz.setLd(insere(raiz.getLd(),chave));
            }
        }
        return raiz;
    }

    public void insere(T chave){
        this.raiz = insere(this.raiz,chave);
    }

    public NoArvore<T> busca(T chave){
        NoArvore<T> p = this.raiz;
        while(p!=null && p.getChave().compareTo(chave)!=0){
            if(chave.compareTo(p.getChave())<0){
                p = p.getLe();
            }
            else{
                p = p.getLd();
            }
        }
        return p;
    }

    private NoArvore<T> delete(NoArvore<T> raiz, T chave){
        if(raiz==null){
            return null;
        }
        if(chave.compareTo(raiz.getChave())<0){
            raiz.setLe(delete(raiz.getLe(),chave));
        }
        else if(chave.compareTo(raiz.getChave())>0){
            raiz.setLd(delete(raiz.getLd(),chave));
        }
        else{ // Nó encontrado
            if(raiz.getLe()==null && raiz.getLd()==null){ // Sem filhos
                return null;
            }
            else if(raiz.getLe()!=null && raiz.getLd()!=null){ // Dois filhos
                NoArvore<T> aux = raiz.getLe();
                while(aux.getLd()!=null){
                    aux = aux.getLd();
                }
                raiz.setChave(aux.getChave());
                raiz.setLe(delete(raiz.getLe(),aux.getChave()));
            }
            else{ // Um filho
                NoArvore<T> aux = (raiz.getLe()!=null) ? raiz.getLe() : raiz.getLd();
                return aux;
            }
        }
        return raiz;
    }

    public void delete(T chave){
        this.raiz = delete(this.raiz,chave);
    }

    public void preOrdem(NoArvore<T> no){
        if(no!=null){
            System.out.println(no.getChave());
            this.preOrdem(no.getLe());
            this.preOrdem(no.getLd());
        }
    }

    public void inOrdem(NoArvore<T> no){
        if(no!=null){
            this.inOrdem(no.getLe());
            System.out.println(no.getChave());
            this.inOrdem(no.getLd());
        }
    }

    public void posOrdem(NoArvore<T> no){
        if(no!=null){
            this.posOrdem(no.getLe());
            this.posOrdem(no.getLd());
            System.out.println(no.getChave());
        }
    }

    public int altura(NoArvore<T> no){
        int alturaEsq = 0;
        int alturaDir = 0;
        if(no.getLe()!=null){
            alturaEsq = this.altura(no.getLe());
        }
        if(no.getLd()!=null){
            alturaDir = this.altura(no.getLd());
        }
        if(alturaEsq>alturaDir){
            return alturaEsq+1;
        }
        else{
            return alturaDir+1;
        }
    }

    public int qtdNos(NoArvore<T> no){
        if(no==null){
            return 0;
        }
        return 1 + qtdNos(no.getLe()) + qtdNos(no.getLd());
    }

    private String imprimir(NoArvore<T> raiz, int nivel){
        if(raiz==null){
            return "";
        }
        StringBuilder sb = new StringBuilder();
        sb.append(imprimir(raiz.getLd(),nivel+1)); //Imprimir o lado direito da árvore primeiro
        sb.append("\n\n"); // Espaçamento de um nível para outro
        for(int i=0;i<nivel;i++){
            sb.append("\t"); // Espaçamento entre pai e filho
        }
        sb.append(raiz.getChave());
        sb.append(imprimir(raiz.getLe(),nivel+1)); // Imprimir lado esquerdo da árvore

        return sb.toString();

    }

    public String toString(){
        return imprimir(this.raiz,1);
    }

}