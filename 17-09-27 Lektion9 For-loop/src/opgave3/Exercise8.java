package opgave3;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;

public class Exercise8 extends Application {
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
        int x = 16;
        int y1 = 80;
        int y2 = 160;
        int linjer = 10;
        for (int i = 0; i < linjer; i++) {
            gc.strokeLine(x, y1, x, y2);
            x = x + 16;
            y2 = y2 - 12;
            y1 = y1 - 4;
        }
    }
}
