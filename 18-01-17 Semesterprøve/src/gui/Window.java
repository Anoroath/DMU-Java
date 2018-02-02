// Anders Broch Ulsted

package gui;

import application.model.Arrangement;
import application.model.Tutor;
import javafx.geometry.Insets;
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;

public class Window extends GridPane {
    private ListView<Tutor> lwTutor;
    private ListView<Arrangement> lwTilArrangement;
    private ListView<Arrangement> lwMulArrangement;
    private TextField txfNavn, txfEmail;

    public Window() {
        setPadding(new Insets(20));
        setHgap(20);
        setVgap(10);
        setGridLinesVisible(false);
    }
}
