public class Pilha {
    private Object[] vetor;
    private int cap, topo;

    //Construtor
    public Pilha(int cap){
        this.inicializa(cap);
    }

    //Encapsulamento
    public Object[] getVetor(){
        return vetor;
    }

    public void setVetor(Object[] vetor){
        this.vetor = vetor;
    }

    public int getCap(){
        return this.cap;
    }

    public void setCap(int capacidade){
        this.cap = capacidade;
    }

    public int getTam() {
        return topo;
    }

    public void setTam(int tam) {
        this.topo = tam;
    }


    public void inicializa(int cap){
        this.cap = cap;
        this.topo = 0;
        this.vetor = new Object[cap];
    }

    public void esvazia(){
        this.topo = 0;
    }

    private boolean vazia(){
        return this.topo == 0;
    }

    private boolean cheia(){
        return this.cap == this.topo;
    }

    public void push(int k) throws PilhaCheiaException{
        if(this.cheia()){
            throw new PilhaCheiaException();
        }
        this.vetor[this.topo]=k;
        this.topo++;
    }

    public Object pop() throws PilhaVaziaException{
        if(this.vazia()){
            throw new PilhaVaziaException();
        }
        this.topo--;
        return this.vetor[this.topo];
    }

    public Object topo() throws PilhaVaziaException{
        if(this.vazia()){
            throw new PilhaVaziaException();
        }
        return this.vetor[this.topo-1];
    }
     
    @Override
    public String toString(){
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