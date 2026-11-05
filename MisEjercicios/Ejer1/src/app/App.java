package app;


import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class App extends Application{


    private static final String CURSO = "Desarrollo de Aplicaciones Multiplataforma";
    private static final String EDAD = "23";
    private static final String NOMBRE = "Kevin";

    @Override
    public void start(Stage stage) {
        Label titulo = new Label("Información personal");

        Label lNombre = new Label("NOMBRE");
        TextField tfNombre = new TextField();

        Label ledad = new Label("EDAD");
        TextField tfedad = new TextField();

        Label lcurso = new Label("CURSO");
        TextField tfcurso = new TextField();

        Button boton = new Button("Salir");
        
        
        HBox nombre = new HBox(3, lNombre, tfNombre);
        HBox edad = new HBox(3, ledad, tfedad);
        HBox curso = new HBox(3, lcurso, tfcurso);

 
        VBox raiz = new VBox(5, titulo, nombre, edad, curso, boton);

        Scene scene = new Scene(raiz, 500, 300);


        //CSS
        scene.getStylesheets().add(getClass().getResource("Estilos.css").toExternalForm());

        boton.setId("btn-entrar");
        titulo.setId("titulo");
        edad.getStyleClass().add("campos");



        stage.setTitle("Mi primera Aplicacion");
        stage.setScene(scene);
        stage.show();
    }

    public static void main(String[] args){
        launch(args);
    }

    
}
