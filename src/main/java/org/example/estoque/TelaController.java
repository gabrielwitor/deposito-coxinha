package org.example.estoque;

import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.ButtonType;
import javafx.scene.control.TextField;
import javafx.scene.layout.Region;
import javafx.scene.text.Text;

public class TelaController {
    Maquina maquina = new Maquina();

    @FXML
    private TextField campoEntrada;

    @FXML
    private TextField campoEstoque;

    @FXML
    private void incrementarQtd(){
        campoEntrada.setText(String.valueOf(Integer.parseInt(campoEntrada.getText())+1));
    }

    @FXML
    private void decrementarQtd(){
        if(Integer.parseInt(campoEntrada.getText()) != 0){
            campoEntrada.setText(String.valueOf(Integer.parseInt(campoEntrada.getText())-1));
        }
    }

    @FXML
    private void abastecerEstoque(){
        maquina.abastecer(Integer.parseInt(campoEntrada.getText()));
        campoEstoque.setText(String.valueOf(maquina.getEstoque()));
    }

    @FXML
    private void venderEstoque(){
        try{
            maquina.vender(Integer.parseInt(campoEntrada.getText()));
            campoEstoque.setText(String.valueOf(maquina.getEstoque()));
        } catch (Exception vendaException){
            Alert alert = new Alert(Alert.AlertType.ERROR, "Quantidade de coxinhas insuficiente", ButtonType.OK);
            alert.getDialogPane().setMinHeight(Region.USE_PREF_SIZE);
            alert.show();
        }

    }

    @FXML
    private void zerarEstoque(){
        maquina.zerar();
        campoEstoque.setText(String.valueOf(maquina.getEstoque()));
    }
}
