package mytabungan.scenes;

import javafx.scene.Scene;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;

public class MainScene {

    public static Scene getMain(Stage stage) {

        BorderPane root = new BorderPane();
        root.setLeft(
            Sidebar.buildSidebar(root, stage)
        );
        root.setCenter(
            TabunganScene.buildPage()
        );

        Scene scene = new Scene(root, 960, 600);
        scene.getStylesheets().add(
            LoginScene.class.getResource("/style.css").toExternalForm()
        );
        return scene;
    }
}