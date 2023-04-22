package Chess;
import javafx.scene.Scene;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;
import javafx.application.Application;

public class Game extends Application
{
    public void start(Stage s)
    {
        s.setTitle("Chess");
        s.setScene(new Scene(new Board()));
        s.setResizable(false);
        s.show();
    }
}