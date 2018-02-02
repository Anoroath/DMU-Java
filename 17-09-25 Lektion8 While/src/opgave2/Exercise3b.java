package opgave2;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;

public class Exercise3b extends Application {
    public static void main(String[] args) {
        Application.launch(args);
    }

    @Override
    public void start(Stage stage) {
        GridPane root = initContent();
        Scene scene = new Scene(root);

        stage.setTitle("Loops");
        stage.setScene(scene);
        stage.show();
    }

    private GridPane initContent() {
        GridPane pane = new GridPane();
        Canvas canvas = new Canvas(200, 200);
        pane.add(canvas, 0, 0);
        drawShapes(canvas.getGraphicsContext2D());
        return pane;
    }

    private void drawShapes(GraphicsContext gc) {
        int x1 = 90;
        int y1 = 20;
        int x2 = 110;
        int y2 = y1;
        while (x1 > 0 && x2 < 200 && y1 < 220) {
            gc.strokeLine(x1, y1, x2, y2);
            x1 = x1 - 20;
            x2 = x2 + 20;
            y1 = y1 + 40;
            y2 = y1;
        }
    }

}