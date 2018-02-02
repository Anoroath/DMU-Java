package example2;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.scene.shape.Line;
import javafx.scene.shape.Polygon;
import javafx.scene.shape.Rectangle;
import javafx.scene.text.Text;
import javafx.stage.Stage;

public class MainApp extends Application {
    public static void main(String[] args) {
        Application.launch(args);
    }

    @Override
    public void start(Stage stage) {
        Pane root = initContent();
        Scene scene = new Scene(root);

        stage.setTitle("Shapes");
        stage.setScene(scene);
        stage.show();
    }

    private Pane initContent() {
        Pane pane = new Pane();
        pane.setPrefSize(400, 400);
        drawShapes(pane);
        return pane;
    }

    // ------------------------------------------------------------------------

    private void drawShapes(Pane pane) {
        Rectangle hus = new Rectangle(40, 200, 120, 120);
        pane.getChildren().add(hus);
        hus.setFill(Color.RED);

        Rectangle vindue = new Rectangle(60, 220, 40, 40);
        pane.getChildren().add(vindue);
        vindue.setFill(Color.BLACK);

        Polygon tag = new Polygon(20, 200, 100, 100, 180, 200);
        pane.getChildren().add(tag);
        tag.setFill(Color.DARKGREEN);

        Line jord = new Line(20, 320, 350, 320);
        pane.getChildren().add(jord);
        jord.setStroke(Color.BLACK);

        Circle sol = new Circle(250, 100, 45);
        pane.getChildren().add(sol);
        sol.setFill(Color.YELLOW);
        sol.setStroke(Color.BLACK);

        Rectangle dør = new Rectangle(110, 220, 40, 100);
        pane.getChildren().add(dør);
        dør.setFill(Color.SADDLEBROWN);

    }
}
