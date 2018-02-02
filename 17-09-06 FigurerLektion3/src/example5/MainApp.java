package example5;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.scene.shape.Line;
import javafx.scene.shape.Rectangle;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import Javax.swing.JOptionPane;

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
        hoved.setFill(Color.BLACK);

        Circle øre1 = new Circle(120, 120, 40);
        pane.getChildren().add(øre1);
        øre1.setFill(Color.BLACK);

        Circle øre2 = new Circle(280, 120, 40);
        pane.getChildren().add(øre2);
        øre2.setFill(Color.BLACK);

        System.out.print("HEJ");

    }
}
