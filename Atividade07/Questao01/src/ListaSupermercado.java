import java.util.Arrays;

public class ListaSupermercado {

    //delacarando total de itens
    private Supermercado[] itens = new Supermercado[100];

    private int totaldeitens = 0;

    public int tamanho(){
        return this.totaldeitens;
    }

    private boolean posicaoValida(int posicao){
        return posicao >= 0 && posicao <= this.totaldeitens;
    }

    private boolean posicaoOcupada(int posicao){
        return posicao < this.itens.length && posicao >= 0;
    }

    public boolean contem(Supermercado item){
        for(int i = 0; i < this.totaldeitens; i++){
            if(item.equals(this.itens[i])){
                return true;
            }
        }
        return false;
    }

    private void garantaEspaco(){
        if (this.totaldeitens == this.itens.length){
            Supermercado[] novaArray = new Supermercado[this.itens.length * 2];
            for(int i = 0; i < this.itens.length; i++){
                novaArray[i] = this.itens[i];
            }
            this.itens = novaArray;
        }
    }

    public void adiciona(Supermercado item){
        this.garantaEspaco();
        this.itens[this.totaldeitens] = item;
        this.totaldeitens++;
    }

    public Supermercado pega(int posicao){
        if(!this.posicaoOcupada(posicao)){
            throw new IllegalArgumentException("Posição inválida pesquisada");
        }
        return this.itens[posicao];
    }

    public void remove(int posicao){
        if(!this.posicaoOcupada(posicao)){
            throw new IllegalArgumentException("Posicao Inválida");
        }
        for(int i = posicao; i < this.totaldeitens - 1; i++){
            this.itens[i] = this.itens[i + 1];
        }
        this.totaldeitens--;
    }

    public void adiciona(int posicao, Supermercado item){
        this.garantaEspaco();
        if(!this.posicaoValida(posicao)){
            throw new IllegalArgumentException("Posição inválida");
        }
        for (int i = this.totaldeitens -1; i >= posicao; i--){
            this.itens[i + 1] = this.itens[i];
        }
        this.itens[posicao] = item;
        this.totaldeitens++;
    }

    public String toString(){
        return Arrays.toString(itens);
    }



}
