package app;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class Main extends Application {
    int contador = 0;
    String mensaje = "!";
    public String repetir(int cont){
        
        for (int i=0; i==cont; i++){
            mensaje = mensaje + "!"; 
        }
        return mensaje;
    }

    @Override
    public void start(Stage stage) {
        Label etiqueta = new Label("Java " + System.getProperty("java.version")
                + " · JavaFX " + System.getProperty("javafx.version"));
        Button boton = new Button("Pulsa aquí");
        boton.setOnAction(e -> {
            if (contador >0) {etiqueta.setText("¡Te dije que no me tocaras!" + repetir(contador));}
            else{
                etiqueta.setText("¡No me toques!");
            }
            contador++;             
            
        });

        VBox raiz = new VBox(12, etiqueta, boton);
        raiz.setStyle("-fx-padding: 24; -fx-alignment: center;");

        stage.setTitle("Prueba de entorno DI");
        stage.setScene(new Scene(raiz, 360, 160));
        stage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}