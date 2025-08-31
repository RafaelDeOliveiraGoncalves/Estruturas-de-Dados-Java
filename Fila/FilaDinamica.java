import java.util.ArrayList;

public class FilaDinamica<T> {
    private ArrayList<T> array;

    public FilaDinamica(){
        this.inicializa();
    }

    public void inicializa(){
        this.array = new ArrayList<>();
    }
    
    public void esvazia(){
        this.array.clear(); //Deixa todos os elementos como null para o GC. Mas ainda com a mesma memória alocada
    }

    public boolean vazia(){
        return this.array.isEmpty();
    }

    public void enfila(T k){
        this.array.add(k); //Adiciona sempre no final do array
    }

    public T desenfila() throws FilaVaziaException{
        if(this.vazia()){
            throw new FilaVaziaException();
        }
        return this.array.remove(0); // Remove sempre no começo do array
    }

    public T frente() throws FilaVaziaException{
        if(this.vazia()){
            throw new FilaVaziaException();
        }
        return this.array.get(0); //Retorna a primeira posição do array
    }

    @Override
    public String toString(){
        StringBuilder sb = new StringBuilder();
        sb.append("Start -> ");
        for(int i=0;i<this.array.size();i++){
            sb.append(this.array.get(i));
            if(i<this.array.size()-1){
                sb.append(" ");
            }
        }
        sb.append(" <- End");
        return sb.toString();
    }

}

