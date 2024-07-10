package org.example.estoque;

class vendaException extends Exception{
    public vendaException(){

    }
}

public class Maquina {
    private Integer estoque;

    Maquina(){
        estoque = 0;
    }

    public Integer getEstoque() {
        return estoque;
    }

    public void setEstoque(Integer estoque) {
        this.estoque = estoque;
    }

    public void abastecer(Integer quantidade){
        if(quantidade >= 0){
            this.estoque += quantidade;
        }
    }

    public void vender(){
        if(this.estoque > 0){
            this.estoque--;
        }
    }

    public void vender(Integer quantidade) throws vendaException {
        if((this.estoque - quantidade) >= 0 && quantidade >= 0){
            this.estoque -= quantidade;
        } else {
            throw new vendaException();
        }
    }

    public void zerar(){
        this.estoque = 0;
    }
}
