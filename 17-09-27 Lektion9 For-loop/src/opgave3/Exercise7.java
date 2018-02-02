package opgave3;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;

public class Exercise7 extends Application {
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
        String s = "Datamatiker";
        int x1 = 20;
        int y1 = 20;
        int space = 15;
        for (int i = 1; i <= s.length(); i++) {
            gc.fillText(s.substring(0, i), x1, y1);
            y1 = y1 + space;
        }
    }
}