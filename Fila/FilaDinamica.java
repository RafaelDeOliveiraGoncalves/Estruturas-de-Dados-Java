import java.util.ArrayDeque; // Melhor que ArrayList pois não precisa realocar todos os elementos ao desenfilar da FilaDinamica

public class FilaDinamica <T>{
    private ArrayDeque<T> array;

    public FilaDinamica(){
        this.inicializa();
    }

    public void inicializa(){
        this.array = new ArrayDeque<>();
    }
    
    public void esvazia(){
        this.array.clear(); //Deixa todos os elementos como null para o GC. Mas ainda com a mesma memória alocada
    }

    public boolean vazia(){
        return this.array.isEmpty();
    }

    public void enfila(T k){
        this.array.addLast(k); //Adiciona no final do array
    }

    public T desenfila() throws FilaVaziaException{
        if(this.vazia()){
            throw new FilaVaziaException();
        }
        return this.array.removeFirst(); // Remove no começo do array em tempo O(1)
    }

    public T frente() throws FilaVaziaException{
        if(this.vazia()){
            throw new FilaVaziaException();
        }
        return this.array.peekFirst(); //Retorna a primeira posição do array 
    }

    @Override
    public String toString(){
        if(this.vazia()) return "Fila Vazia";

        StringBuilder sb = new StringBuilder();
        sb.append("Start -> ");
        int cont = 0;
        for(T elemento : this.array){
            sb.append(elemento);
            if(cont<this.array.size()-1){
                sb.append(" ");
            }
            cont++;
        }
        sb.append(" <- End");
        return sb.toString();
    }

}

