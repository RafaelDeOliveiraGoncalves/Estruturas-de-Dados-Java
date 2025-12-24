public class ArvoreAVL<T extends Comparable<T>> {
    private NoAVL<T> raiz;

    public ArvoreAVL(){
        this.raiz = null;
    }
    public ArvoreAVL(NoAVL<T> raiz){
        this.raiz = raiz;
    }

    public NoAVL<T> getRaiz(){
        return this.raiz;
    }

    public void setRaiz(NoAVL<T> raiz){
        this.raiz = raiz;
    }
    
    private int maior(int a, int b){
        return (a>b)?a:b;
    }

    private int alturaNo(NoAVL<T> no){
        return (no==null) ? -1 : no.getAltura();
    }

    private int fatorBalanceamento(NoAVL<T> no){
        if(no!=null){
            return (alturaNo(no.getLe()) - (alturaNo(no.getLd())));
        }
        return 0;
    }

    private NoAVL<T> rotacaoEsquerda(NoAVL<T> r){
        NoAVL<T> y,f;
        y = r.getLd();
        f = y.getLe();

        y.setLe(r);
        r.setLd(f);

        r.setAltura(maior(alturaNo(r.getLe()),alturaNo(r.getLd()))+1);
        y.setAltura(maior(alturaNo(y.getLe()),alturaNo(y.getLd()))+1);

        return y;
    }

    private NoAVL<T> rotacaoDireita(NoAVL<T> r){
        NoAVL<T> y,f;
        y = r.getLe();
        f = y.getLd();

        y.setLd(r);
        r.setLe(f);

        r.setAltura(maior(alturaNo(r.getLe()),alturaNo(r.getLd()))+1);
        y.setAltura(maior(alturaNo(y.getLe()),alturaNo(y.getLd()))+1);

        return y;
    }

    private NoAVL<T> rotacaoDuplaEsquerda(NoAVL<T> r){
        r.setLd(rotacaoDireita(r.getLd()));
        return rotacaoEsquerda(r);
    }

    private NoAVL<T> rotacaoDuplaDireita(NoAVL<T> r){
        r.setLe(rotacaoEsquerda(r.getLe()));
        return rotacaoDireita(r);
    }

    private NoAVL<T> balancear(NoAVL<T> raiz){
        int fb = fatorBalanceamento(raiz);

        if(fb<-1 && fatorBalanceamento(raiz.getLd())<=0){
            raiz = rotacaoEsquerda(raiz);
        }
        else if(fb>1 && fatorBalanceamento(raiz.getLe())>=0){
            raiz = rotacaoDireita(raiz);
        }
        else if(fb>1 && fatorBalanceamento(raiz.getLe())<0){
            raiz = rotacaoDuplaDireita(raiz);
        }
        else if(fb<-1 && fatorBalanceamento(raiz.getLd())>0){
            raiz = rotacaoDuplaEsquerda(raiz);
        }
        return raiz;
    }

    private NoAVL<T> insere(NoAVL<T> raiz, T chave){
        if(raiz == null){
            return new NoAVL<>(chave);
        }
        else{
            if(chave.compareTo(raiz.getChave())<0){
                raiz.setLe(insere(raiz.getLe(),chave));
            }
            else if(chave.compareTo(raiz.getChave())>0){
                raiz.setLd(insere(raiz.getLd(),chave));
            }
        }
        raiz.setAltura(maior(alturaNo(raiz.getLe()),alturaNo(raiz.getLd()))+1);
        raiz = balancear(raiz);
        return raiz;
    }

    public void insere(T chave){
        this.raiz = insere(this.raiz, chave);
    }

    private NoAVL<T> delete(NoAVL<T> raiz, T chave){
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
                NoAVL<T> aux = raiz.getLe();
                while(aux.getLd()!=null){
                    aux = aux.getLd();
                }
                raiz.setChave(aux.getChave());
                raiz.setLe(delete(raiz.getLe(),aux.getChave()));
            }
            else{ // Um filho
                NoAVL<T> aux = (raiz.getLe()!=null) ? raiz.getLe() : raiz.getLd();
                return aux;
            }
        }
        if(raiz!=null){
            raiz.setAltura(maior(alturaNo(raiz.getLe()),alturaNo(raiz.getLd()))+1);
            raiz = balancear(raiz);
        }
        return raiz;
    }

    public void delete(T chave){
        this.raiz = delete(this.raiz,chave);
    }

    public NoAVL<T> busca(T chave){
        NoAVL<T> p = this.raiz;
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

    public int alturaArvore(){
        return this.raiz.getAltura();
    }

    public void preOrdem(NoAVL<T> no){
        if(no!=null){
            System.out.println(no.getChave());
            this.preOrdem(no.getLe());
            this.preOrdem(no.getLd());
        }
    }

    public void inOrdem(NoAVL<T> no){
        if(no!=null){
            this.inOrdem(no.getLe());
            System.out.println(no.getChave());
            this.inOrdem(no.getLd());
        }
    }

    public void posOrdem(NoAVL<T> no){
        if(no!=null){
            this.posOrdem(no.getLe());
            this.posOrdem(no.getLd());
            System.out.println(no.getChave());
        }
    }

    public void nivel() throws FilaVaziaException{
        if (raiz == null) return;
        
        FilaDinamica<NoAVL<T>> fila = new FilaDinamica<>();
        fila.enfila(raiz);
        try{
            while(!fila.vazia()){
                NoAVL<T> p = (NoAVL<T>) fila.desenfila();
                System.out.println(p.getChave());
                if(p.getLe()!=null){
                    fila.enfila(p.getLe());
                }
                if(p.getLd()!=null){
                    fila.enfila(p.getLd());
                }
            }
        }
        catch(FilaVaziaException erro){
            System.out.println("Fila está vazia");
        }
    }

    public String toString(){
        return super.toString();
    }

}
