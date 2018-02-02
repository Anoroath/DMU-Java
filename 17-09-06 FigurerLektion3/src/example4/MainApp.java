package example4;

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
        Circle Circle1 = new Circle(200, 200, 80);
        pane.getChildren().add(Circle1);
        Circle1.setFill(Color.BLACK);

        Circle Circle2 = new Circle(200, 200, 65);
        pane.getChildren().add(Circle2);
        Circle2.setFill(Color.WHITE);

        Circle Circle3 = new Circle(200, 200, 50);
        pane.getChildren().add(Circle3);
        Circle3.setFill(Color.BLACK);

        Circle Circle4 = new Circle(200, 200, 35);
        pane.getChildren().add(Circle4);
        Circle4.setFill(Color.WHITE);

        Circle Circle5 = new Circle(200, 200, 20);
        pane.getChildren().add(Circle5);
        Circle5.setFill(Color.BLACK);

    }
}
