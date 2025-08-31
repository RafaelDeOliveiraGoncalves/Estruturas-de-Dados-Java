import java.util.ArrayList;

public class PilhaDinamica<T> {
    private ArrayList<T> array;
    private int topo;

    public PilhaDinamica(){
        this.inicializa();
    }

    public ArrayList<T> getArray(){
        return this.array;
    }

    public int getTopo(){
        return this.topo;
    }

    private void inicializa(){
        this.array = new ArrayList<>();
        this.topo = -1;
    }

    public void esvazia(){
        this.inicializa();
    }

    public boolean vazia(){
        return (this.topo==-1);
    }

    public void push(T k){
        this.array.add(k);
        this.topo = this.array.size()-1;
    }

    public T pop() throws PilhaVaziaException{
        if(this.vazia()){
            throw new PilhaVaziaException();
        }
        T k = this.array.remove(this.array.size()-1);
        this.topo = this.array.size()-1;
        return k;
    }

    public T top() throws PilhaVaziaException{
        if(this.vazia()){
            throw new PilhaVaziaException();
        }
        T k = this.array.get(this.array.size()-1);
        return k;
    }

    @Override
    public String toString(){
        StringBuilder sb = new StringBuilder();
        sb.append("Topo\n");
        for(int i=this.topo;i>=0;i--){
            sb.append(this.array.get(i));
            if(i>0){
                sb.append('\n');
            }
        }
        return sb.toString();
    }

}
