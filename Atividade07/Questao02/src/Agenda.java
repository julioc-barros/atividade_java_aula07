import java.util.Arrays;

public class Agenda {

    Contato[] contatos = new Contato[100];

    private int totalDeContatos = 0;

    public int tamanho(){
        return this.totalDeContatos;
    }

    private boolean posicaoValida(int posicao){
        return posicao >= 0 && posicao <= this.totalDeContatos;
    }

    private boolean posicaoOcupada(int posicao){
        return posicao < this.contatos.length && posicao >= 0;
    }

    public boolean contem(Contato contato){
        for(int i = 0; i < this.totalDeContatos; i++){
            if (contato.equals(this.contatos[i])){
                return true;
            }
        }
        return false;
    }

    private void garantaEspaco(){
        if (this.totalDeContatos == this.contatos.length){
            Contato[] novaArray = new Contato[this.contatos.length * 2];

            for (int i = 0; i < this.contatos.length; i++){
                novaArray[i] = this.contatos[i];
            }
            this.contatos = novaArray;
        }
    }

    public void adiciona(Contato contato){
        this.garantaEspaco();
        this.contatos[this.totalDeContatos] = contato;
        this.totalDeContatos++;
    }

    public Contato pega(int posicao){
        if(!this.posicaoOcupada(posicao)){
            throw new IllegalArgumentException("Posição inválida pesquisada");
        }
        return this.contatos[posicao];
    }

    public void remove(int posicao){
        if(!this.posicaoOcupada(posicao)){
            throw new IllegalArgumentException("Posição inválida");
        }
        for (int i = 0; i < this.totalDeContatos; i++) {
            this.contatos[i] = this.contatos[i + 1];
        }
        this.totalDeContatos--;
    }

    public void adiciona(int posicao, Contato contato){
        this.garantaEspaco();
        if(!this.posicaoValida(posicao)){
            throw new IllegalArgumentException("Posicao invalida");
        }
        for(int i = this.totalDeContatos - 1; i >= posicao; i--){
            this.contatos[i + 1] = this.contatos[i];
        }
        this.contatos[posicao] = contato;
        this.totalDeContatos++;
    }

    public String toString() {
        return Arrays.toString(contatos);
    }


}
