package org.example.estoque;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.stage.Stage;

import java.io.IOException;

public class App extends Application {
    @Override
    public void start(Stage stage) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(App.class.getResource("tela.fxml"));
        Scene scene = new Scene(fxmlLoader.load(), 620, 440);

        Image image = new Image("file:/home/witor/Code/IdeaProjects/deposito-coxinha/src/main/resources/org/example/estoque/coxinha.png");
        stage.getIcons().add(image);

        stage.setTitle("Estoque de coxinha");
        stage.setScene(scene);
        stage.show();
    }

    public static void main(String[] args) {
        launch();
    }
}