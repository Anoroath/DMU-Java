package example3;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.scene.shape.Line;
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
        Circle hoved = new Circle(200, 200, 80);
        pane.getChildren().add(hoved);
        hoved.setFill(null);
        hoved.setStroke(Color.BLACK);
        hoved.setStrokeWidth(1);

        Circle øje1 = new Circle(170, 180, 8);
        pane.getChildren().add(øje1);
        øje1.setFill(null);
        øje1.setStroke(Color.BLACK);
        øje1.setStrokeWidth(1);

        Circle øje2 = new Circle(230, 180, 8);
        pane.getChildren().add(øje2);
        øje2.setFill(null);
        øje2.setStroke(Color.BLACK);
        øje2.setStrokeWidth(1);

        Line mund = new Line(240, 230, 160, 230);
        pane.getChildren().add(mund);
        mund.setStroke(Color.BLACK);

    }
}
