package guifx;

import java.time.LocalDate;

import application.model.Deltager;
import application.model.Hotel;
import application.model.Konference;
import application.model.Tillæg;
import application.model.Tilmeldning;
import application.model.Udflugt;
import application.service.Service;
import javafx.beans.value.ChangeListener;
import javafx.geometry.HPos;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.control.SelectionMode;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.stage.Modality;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

public class TilmeldningWindow extends Stage {
    private Deltager deltager;

    public TilmeldningWindow(String title, Deltager deltager) {
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

    // ------------------------------------------------------------

    private TextField txfDelNavn, txfFirmaNavn, txfFirmaTlfNr, txfLedsagerFNavn, txfLedsagerENavn, txfAnkomstDato,
            txfAfrejseDato;
    private ListView<Konference> lvwKonference;
    private ListView<Udflugt> lvwUdflugter;
    private ListView<Hotel> lvwHoteller;
    private ListView<Tillæg> lvwTillæg;
    private Label lblError;
    private CheckBox cbForedrag;
    private CheckBox cbLedsager;
    private CheckBox cbfirma;

    private void initContent(GridPane pane) {
        pane.setPadding(new Insets(10));
        pane.setHgap(10);
        pane.setVgap(10);
        pane.setGridLinesVisible(false);

        Label lblDeltager = new Label("Deltager:");
        pane.add(lblDeltager, 0, 0);

        txfDelNavn = new TextField();
        pane.add(txfDelNavn, 1, 0);
        txfDelNavn.setEditable(false);
        txfDelNavn.setText(this.deltager.getFornavn() + " " + this.deltager.getEfternavn());

        Label lblKonference = new Label("Konference:");
        pane.add(lblKonference, 0, 1);

        lvwKonference = new ListView<>();
        pane.add(lvwKonference, 1, 1, 1, 3);
        lvwKonference.setPrefWidth(200);
        lvwKonference.setPrefHeight(200);
        lvwKonference.getItems().setAll(Service.getKonferencer());

        ChangeListener<Konference> listener = (ov, oldKonference, newKonference) -> selectedKonferenceChanged();
        lvwKonference.getSelectionModel().selectedItemProperty().addListener(listener);

        Label lblDato = new Label("Indtast afrejse-/ankomsdato (åååå-mm-dd):");
        pane.add(lblDato, 2, 1, 2, 1);

        Label lblAnkomst = new Label("Ankomstdato");
        pane.add(lblAnkomst, 2, 2);

        txfAnkomstDato = new TextField();
        pane.add(txfAnkomstDato, 3, 2);

        Label lblAfrejse = new Label("Afrejsedato");
        pane.add(lblAfrejse, 2, 3);
        lblAfrejse.setAlignment(Pos.TOP_LEFT);

        txfAfrejseDato = new TextField();
        pane.add(txfAfrejseDato, 3, 3);
        txfAfrejseDato.setAlignment(Pos.TOP_LEFT);

        cbForedrag = new CheckBox();
        cbForedrag.setText("Foredragsholder");
        pane.add(cbForedrag, 0, 2);

        cbfirma = new CheckBox();
        cbfirma.setText("Firma");
        pane.add(cbfirma, 0, 4);

        Label lblFirmaNavn = new Label("Firmanavn:");
        pane.add(lblFirmaNavn, 1, 4);

        txfFirmaNavn = new TextField();
        pane.add(txfFirmaNavn, 2, 4, 2, 1);

        Label lblFirmaTlfNr = new Label("Firma Tlf. nr:");
        pane.add(lblFirmaTlfNr, 1, 5);

        txfFirmaTlfNr = new TextField();
        pane.add(txfFirmaTlfNr, 2, 5, 2, 1);

        cbLedsager = new CheckBox();
        cbLedsager.setText("Ledsager");
        pane.add(cbLedsager, 0, 6);

        Label lblLedFornavn = new Label("Fornavn:");
        pane.add(lblLedFornavn, 1, 6);

        txfLedsagerFNavn = new TextField();
        pane.add(txfLedsagerFNavn, 2, 6, 2, 1);

        Label lblLedEfternavn = new Label("Efternavn:");
        pane.add(lblLedEfternavn, 1, 7);

        txfLedsagerENavn = new TextField();
        pane.add(txfLedsagerENavn, 2, 7, 2, 1);

        Label lblUdflugter = new Label("Udflugter:");
        pane.add(lblUdflugter, 0, 9);

        lvwUdflugter = new ListView<>();
        pane.add(lvwUdflugter, 1, 9);
        lvwUdflugter.setPrefWidth(200);
        lvwUdflugter.setPrefHeight(200);
        lvwUdflugter.getSelectionModel().setSelectionMode(SelectionMode.MULTIPLE);

        Label lblHotel = new Label("Vælg hotel:");
        pane.add(lblHotel, 0, 10);

        lvwHoteller = new ListView<>();
        pane.add(lvwHoteller, 1, 10);
        lvwHoteller.setPrefHeight(200);
        lvwHoteller.setPrefWidth(200);

        ChangeListener<Hotel> listener2 = (ov, newHotel, oldHotel) -> selectedHotelChanged();
        lvwHoteller.getSelectionModel().selectedItemProperty().addListener(listener2);

        Label lblTillæg = new Label("Vælg tillæg");
        pane.add(lblTillæg, 2, 10);

        lvwTillæg = new ListView<>();
        pane.add(lvwTillæg, 3, 10);
        lvwTillæg.setPrefHeight(200);
        lvwTillæg.setPrefWidth(200);
        lvwTillæg.getSelectionModel().setSelectionMode(SelectionMode.MULTIPLE);

        Button btnOK = new Button("OK");
        pane.add(btnOK, 3, 11);
        GridPane.setHalignment(btnOK, HPos.RIGHT);
        btnOK.setOnAction(event -> okAction());

        Button btnCancel = new Button("Cancel");
        pane.add(btnCancel, 0, 11);
        GridPane.setHalignment(btnCancel, HPos.LEFT);
        btnCancel.setOnAction(event -> cancelAction());

        lblError = new Label();
        pane.add(lblError, 0, 12, 2, 1);
        lblError.setStyle("-fx-text-fill: red");
    }

    // --------------------------------------------------------------------------------

    public void updateControls() {
        Konference konference = lvwKonference.getSelectionModel().getSelectedItem();

        if (konference != null) {
            lvwHoteller.getItems().setAll(Service.getHoteller(konference));
            lvwUdflugter.getItems().setAll(Service.getUdflugter(konference));
        } else {
            lvwHoteller.getItems().clear();
            lvwUdflugter.getItems().clear();
        }

    }

    private void selectedKonferenceChanged() {
        lvwHoteller.getItems().clear();
        lvwUdflugter.getItems().clear();
        lvwTillæg.getItems().clear();
        updateControls();
    }

    private void selectedHotelChanged() {
        Hotel hotel = lvwHoteller.getSelectionModel().getSelectedItem();
        // updateControls();
        if (hotel != null) {
            lvwTillæg.getItems().setAll(Service.getTillæg(hotel));
        } else {
            lvwTillæg.getItems().clear();
        }
    }

    private void okAction() {
        Konference konference = lvwKonference.getSelectionModel().getSelectedItem();

        if (konference == null) {
            lblError.setText("Vælg venligst en konference");
            return;
        }

        if (!txfAnkomstDato.getText().equals("") && !txfAfrejseDato.getText().equals("")) {
            if (LocalDate.parse(txfAnkomstDato.getText()).isBefore(konference.getStartDato())
                    || (LocalDate.parse(txfAfrejseDato.getText()).isAfter(konference.getSlutDato()))) {
                lblError.setText("Ugyldig dato");
                return;
            } else {
                Boolean foredrag = cbForedrag.isSelected();
                LocalDate ankomst = LocalDate.parse(txfAnkomstDato.getText());
                LocalDate afrejse = LocalDate.parse(txfAfrejseDato.getText());
                Hotel hotel = lvwHoteller.getSelectionModel().getSelectedItem();

                Tilmeldning til = Service.createTilmeldning(ankomst, afrejse, foredrag, deltager, konference);

                if (cbLedsager.isSelected()) {
                    til.createLedsager(txfLedsagerFNavn.getText(), txfLedsagerENavn.getText());
                }

                if (cbfirma.isSelected()) {
                    til.createFirma(txfFirmaNavn.getText(), txfFirmaTlfNr.getText());
                }

                for (Udflugt u : lvwUdflugter.getSelectionModel().getSelectedItems()) {
                    til.addUdflugt(u);
                }

                if (hotel != null) {
                    til.setHotel(hotel);
                    for (Tillæg t : lvwTillæg.getSelectionModel().getSelectedItems()) {
                        til.addTillæg(t);
                    }
                }

                Alert alert = new Alert(AlertType.INFORMATION);
                alert.setTitle("Bekræft tilmeldning");
                String contentText = Double.toString(Service.udregnPris(til));
                alert.setHeaderText("Bekræftelse");
                alert.setContentText("Samlet pris: " + contentText + " kr");
                alert.showAndWait();
            }
        } else {
            lblError.setText("Ugyldig dato");
            return;
        }

        hide();
    }

    private void cancelAction() {
        hide();
    }
}
