public class Fila<T>{
    private T[] vetor;
    private int f,r,cap;

    public Fila(int cap){
        this.inicializa(cap);
    }

    @SuppressWarnings("unchecked")
    private void inicializa(int cap){
        this.f = -1;
        this.r = -1;
        this.vetor = (T[]) new Object[cap];
        this.cap = cap;
    }

    public void esvazia(){
        this.f = -1;
        this.r = -1;
    }

    public boolean vazia(){
        return (this.f == -1 && this.r==-1);
    }

    public boolean cheia(){
        return (((this.r+1)%this.cap)==this.f);
    }

    public void enfila(T k) throws FilaCheiaException{
        if(this.cheia()){
            throw new FilaCheiaException();
        }
        else if(this.vazia()){
            this.f = 0;
            this.r = 0;
        }
        else{
            this.r = ((this.r+1)%this.cap);
        }
        this.vetor[this.r] = k;
    }

    public T frente() throws FilaVaziaException{
        if(this.vazia()){
            throw new FilaVaziaException();
        }
        return this.vetor[this.f];
    }

    public T desenfilar() throws FilaVaziaException{
        if(this.vazia()){
            throw new FilaVaziaException();
        }
        T k = this.vetor[this.f];
        this.vetor[this.f] = null;
        if(this.f==this.r){
            this.esvazia();
        }
        else{
            this.f = ((this.f+1)%this.cap);
        }
        return k;
    }

    @Override
    public String toString(){
        if(this.vazia()) return "Fila Vazia";

        StringBuilder sb = new StringBuilder();
        sb.append("Start -> ");
        int i = this.f;
        while(true){
            sb.append(this.vetor[i] + " ");
            if(i == this.r){
                break;
            }
            i = (i+1)%this.cap;
        }
        sb.append("<- End");
        return sb.toString();
    }

}
