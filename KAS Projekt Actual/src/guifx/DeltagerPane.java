package guifx;

import application.model.Deltager;
import application.model.Tilmeldning;
import application.service.Service;
import javafx.beans.value.ChangeListener;
import javafx.geometry.Insets;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;

public class DeltagerPane extends GridPane {
    private ListView<Deltager> lvwDeltager;
    private ListView<Tilmeldning> lvwKonferencer;
    private TextField txfNavn, txfTlfNr, txfAdresse;

    public DeltagerPane() {
        setPadding(new Insets(20));
        setHgap(20);
        setVgap(10);
        setGridLinesVisible(false);

        Label lblDeltager = new Label("Deltagerer:");
        this.add(lblDeltager, 0, 0);

        lvwDeltager = new ListView<>();
        this.add(lvwDeltager, 0, 1, 1, 8);
        lvwDeltager.setPrefWidth(200);
        lvwDeltager.getItems().setAll(Service.getDeltagere());

        ChangeListener<Deltager> listener = (ov, newDeltager, oldDeltager) -> selectedDeltagerChanged();
        lvwDeltager.getSelectionModel().selectedItemProperty().addListener(listener);

        Label lblNavn = new Label("Navn:");
        this.add(lblNavn, 1, 1);

        txfNavn = new TextField();
        this.add(txfNavn, 2, 1);
        txfNavn.setEditable(false);

        Label lblTlfNr = new Label("Tlf. nr:");
        this.add(lblTlfNr, 1, 2);

        txfTlfNr = new TextField();
        this.add(txfTlfNr, 2, 2);
        txfTlfNr.setEditable(false);

        Label lblAdresse = new Label("Adresse:");
        this.add(lblAdresse, 1, 3);

        txfAdresse = new TextField();
        this.add(txfAdresse, 2, 3);
        txfAdresse.setEditable(false);

        Label lblKonference = new Label("Tilmeldte \nkonferencer:");
        this.add(lblKonference, 1, 5);

        lvwKonferencer = new ListView<>();
        this.add(lvwKonferencer, 2, 5, 1, 4);
        lvwKonferencer.setPrefWidth(180);
        lvwKonferencer.setPrefHeight(200);

        ChangeListener<Tilmeldning> listener2 = (ov, newTilmeldning, oldTilmeldning) -> selectedTilmeldningChanged();
        lvwKonferencer.getSelectionModel().selectedItemProperty().addListener(listener2);

        // ---------------------------------------------------------------
        // buttons
        int buttonWidth = 130;
        int buttonMargin = 10;

        Button OprDel = new Button("Opret Deltager");
        this.add(OprDel, 3, 1);
        OprDel.setPrefWidth(buttonWidth);
        GridPane.setMargin(OprDel, new Insets(buttonMargin, buttonMargin, buttonMargin, buttonMargin));

        OprDel.setOnAction(Event -> opretDeltagerAction());

        Button Update = new Button("Opdater deltager");
        this.add(Update, 3, 2);
        Update.setPrefWidth(buttonWidth);
        GridPane.setMargin(Update, new Insets(buttonMargin, buttonMargin, buttonMargin, buttonMargin));

        Update.setOnAction(event -> updateDeltagerAction());

        Button btnDeleteDeltager = new Button("Slet deltager");
        this.add(btnDeleteDeltager, 3, 3);
        btnDeleteDeltager.setPrefWidth(buttonWidth);
        GridPane.setMargin(btnDeleteDeltager, new Insets(buttonMargin, buttonMargin, buttonMargin, buttonMargin));

        btnDeleteDeltager.setOnAction(event -> deleteDeltagerAction());

        Button TilmKonf = new Button("Tilmeld Konference");
        this.add(TilmKonf, 3, 6);
        TilmKonf.setPrefWidth(buttonWidth);
        GridPane.setMargin(TilmKonf, new Insets(buttonMargin, buttonMargin, buttonMargin, buttonMargin));

        TilmKonf.setOnAction(event -> tilmeldKonferenceAction());

        Button btnDeleteTilm = new Button("Slet Tilmeldning");
        this.add(btnDeleteTilm, 3, 7);
        btnDeleteTilm.setPrefWidth(buttonWidth);
        GridPane.setMargin(btnDeleteTilm, new Insets(buttonMargin, buttonMargin, buttonMargin, buttonMargin));

        btnDeleteTilm.setOnAction(event -> deleteTilmeldning());
    }

    // --------------------------------------------------------------------

    private void selectedDeltagerChanged() {
        updateControls();
    }

    private void selectedTilmeldningChanged() {

    }

    public void updateControls() {
        Deltager deltager = lvwDeltager.getSelectionModel().getSelectedItem();

        if (deltager != null) {
            txfNavn.setText(deltager.getFornavn() + " " + deltager.getEfternavn());
            txfTlfNr.setText(deltager.getTlfnr());
            txfAdresse.setText(deltager.getAdresse());
            lvwKonferencer.getItems().setAll(deltager.getTilmeldninger());
        } else {
            txfNavn.clear();
            txfTlfNr.clear();
            txfAdresse.clear();
            lvwKonferencer.getItems().clear();
        }

    }

    public void updateTab() {
        lvwDeltager.getItems().setAll(Service.getDeltagere());
    }

    // ---------------------------------------------------------------------

    private void opretDeltagerAction() {
        DeltagerWindow dia = new DeltagerWindow("Opret deltager");
        dia.showAndWait();
        updateTab();
        updateControls();
    }

    private void updateDeltagerAction() {
        if (lvwDeltager.getSelectionModel().getSelectedItem() != null) {
            DeltagerWindow dia = new DeltagerWindow("Opdater deltager",
                    lvwDeltager.getSelectionModel().getSelectedItem());
            dia.showAndWait();
            updateTab();
            updateControls();
        }
    }

    private void deleteDeltagerAction() {
        if (lvwDeltager.getSelectionModel().getSelectedItem() != null) {
            Deltager deltager = lvwDeltager.getSelectionModel().getSelectedItem();
            Service.deleteDeltager(deltager);
            updateTab();
            updateControls();
        }
    }

    // ---------------------------------------------------------------------

    private void tilmeldKonferenceAction() {
        if (lvwDeltager.getSelectionModel().getSelectedItem() != null) {
            TilmeldningWindow dia = new TilmeldningWindow("Tilmeld konference",
                    lvwDeltager.getSelectionModel().getSelectedItem());
            dia.showAndWait();
            updateControls();
        }
    }

    private void deleteTilmeldning() {
        if (lvwKonferencer.getSelectionModel().getSelectedItem() != null) {
            Tilmeldning tilmeldning = lvwKonferencer.getSelectionModel().getSelectedItem();
            Service.deleteTilmeldning(tilmeldning);
            updateControls();
            updateTab();
        }
    }

}