package app;


import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class App extends Application{


    private static final String CURSO = "Desarrollo de Aplicaciones Multiplataforma";
    private static final String EDAD = "22";
    private static final String NOMBRE = "Juan";

    @Override
    public void start(Stage stage) {
        Label titulo = new Label("Información personal");
        Label nombre = new Label(NOMBRE);
        Label edad = new Label(EDAD);
        Label cuerso = new Label(CURSO);
        Button boton = new Button("Salir");
        
        VBox raiz = new VBox(titulo, nombre, edad, cuerso, boton);

        Scene scene = new Scene(raiz, 500, 300);

        stage.setTitle("Mi primera Aplicacion");
        stage.setScene(scene);
        stage.show();
    }

    public static void main(String[] args){
        launch(args);
    }

    
}
