package guifx;

import application.model.Deltager;
import application.service.Service;
import javafx.geometry.HPos;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.stage.Modality;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

public class DeltagerWindow extends Stage {
    private Deltager deltager;

    public DeltagerWindow(String title, Deltager deltager) {
        initStyle(StageStyle.UTILITY);
        initModality(Modality.APPLICATION_MODAL);
        setResizable(false);

        this.deltager = deltager;

        setTitle(title);
        GridPane pane = new GridPane();
        initContent(pane);

        Scene scene = new Scene(pane);
        setScene(scene);
    }

    public DeltagerWindow(String title) {
        this(title, null);
    }

    // ------------------------------------------------------------------

    private TextField txfFornavn, txfEfternavn, txfTlfNr, txfAdresse, txfBy;
    private Label lblError;

    private void initContent(GridPane pane) {
        pane.setPadding(new Insets(10));
        pane.setHgap(10);
        pane.setVgap(10);
        pane.setGridLinesVisible(false);

        Label lblFornavn = new Label("Fornavn:");
        pane.add(lblFornavn, 0, 0);

        txfFornavn = new TextField();
        pane.add(txfFornavn, 1, 0);
        txfFornavn.setEditable(true);

        Label lblEfternavn = new Label("Efternavn:");
        pane.add(lblEfternavn, 0, 1);

        txfEfternavn = new TextField();
        pane.add(txfEfternavn, 1, 1);
        txfEfternavn.setEditable(true);

        Label lblTlfNr = new Label("Tlf. Nr:");
        pane.add(lblTlfNr, 0, 2);

        txfTlfNr = new TextField();
        pane.add(txfTlfNr, 1, 2);
        txfTlfNr.setEditable(true);

        Label lblAdresse = new Label("Adresse:");
        pane.add(lblAdresse, 0, 3);

        txfAdresse = new TextField();
        pane.add(txfAdresse, 1, 3);
        txfAdresse.setEditable(true);

        Label lblBy = new Label("By/Land:");
        pane.add(lblBy, 0, 4);

        txfBy = new TextField();
        pane.add(txfBy, 1, 4);
        txfBy.setEditable(true);

        Button btnOK = new Button("OK");
        pane.add(btnOK, 1, 5);
        btnOK.setOnAction(event -> okAction());

        Button btnCancel = new Button("Cancel");
        pane.add(btnCancel, 0, 5);
        GridPane.setHalignment(btnCancel, HPos.LEFT);
        btnCancel.setOnAction(event -> cancelAction());

        lblError = new Label();
        pane.add(lblError, 0, 6, 2, 1);
        lblError.setStyle("-fx-text-fill: red");

        initContent();
    }

    private void initContent() {
        if (deltager != null) {
            txfFornavn.setText(deltager.getFornavn());
            txfEfternavn.setText(deltager.getEfternavn());
            txfTlfNr.setText(deltager.getTlfnr());
            txfAdresse.setText(deltager.getAdresse());
            txfBy.setText(deltager.getBy_land());
        } else {
            txfFornavn.clear();
            txfEfternavn.clear();
            txfTlfNr.clear();
            txfAdresse.clear();
            txfBy.clear();
        }
    }

    // ----------------------------------------------------------

    private void okAction() {
        String fornavn = txfFornavn.getText().trim();
        String efternavn = txfEfternavn.getText().trim();
        String tlfNr = txfTlfNr.getText().trim();
        String adresse = txfAdresse.getText().trim();
        String by = txfBy.getText().trim();

        if (fornavn.length() == 0) {
            lblError.setText("Fornavn mangler");
            return;
        }

        if (efternavn.length() == 0) {
            lblError.setText("Efternavn mangler");
            return;
        }

        if (tlfNr.length() == 0) {
            lblError.setText("Telefon nummer mangler");
            return;
        }

        if (adresse.length() == 0) {
            lblError.setText("Adresse mangler");
            return;
        }

        if (by.length() == 0) {
            lblError.setText("By/Land mangler");
            return;
        }

        if (deltager == null) {
            Service.createDeltager(fornavn, efternavn, tlfNr, adresse, by);
        }

        if (deltager != null) {
            Service.updateDeltager(deltager, fornavn, efternavn, adresse, tlfNr, by);
        }

        hide();
    }

    private void cancelAction() {
        hide();
    }
}