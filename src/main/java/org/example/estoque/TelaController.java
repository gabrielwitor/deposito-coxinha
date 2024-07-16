package org.example.estoque;

import javafx.application.Platform;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.ButtonType;
import javafx.scene.control.TextField;
import javafx.scene.layout.Region;
import javafx.scene.text.Text;

public class TelaController {

    Maquina maquina;

    @FXML
    private void initialize(){
        maquina = new Maquina();
        campoEntrada.setText(String.valueOf(maquina.getEstoque()));
    }

    @FXML
    private TextField campoEntrada;

    @FXML
    private TextField campoEstoque;

    @FXML
    private void incrementarQtd(){
        try{
            campoEntrada.setText(String.valueOf(Integer.parseInt(campoEntrada.getText())+1));
        } catch (Exception NumberFormatException){
            Alert alert = new Alert(Alert.AlertType.WARNING, "Impossível incrementar: dado inválido", ButtonType.OK);
            alert.getDialogPane().setMinHeight(Region.USE_PREF_SIZE);
            alert.setTitle("Impossível incrementar");
            alert.setHeaderText("");
            alert.show();
        }
    }

    @FXML
    private void decrementarQtd(){
        try{
            if(Integer.parseInt(campoEntrada.getText()) != 0){
                campoEntrada.setText(String.valueOf(Integer.parseInt(campoEntrada.getText())-1));
            }
        } catch (Exception NumberFormatException){
            Alert alert = new Alert(Alert.AlertType.WARNING, "Impossível decrementar: dado inválido", ButtonType.OK);
            alert.getDialogPane().setMinHeight(Region.USE_PREF_SIZE);
            alert.setTitle("Impossível decrementar");
            alert.setHeaderText("");
            alert.show();
        }
    }

    @FXML
    private void abastecerEstoque(){
        try{
            maquina.abastecer(Integer.parseInt(campoEntrada.getText()));
            campoEstoque.setText(String.valueOf(maquina.getEstoque()));
        } catch (Exception NumberFormatException){
            Alert alert = new Alert(Alert.AlertType.WARNING, "Quantidade inserida inválida", ButtonType.OK);
            alert.getDialogPane().setMinHeight(Region.USE_PREF_SIZE);
            alert.setTitle("Quantidade inválida");
            alert.setHeaderText("");
            alert.show();
        }
    }

    @FXML
    private void venderEstoque(){
        try{
            maquina.vender(Integer.parseInt(campoEntrada.getText()));
            campoEstoque.setText(String.valueOf(maquina.getEstoque()));
        } catch (Exception exc){
            Alert alert;
            if(exc instanceof vendaException){
                alert = new Alert(Alert.AlertType.ERROR, "Quantidade de coxinhas insuficiente", ButtonType.OK);
                alert.getDialogPane().setMinHeight(Region.USE_PREF_SIZE);
                alert.setTitle("Coxinhas insuficientes");
            } else {
                alert = new Alert(Alert.AlertType.WARNING, "Quantidade inserida inválida", ButtonType.OK);
                alert.getDialogPane().setMinHeight(Region.USE_PREF_SIZE);
                alert.setTitle("Quantidade inválida");
            }
            alert.setHeaderText("");
            alert.show();
        }
    }

    @FXML
    private void zerarEstoque(){
        maquina.zerar();
        campoEstoque.setText(String.valueOf(maquina.getEstoque()));
    }

    @FXML
    private void sair(){
        Platform.exit();
        System.exit(0);
    }
}
