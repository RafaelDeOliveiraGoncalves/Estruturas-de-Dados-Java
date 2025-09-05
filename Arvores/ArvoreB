public class ArvoreB{
    private int T;
    private No raiz;

    public class No{
        int n;
        int key[] = new int[2*T -1];
        No filhos[] = new No[2*T];
        boolean folha = true;

        public int busca(int k){
            for(int i=0; i<this.n; i++){
                if(this.key[i] == k){
                    return i;
                }
            }
            return -1;
        };
    }

    public ArvoreB(int t){
        this.T = t;
        raiz = new No();
        raiz.n = 0;
        raiz.folha = true;
    }

    private No buscar(No x, int key){
        int i = 0;
        if(x == null){
            return x;
        }
        for(i=0;i<x.n;i++){
            if(key < x.key[i]){
                break;
            }
            if(key == x.key[i]){
                return x;
            }
        }
        if(x.folha){
            return null;
        }
        else{
            return buscar(x.filhos[i], key);
        }
    }

    private void split(No x, int pos, No y){
        No z = new No();
        z.folha = y.folha;
        z.n = T-1;
        for(int j=0; j<T-1; j++){
            z.key[j] = y.key[j + T];
        }
        if(!y.folha){
            for(int j = 0; j<T; j++){
                z.filhos[j] = y.filhos[j+T];
            }
        }
        y.n = T-1;
        for(int j = x.n; j>=pos + 1; j--){
            x.filhos[j+1] = x.filhos[j];
        }
        x.filhos[pos+1] = z;

        for(int j= x.n-1; j>=pos; j--){
            x.key[j+1] = x.key[j];
        }
        x.key[pos] = y.key[T-1];
        x.n = x.n + 1;
    }

    public void inserir(final int key){
        if(contem(key)){
            System.out.println("Elemento já inserido na Árvore");
            return;
        }
        No r = raiz;
        if(r.n == 2*T-1){
            No s = new No();
            raiz = s;
            s.folha = false;
            s.n = 0;
            s.filhos[0] = r;
            split(s,0,r);
            inserirValores(s, key);
        }
        else{
            inserirValores(r,key);
        }
    }

    final private void inserirValores(No x, int k){
        if(x.folha){
            int i = 0;
            for(i = x.n-1; i>=0 && k<x.key[i]; i--){
                x.key[i+1] = x.key[i];
            }
            x.key[i+1] = k;
            x.n = x.n + 1;
        }
        else{
            int i = 0;
            for(i=x.n-1; i>=0 && k<x.key[i]; i--){}
            i++;
            No temp = x.filhos[i];
            if(temp.n == 2*T-1){
                split(x, i, temp);
                if(k > x.key[i]){
                    i++;
                }
            }
            inserirValores(x.filhos[i], k);
        }
    }

    public void mostrar(){
        mostrar(raiz,0);
    }
    
    private void mostrar(No x, int nivel){
        if(x == null) return;

        System.out.print("Nivel " + nivel + ": ");
        for(int i=0; i<x.n; i++){
            System.out.print(x.key[i] + " ");
        }
        System.out.println();

        if(!x.folha){
            for(int i=0; i<x.n+1; i++){
                mostrar(x.filhos[i], nivel+1);
            }
        }
    }
    
    private void remover(No x, int chave){
        int pos = x.busca(chave);
        if(pos!=-1){
            if(x.folha){
                int i =0;
                for(i=0; i<x.n && x.key[i]!=chave; i++){};
                for(; i<x.n; i++){
                    if(i!=2*T-2){
                        x.key[i] = x.key[i+1];
                    }
                }   
                x.n--;
                return;
            }
            if(!x.folha){
                No pred = x.filhos[pos];
                int predKey = 0;
                if(pred.n>=T){
                    for(;;){
                        if(pred.folha){
                            System.out.println(pred.n);
                            predKey = pred.key[pred.n - 1];
                            break;
                        }
                        else{
                            pred = pred.filhos[pred.n];
                        }
                    }
                    remover(pred, predKey);
                    x.key[pos] = predKey;
                    return;
                }
                No proxNo = x.filhos[pos+1];
                if(proxNo.n >= T){
                    int proxKey = proxNo.key[0];
                    if(!proxNo.folha){
                        proxNo = proxNo.filhos[0];
                        for(;;){
                            if(proxNo.folha){
                                proxKey = proxNo.key[proxNo.n-1];
                                break;
                            }
                            else{
                                proxNo = proxNo.filhos[proxNo.n];
                            }
                        }
                    }
                    remover(proxNo, proxKey);
                    x.key[pos] = proxKey;
                    return;
                }
                
                int temp = pred.n + 1;
                pred.key[pred.n++] = x.key[pos];
                for(int i=0, j=pred.n; i<proxNo.n; i++){
                    pred.key[j++] = proxNo.key[i];
                    pred.n++;
                }
                for(int i=0; i< proxNo.n + 1; i++){
                    pred.filhos[temp++] = proxNo.filhos[i];
                }
                x.filhos[pos] = pred;
                for(int i=pos; i<x.n; i++){
                    if(i!=2*T-2){
                        x.key[i] = x.key[i+1];
                    }
                }
                for(int i=pos+1; i<x.n+1;i++){
                    if(i!=2*T-1){
                        x.filhos[i] = x.filhos[i+1];
                    }
                }
                x.n--;
                if(x.n == 0){
                    if(x == raiz){
                        raiz = x.filhos[0];
                    }
                    x = x.filhos[0];
                }
                remover(pred, chave);
                return;
            }
        }
        else{
            for(pos=0;pos<x.n;pos++){
                if(x.key[pos]>chave){
                    break;
                }
            }
            No temp = x.filhos[pos];
            if(temp.n>=T){
                remover(temp, chave);
                return ;            
            }
            if(true){
                No nb = null;
                int divisor = -1;
                
                if(pos!=x.n && x.filhos[pos+1].n>=T){
                    divisor = x.key[pos];
                    nb = x.filhos[pos+1];
                    x.key[pos] = nb.key[0];
                    temp.key[temp.n++] = divisor;
                    temp.filhos[temp.n] = nb.filhos[0];
                    for(int i=1; i<nb.n; i++){
                        nb.key[i-1] = nb.key[i];
                    }
                    for(int i=1; i<nb.n; i++){
                        nb.filhos[i-1] = nb.filhos[i];
                    }
                    nb.n--;
                    remover(temp, chave);
                    return;
                }
                else if(pos!=0 && x.filhos[pos-1].n>=T){
                    divisor = x.key[pos-1];
                    nb = x.filhos[pos-1];
                    x.key[pos-1] = nb.key[nb.n-1];
                    No filho = nb.filhos[nb.n];
                    nb.n--;
                    
                    for(int i=temp.n; i>0; i++){
                        temp.key[i] = temp.key[i-1];
                    }
                    temp.key[0] = divisor;
                    for(int i=temp.n+1; i>0; i--){
                        temp.filhos[i] = temp.filhos[i-1];
                    }
                    temp.filhos[0] = filho;
                    temp.n++;
                    remover(temp, chave);
                    return;
                }
                else{
                    No lt = null;
                    No rt = null;
                    boolean last = false;
                    if(pos!=x.n){
                        divisor = x.key[pos-1];
                        rt = x.filhos[pos];
                        lt = x.filhos[pos-1];
                        last = true;
                        pos--;
                    }
                    for(int i=pos; i<x.n-1; i++){
                        x.key[i] = x.key[i+1];
                    }
                    for(int i=pos+1; i<x.n; i++){
                        x.filhos[i] = x.filhos[i+1];
                    }
                    x.n--;
                    lt.key[lt.n++] = divisor;
                    
                    for(int i=0, j=lt.n; i<rt.n+1; i++, j++){
                        if(i<rt.n){
                            lt.key[j] = rt.key[i];
                        }
                        lt.filhos[j] = rt.filhos[i];
                    }
                    lt.n += rt.n;
                    if(x.n==0){
                        if(x==raiz){
                            raiz = x.filhos[0];
                        }
                        x = x.filhos[0];
                    }
                    remover(lt, chave);
                    return;
                }
            }
        }
    }
    
    public void remover(int chave){
        No x = buscar(raiz, chave);
        if(x == null){
            return;
        }
        remover(raiz, chave);
    }

    public boolean contem(int k){
        if(this.buscar(raiz, k)!=null){
            return true;
        }
        else{
            return false;
        }
    }

}

