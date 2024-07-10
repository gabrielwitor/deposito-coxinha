module org.example.estoque {
    requires javafx.controls;
    requires javafx.fxml;


    opens org.example.estoque to javafx.fxml;
    exports org.example.estoque;
}