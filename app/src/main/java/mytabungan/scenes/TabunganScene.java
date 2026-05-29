package mytabungan.scenes;

import javafx.geometry.Insets;
import javafx.scene.control.Label;
import javafx.scene.layout.VBox;
import mytabungan.utils.SessionManager;

public class TabunganScene {
    public static VBox buildPage() {
        String username = SessionManager.getCurrentUser().getUsername();

        //
        // Teks Hello
        Label helloLabel = new Label("Hello, ");
        Label usernameLabel = new Label(username + "!");
        helloLabel.setStyle("-fx-fill: #001F3F;");
        usernameLabel.setStyle("-fx-fill: #001F3F; -fx-font-weight: bold;");

        VBox page = new VBox(0);
        page.setPrefWidth(750);
        page.setMinWidth(750);
        page.setMaxWidth(Double.MAX_VALUE);
        page.setPadding(new Insets(30));
        page.setStyle("-fx-background-color: #F6F7ED;");

        page.getChildren().addAll(helloLabel, usernameLabel);
        return page;
    }
}
