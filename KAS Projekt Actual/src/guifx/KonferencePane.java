package guifx;

import application.model.Deltager;
import application.model.Hotel;
import application.model.Konference;
import application.model.Ledsager;
import application.model.Udflugt;
import application.service.Service;
import javafx.beans.value.ChangeListener;
import javafx.geometry.Insets;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.layout.GridPane;

public class KonferencePane extends GridPane {
    private ListView<Konference> lvKonference;
    private ListView<Hotel> lvHotel;
    private ListView<String> lvHotelGæster;
    private ListView<Udflugt> lvUdflugter;
    private ListView<Ledsager> lvUdflugtTilmeldt;
    private ListView<Deltager> lvDeltagere;

    public KonferencePane() {
        setPadding(new Insets(20));
        setHgap(20);
        setVgap(10);
        setGridLinesVisible(false);

        int prefWidth = 200;
        int prefHeight = 200;

        Label lblKonf = new Label("Konferencer:");
        this.add(lblKonf, 0, 0);

        lvKonference = new ListView<>();
        this.add(lvKonference, 0, 1, 1, 3);
        lvKonference.setPrefWidth(prefWidth);
        lvKonference.setPrefHeight(350);
        lvKonference.getItems().setAll(Service.getKonferencer());

        ChangeListener<Konference> listener = (ov, oldKonference, newKonference) -> selectedKonferenceChanged();
        lvKonference.getSelectionModel().selectedItemProperty().addListener(listener);

        Label lblDeltager = new Label("Deltagere:");
        this.add(lblDeltager, 1, 0);

        lvDeltagere = new ListView<>();
        this.add(lvDeltagere, 1, 1, 1, 3);
        lvDeltagere.setPrefWidth(prefWidth);
        lvDeltagere.setPrefHeight(350);

        Label lblHotel = new Label("Hotel:");
        this.add(lblHotel, 2, 0);

        lvHotel = new ListView<>();
        this.add(lvHotel, 2, 1);
        lvHotel.setPrefWidth(prefWidth);
        lvHotel.setPrefHeight(prefHeight);

        ChangeListener<Hotel> listener2 = (ov, oldHotel, newHotel) -> selectedHotelChanged();
        lvHotel.getSelectionModel().selectedItemProperty().addListener(listener2);

        Label lblHotelGæst = new Label("Hotelgæster:");
        this.add(lblHotelGæst, 2, 2);

        lvHotelGæster = new ListView<>();
        this.add(lvHotelGæster, 2, 3);
        lvHotelGæster.setPrefWidth(prefWidth);
        lvHotelGæster.setPrefHeight(prefHeight);

        Label lblUdflugt = new Label("Udflugter:");
        this.add(lblUdflugt, 3, 0);

        lvUdflugter = new ListView<>();
        this.add(lvUdflugter, 3, 1);
        lvUdflugter.setPrefWidth(prefWidth);
        lvUdflugter.setPrefHeight(prefHeight);

        ChangeListener<Udflugt> listener3 = (ov, newUdflugt, oldUdflugt) -> selectedUdflugtChanged();
        lvUdflugter.getSelectionModel().selectedItemProperty().addListener(listener3);

        Label lblUdflugtTil = new Label("Tilmeldt Udflugt:");
        this.add(lblUdflugtTil, 3, 2);

        lvUdflugtTilmeldt = new ListView<>();
        this.add(lvUdflugtTilmeldt, 3, 3);
        lvUdflugtTilmeldt.setPrefWidth(prefWidth);
        lvUdflugtTilmeldt.setPrefHeight(prefHeight);
    }

    // -----------------------------------------------------------------

    public void updateControls() {
        Konference konference = lvKonference.getSelectionModel().getSelectedItem();

        if (konference != null) {
            lvHotel.getItems().setAll(Service.getHoteller(konference));
            lvUdflugter.getItems().setAll(Service.getUdflugter(konference));
            lvDeltagere.getItems().setAll(Service.getDeltagereKonference(konference));
        } else {
            lvHotel.getItems().clear();
            lvUdflugter.getItems().clear();
            lvDeltagere.getItems().clear();
        }
    }

    private void selectedKonferenceChanged() {
        lvHotelGæster.getItems().clear();
        lvUdflugtTilmeldt.getItems().clear();
        updateControls();

    }

    private void selectedHotelChanged() {
        Hotel hotel = lvHotel.getSelectionModel().getSelectedItem();
        if (hotel != null) {
            lvHotelGæster.getItems().setAll(Service.getHotelGæster(hotel));
        } else {
            lvHotelGæster.getItems().clear();
        }
    }

    private void selectedUdflugtChanged() {
        Udflugt udflugt = lvUdflugter.getSelectionModel().getSelectedItem();
        if (udflugt != null) {
            lvUdflugtTilmeldt.getItems().setAll(Service.getUdflugtTilmeldt(udflugt));
        } else {
            lvUdflugtTilmeldt.getItems().clear();
        }
    }
}
