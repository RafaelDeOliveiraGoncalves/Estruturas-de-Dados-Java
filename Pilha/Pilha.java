public class Pilha<T> {
    private T[] vetor;
    private int cap, topo;

    //Construtor
    public Pilha(int cap){
        this.inicializa(cap);
    }

    public Pilha(int cap, T[] vetor){
        this.cap = cap;
        this.vetor = vetor;
        this.topo = vetor.length;
    }

    //Encapsulamento

    public int getCap(){
        return this.cap;
    }

    public int getTam() {
        return topo;
    }

    @SuppressWarnings("unchecked")
    private void inicializa(int cap){
        this.cap = cap;
        this.topo = 0;
        this.vetor = (T[]) new Object[cap];
    }

    public void esvazia(){
        java.util.Arrays.fill(vetor,0,topo,null);
        this.topo = 0;
    }

    public boolean vazia(){
        return this.topo == 0;
    }

    public boolean cheia(){
        return this.cap == this.topo;
    }

    public void push(T k) throws PilhaCheiaException{
        if(this.cheia()){
            throw new PilhaCheiaException();
        }
        this.vetor[this.topo]=k;
        this.topo++;
    }

    public T pop() throws PilhaVaziaException{
        if(this.vazia()){
            throw new PilhaVaziaException();
        }
        this.topo--;
        T k = this.vetor[this.topo];
        this.vetor[this.topo] = null;
        return k;
    }

    public T topo() throws PilhaVaziaException{
        if(this.vazia()){
            throw new PilhaVaziaException();
        }
        return this.vetor[this.topo-1];
    }
     
    @Override
    public String toString(){
        if(this.vazia()) return "Pilha Vazia";

        StringBuilder sb = new StringBuilder();
        sb.append("Topo\n");
        for(int i=this.topo-1;i>=0;i--){
            sb.append(this.vetor[i]);
            if(i>0){
                sb.append('\n');
            }
        }
        return sb.toString();
    }
    
}