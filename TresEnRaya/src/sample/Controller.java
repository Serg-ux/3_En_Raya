package sample;

import javafx.event.ActionEvent;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.GridPane;

public class Controller {
    public GridPane gpGrid;
    public Button btPuzzle;
    public TextArea taInformacion;
    public ImageView imVerde;
    public ImageView imRoja;


    Juego tres = new Juego();

    public void initialize() {
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                Button button = new Button();

                button.setMaxSize(Double.MAX_VALUE, Double.MAX_VALUE);
                button.setOnAction(this::buttonClic);  //asociar método
                gpGrid.add(button, j, i); // coordenas del layout grid  coumna fila
            }


        }
    }

    private void buttonClic(ActionEvent actionEvent) {
        Button button = (Button) (actionEvent.getTarget());
       int colGrid = gpGrid.getColumnIndex(button);
       int filGrid = gpGrid.getRowIndex(button);

        if(tres.colocarFicha(filGrid, colGrid)) {
            asignarImagen_Button(button);

        if (tres.comprobarFila(filGrid) || tres.comprobarColumna(colGrid) || tres.comprobarDiagonalPrincipal() || tres.comprobarDiagonalInversa()) {
            taInformacion.setText("Game over" + "\n Gano JUGADOR " + tres.getTurno());
            gpGrid.setDisable(true);
        } else {
            if (tres.getfichasColocadas()==9 ) {
                taInformacion.setText("Game over");
                gpGrid.setDisable(true);
            }
            else{
            tres.AsignarTurno();

            if (tres.getTurno() == 1) {
                imVerde.setVisible(true);
                imRoja.setVisible(false);
            } else {
                imRoja.setVisible(true);
                imVerde.setVisible(false);
            }
            }
        }
    }

    }


    public void asignarImagen_Button(Button  button){
        Image image = new Image(getClass().getResourceAsStream("imagenes/ficha"+tres.getTurno()+".png" ), 100, 100, false, false);
        ImageView imageView = new ImageView(image);
        button.setGraphic(imageView);
        button.setMaxSize(Double.MAX_VALUE, Double.MAX_VALUE);
    }

    public void btNuevoClick(ActionEvent actionEvent) {
        gpGrid.setDisable(false);
        tres=new Juego();
        gpGrid.getChildren().clear();
        taInformacion.clear();
        initialize();
    }
}
