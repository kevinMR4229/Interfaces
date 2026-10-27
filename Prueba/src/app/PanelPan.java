package app;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.Menu;
import javafx.scene.control.MenuBar;
import javafx.scene.control.TextField;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class PanelPan extends Application {

    private static final String TITULO = "Panel de Control";

    @Override
    public void start(Stage stage) throws Exception {
        // Creamos una instancia de la clase BorderPane (contenedor con 5 zonas: top,
        // bottom, left, right y center)
        BorderPane bPane = new BorderPane();
        bPane.setStyle("-fx-background-color: #EAF4F8;"
                + "-fx-font-family: 'Arial';"
                + "-fx-font-size: 13;");

        // Parte superior

        Label titulo = new Label(TITULO);
        titulo.setPrefHeight(56);
        titulo.setPadding(new Insets(14, 18, 14, 18));

        Menu menu1 = new Menu("Archivo");
        Menu menu2 = new Menu("Editar");
        Menu menu3 = new Menu("ayuda");

        MenuBar menubar = new MenuBar(menu1, menu2, menu3);

        VBox topBar = new VBox(titulo, menubar);
        topBar.setStyle("-fx-background-color: #EAF2FF;");
        topBar.setPadding(new Insets(14, 18, 14, 18));

        // Asignamos un campo de texto (TextField) en la parte superior del BorderPane
        bPane.setTop(topBar);

        // Parte izquierda
        Button botInicio = new Button("Inicio");
        Button botPerfil = new Button("Perfil");
        Button botConfiguracion = new Button("Configuración");
        Button botSalir = new Button("Salir");

        // Creamos el contenedor vertical
        VBox vboxIzquierda = new VBox();

        // Añadimos los botones
        vboxIzquierda.getChildren().addAll(
                botInicio,
                botPerfil,
                botConfiguracion,
                botSalir);

        // Asignamos el VBox a la izquierda del BorderPane
        bPane.setLeft(vboxIzquierda);

        // Asignamos un campo de texto en la parte inferior
        bPane.setBottom(new TextField("Bottom"));

        // Asignamos un campo de texto en el lado derecho
        bPane.setRight(new TextField("Right"));
        // Asignamos un campo de texto en el centro del BorderPane
        bPane.setCenter(new TextField("Center"));
        // Creamos una escena que contiene el BorderPane y le damos un tamaño de 400x300
        // píxeles
        Scene scene = new Scene(bPane, 400, 300);
        // Establecemos el título de la ventana (Stage)
        stage.setTitle("BorderPane in JavaFX");
        // Asignamos la escena al escenario principal
        stage.setScene(scene);
        // Mostramos la ventana en pantalla
        stage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }

}
