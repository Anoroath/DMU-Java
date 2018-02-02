package example;

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
        Circle circle = new Circle(70, 70, 150);
        pane.getChildren().add(circle);
        circle.setFill(Color.DARKGOLDENROD);
        circle.setStroke(Color.AQUA);
        Text text = new Text(100, 300, "Kristian");
        pane.getChildren().add(text);

        int højre = 100;
        Color farve = Color.YELLOW;

        Circle circleAnders = new Circle(højre, 220, 70);
        pane.getChildren().add(circleAnders);
        circleAnders.setFill(farve);
        circleAnders.setStroke(Color.BLACK);

        Rectangle rekt = new Rectangle(højre, 100, 50, 60);
        pane.getChildren().add(rekt);
        rekt.setFill(farve);
        rekt.setStroke(Color.BLACK);

        Line anna = new Line(højre, 150, 150, 200);
        pane.getChildren().add(anna);
        anna.setStroke(Color.BLUE);

    }
}
