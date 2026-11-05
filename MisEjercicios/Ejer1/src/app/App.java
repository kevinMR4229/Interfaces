package app;


import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TextField;
import javafx.scene.control.ToggleGroup;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.stage.Stage;


record Error(
    String campo,
    String mensaje
) {}


class Validador{

    public static List<Error> validate(String nombre, String edad, Optional<Object> curso, RadioButton turno, boolean confirmacion){
        List<Error> errores = new ArrayList<>();

        if (nombre.isEmpty()) {
                errores.add(new Error("nombre", "No puede estar vacio"));
            }

        if (edad.isEmpty()) {
            errores.add(new Error("edad", "No puede estar vacio"));
        }else {
            try{
                if (Integer.parseInt(edad) <=0) {
                errores.add(new Error("edad", "La edad no puede ser menor o igual a cero"));
                }   
            }catch(NumberFormatException ex){
                errores.add(new Error("edad", "La edad debe ser un numero"));
            }
        }
        
        if (!curso.isPresent()) {
            errores.add(new Error("curso", "Debe seleccionar un curso"));
        }

        if (turno == null) {
            errores.add(new Error("turno", "Debe seleccionar un turno"));
        }
        if (!errores.isEmpty() && confirmacion) {
            errores.add(new Error("confirmacion", "Debe rellenar todos los campos antes de confirmar"));
        }else{
            if (errores.isEmpty() && !confirmacion) {
            errores.add(new Error("confirmacion", "Debe confirmar"));
            }
        }

        

        return errores;
    }
}


public class App extends Application{


    @Override
    public void start(Stage stage) {
        Label titulo = new Label("Información personal");


        //Componentes individuales

        Label lNombre = new Label("Nombre");
        TextField tfNombre = new TextField();

        Label ledad = new Label("Edad");
        TextField tfedad = new TextField();

        Label lcurso = new Label("Curso");
        ComboBox cbCurso = new ComboBox<>();
        cbCurso.getItems().addAll("DAM", "DAW", "ASIR");

        Label lTurno = new Label("Turno Estudios");
        RadioButton btnMañana = new RadioButton("mañana");
        RadioButton btnTarde = new RadioButton("tarde");
        ToggleGroup toggleGroup = new ToggleGroup();
        btnMañana.setToggleGroup(toggleGroup);
        btnTarde.setToggleGroup(toggleGroup);

        CheckBox cbConfirmacion = new CheckBox("Confirmo que los datos son correctos");

        Label mensajeErrores = new Label("");
        mensajeErrores.setVisible(false);


        //Button btnSalir = new Button("Salir");
        //btnSalir.setOnAction(e -> stage.close());

        Button btnGuardar = new Button("Guardar");

        //Logica del boton guardar
        btnGuardar.setOnAction(e -> {
            List<Error> errores = new ArrayList<>();

            mensajeErrores.setVisible(false);
            mensajeErrores.setText("");

            String nombre = tfNombre.getText().trim();
            String edad = tfedad.getText().trim();
            Optional<Object> curso = Optional.ofNullable(cbCurso.getValue());
            RadioButton turno = (RadioButton) toggleGroup.getSelectedToggle(); 
            boolean confirmacion = cbConfirmacion.isSelected();

            errores.addAll(Validador.validate(nombre, edad, curso, turno, confirmacion));
            

            if (!errores.isEmpty()) {
                String msg = "";

                for(Error error : errores){
                    msg = msg + "\n" + error.campo() + ": " + error.mensaje();
                }
                mensajeErrores.setText(msg);
                mensajeErrores.setTextFill(Color.RED);
                mensajeErrores.setVisible(true);
            }else{
                mensajeErrores.setText("Formulario completado correctamente");
                mensajeErrores.setTextFill(Color.GREEN);
                mensajeErrores.setVisible(true);
            }

        });
        





        //Boxes
        VBox nombre = new VBox(3, lNombre, tfNombre);
        VBox edad = new VBox(3, ledad, tfedad);
        VBox curso = new VBox(3, lcurso, cbCurso);
        HBox horarios = new HBox(btnMañana, btnTarde);

        VBox raiz = new VBox(5, titulo, nombre, edad, curso, lTurno, horarios, cbConfirmacion, btnGuardar, mensajeErrores);



        //Escena
        Scene scene = new Scene(raiz, 500, 300);


        //CSS
        scene.getStylesheets().add(getClass().getResource("Estilos.css").toExternalForm());

        //btnSalir.setId("btn-salir");
        btnGuardar.setId("btn-guardar");
        titulo.setId("titulo");
        nombre.getStyleClass().add("campos");
        edad.getStyleClass().add("campos");
        curso.getStyleClass().add("campos");
        lTurno.getStyleClass().add("campos");
        mensajeErrores.setId("msg-errores");



        stage.setTitle("Mi primera Aplicacion");
        stage.setScene(scene);
        stage.show();
    }

    public static void main(String[] args){
        launch(args);
    }

    
}
