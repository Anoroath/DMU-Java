package opgave1;

import java.util.ArrayList;
import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.VPos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;

public class MainApp extends Application {
    public static void main(String[] args) {
        Application.launch(args);
    }

    @Override
    public void start(Stage stage) {
        stage.setTitle("Person List App");
        GridPane pane = new GridPane();
        initContent(pane);

        Scene scene = new Scene(pane);
        stage.setScene(scene);
        stage.show();
    }

    // -------------------------------------------------------------------------

    private TextField txfName;
    private TextField txfTitle;
    private ListView<Person> lvwPeople;
    private CheckBox checkSenior;

    private final Controller controller = new Controller();

    private void initContent(GridPane pane) {

        pane.setGridLinesVisible(true);
        pane.setPadding(new Insets(20));
        pane.setHgap(10);
        pane.setVgap(10);

        Label lblName = new Label("Name: ");
        pane.add(lblName, 0, 0);

        Label lblTitle = new Label("Title: ");
        pane.add(lblTitle, 0, 1);

        Label lblPeople = new Label("People: ");
        pane.add(lblPeople, 0, 3);
        GridPane.setValignment(lblPeople, VPos.CENTER);

        txfName = new TextField();
        pane.add(txfName, 1, 0);

        txfTitle = new TextField();
        pane.add(txfTitle, 1, 1);

        checkSenior = new CheckBox();
        checkSenior.setText("Senior");
        pane.add(checkSenior, 0, 2);

        Button btnAdd = new Button("Add Person");
        pane.add(btnAdd, 2, 2);
        btnAdd.setOnAction(event -> this.controller.addAction());

        lvwPeople = new ListView<>();
        pane.add(lvwPeople, 1, 3);
        lvwPeople.setPrefWidth(200);
        lvwPeople.setPrefHeight(200);
        lvwPeople.getItems().setAll(controller.people);
    }

    private class Controller {
        private ArrayList<Person> people;

        public Controller() {
            initPeople();
        }

        private void initPeople() {
            people = new ArrayList<>();
            people.add(new Person("Kurt", "Doktor", false));
            people.add(new Person("Ingrid", "Mekaniker", false));
            people.add(new Person("Bent", "Landmand", true));
        }

        private void addAction() {
            String name = txfName.getText().trim();
            String title = txfTitle.getText().trim();
            boolean senior = checkSenior.isSelected();
            if (name.length() > 0 && title.length() > 0) {
                Person p = new Person(name, title, senior);
                people.add(p);
                lvwPeople.getItems().setAll(people);
            } else {
                Alert alert = new Alert(AlertType.INFORMATION);
                alert.setTitle("Add Person");
                alert.setHeaderText("No name and/or title typed");
                alert.setContentText("Type the name and/or title of the person");
                alert.show();
            }
        }
    }
}
