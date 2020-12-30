package gui;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.*;
import javafx.scene.layout.*;
import logic.ObservableModel;
import logic.data.PropertyChanges;
import logic.states.EnumStates;
import logic.EnumBetStatus;
import gui.resources.Constants;
import gui.resources.Images;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseButton;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;

import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;

import static com.sun.glass.ui.Cursor.setVisible;

public class UserInterface extends BorderPane{
    private ObservableModel obsModel;

    public UserInterface(ObservableModel obsModel) {
        this.obsModel = obsModel;

        propsListener();
        functionToShow();
    }



    private void functionToShow(){

        Label userTitle = new Label("USER");
        userTitle.setTextFill(Color.BLACK);
        userTitle.setFont(new Font("Arial", 30));

        GridPane gridPane = new GridPane();
        gridPane.setAlignment(Pos.CENTER);
        gridPane.setHgap(10);
        gridPane.setVgap(10);
        gridPane.setPadding(new Insets(25, 25, 25, 25));

        Label nome = new Label("Nome: ");
        gridPane.add(nome,0,1);

        TextField nameBox = new TextField();
        gridPane.add(nameBox, 1, 1);

        Label email = new Label("Email: ");
        gridPane.add(email,0,2);

        TextField  emailBox = new TextField();
        gridPane.add(emailBox, 1, 2);

        Label age = new Label("Idade: ");
        gridPane.add(age, 0, 3);

        TextField  ageBox = new TextField();
        gridPane.add(ageBox, 1, 3);

        Label totalBets = new Label("Total Apostas: ");
        gridPane.add(totalBets, 0, 4);

        TextField totalBetsBox = new TextField();
        gridPane.add(totalBetsBox, 1,4);

        Label spinnerGeneroBox = new Label("Genero: ");
        gridPane.add(spinnerGeneroBox, 0, 5);

        final ComboBox spinnerGenero = new ComboBox();

        spinnerGenero.getItems().addAll(
                "Male",
                "Female",
                "Other" );
        gridPane.add(spinnerGenero,1, 5);

        Label totalProfit = new Label("Total de Ganhos: ");
        gridPane.add(totalProfit, 0, 6);

        TextField totalProfitBox = new TextField();
        gridPane.add(totalProfitBox,1,6 );

        Label highestWinValue = new Label("Maior Ganho: ");
        gridPane.add(highestWinValue, 0, 7);

        TextField highestWinValueBox = new TextField();
        gridPane.add(highestWinValueBox,1,7);

        Button btnCancel = new Button("Cancel");
        Button btnSave = new Button("Save");

        HBox containerButtons = new HBox();

        containerButtons.getChildren().addAll(btnCancel,btnSave);

        setTop(userTitle);
        setCenter(gridPane);
        setBottom(containerButtons);
    }

    private void propsListener() {
        obsModel.addPropertyChangeListener(PropertyChanges.STATE_CHANGE,
                evt -> {
                    setVisible(obsModel.getState() == EnumStates.USER_PROFILE);
                }
        );
    }
}
