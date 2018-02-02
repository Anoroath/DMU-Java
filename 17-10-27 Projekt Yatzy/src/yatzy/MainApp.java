package yatzy;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;

public class MainApp extends Application {
    public static void main(String[] args) {
        Application.launch(args);
    }

    @Override
    public void start(Stage stage) {
        stage.setTitle("Yatzy");
        GridPane pane = new GridPane();
        initContent(pane);
        Scene scene = new Scene(pane);
        stage.setScene(scene);
        stage.setResizable(false);
        stage.show();
    }

    // -------------------------------------------------------------------------

    // The Yatzy game object
    private Yatzy yatzy = new Yatzy();
    // Shows the face values of the 5 dice.
    private TextField[] txfValues;
    // Shows the hold status of the 5 dice.
    private CheckBox[] chbHolds;
    private TextField[] txfResults;
    private TextField txfSumSame, txfBonus, txfSumOther, txfTotal;
    private Label lblRolled;
    private Button btnRoll;

    private void initContent(GridPane pane) {
        pane.setGridLinesVisible(false);
        pane.setPadding(new Insets(10));
        pane.setHgap(10);
        pane.setVgap(10);

        // ---------------------------------------------------------------------

        GridPane dicePane = new GridPane();
        pane.add(dicePane, 0, 0);
        dicePane.setGridLinesVisible(false);
        dicePane.setPadding(new Insets(10));
        dicePane.setHgap(10);
        dicePane.setVgap(10);
        dicePane.setStyle("-fx-border-color: black");

        // TODO: initialize txfValues, chbHolds, btnRoll and lblRolled
        Controller control = new Controller();
        txfValues = new TextField[5];
        chbHolds = new CheckBox[5];
        for (int i = 0; i < txfValues.length; i++) {
            txfValues[i] = new TextField();
            dicePane.add(txfValues[i], i, 0);
            chbHolds[i] = new CheckBox("Hold");
            dicePane.add(chbHolds[i], i, 1);
        }

        btnRoll = new Button("Roll");
        dicePane.add(btnRoll, 3, 2);
        btnRoll.setOnAction(event -> control.rollAction());

        lblRolled = new Label("Rolled: " + yatzy.getThrowCount());
        dicePane.add(lblRolled, 4, 2);

        // ---------------------------------------------------------------------

        GridPane scorePane = new GridPane();
        pane.add(scorePane, 0, 1);
        scorePane.setGridLinesVisible(false);
        scorePane.setPadding(new Insets(10));
        scorePane.setVgap(5);
        scorePane.setHgap(10);
        scorePane.setStyle("-fx-border-color: black");

        // TODO: Initialize labels for results, txfResults,
        // labels and text fields for sums, bonus and total.

        scorePane.add(new Label("1-s"), 0, 0);
        scorePane.add(new Label("2-s"), 0, 1);
        scorePane.add(new Label("3-s"), 0, 2);
        scorePane.add(new Label("4-s"), 0, 3);
        scorePane.add(new Label("5-s"), 0, 4);
        scorePane.add(new Label("6-s"), 0, 5);
        scorePane.add(new Label("Sum:"), 2, 5);
        scorePane.add(new Label("Bonus:"), 4, 5);
        scorePane.add(new Label("One Pair"), 0, 6);
        scorePane.add(new Label("Two Pairs"), 0, 7);
        scorePane.add(new Label("Three Same"), 0, 8);
        scorePane.add(new Label("Four Same"), 0, 9);
        scorePane.add(new Label("Full House"), 0, 10);
        scorePane.add(new Label("Small Straight"), 0, 11);
        scorePane.add(new Label("Large Straight"), 0, 12);
        scorePane.add(new Label("Chance"), 0, 13);
        scorePane.add(new Label("Yatzy"), 0, 14);
        scorePane.add(new Label("Sum:"), 2, 14);
        scorePane.add(new Label("Total:"), 4, 14);

        txfResults = new TextField[15];
        for (int i = 0; i < txfResults.length; i++) {
            txfResults[i] = new TextField();
            scorePane.add(txfResults[i], 1, i);
        }

        txfSumSame = new TextField();
        scorePane.add(txfSumSame, 3, 5);

        txfBonus = new TextField();
        scorePane.add(txfBonus, 5, 5);

        txfSumOther = new TextField();
        scorePane.add(txfSumOther, 3, 14);

        txfTotal = new TextField();
        scorePane.add(txfTotal, 5, 14);
    }

    // -------------------------------------------------------------------------

    // TODO: Create a method for btnRoll's action.
    // Hint: Create small helper methods to be used in the action method.
    private class Controller {
        private void rollAction() {
            boolean[] holds = new boolean[5];
            for (int i = 0; i < holds.length; i++) {
                holds[i] = chbHolds[i].isSelected();
            }
            yatzy.throwDice(holds);
            updateValues();
            lblRolled.setText("Rolled: " + yatzy.getThrowCount());
        }

        private void updateValues() {
            for (int i = 0; i < txfValues.length; i++) {
                txfValues[i].setText(yatzy.getValues()[i] + "");
            }
        }
    }

    // -------------------------------------------------------------------------

    // TODO: Create a method for mouse click on one of the text fields in
    // txfResults.
    // Hint: Create small helper methods to be used in the mouse click method.

}
