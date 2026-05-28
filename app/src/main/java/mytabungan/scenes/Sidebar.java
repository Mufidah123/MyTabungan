package mytabungan.scenes;

import javafx.scene.control.Button;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.Priority;
import javafx.scene.layout.Region;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class Sidebar {
    public static VBox buildSidebar(BorderPane root, Stage stage){
        VBox sidebar = new VBox(12);
        sidebar.setPrefWidth(210);
        sidebar.setStyle("-fx-background-color: #001F3F; -fx-padding: 30 20 30 20; -fx-background-radius: 0 24 24 0;");

        // === Menu Sidebar ===
        Button tabunganButton = createMenuButton("My Tabungan");
        Button wishlistButton = createMenuButton("WishlistKu");
        // Button challengeButton = createMenuButton("Challenges"); // Opsional
        Button growthButton = createMenuButton("Growth");
        Button logoutButton = createMenuButton("Logout");

        // === Action ===
        root.setCenter(
            TabunganScene.buildPage()
        );
        tabunganButton.setOnAction(e -> {
            root.setCenter(
                TabunganScene.buildPage()
            );
        });
        wishlistButton.setOnAction(e -> {
            root.setCenter(
                WishlistScene.buildPage()
            );
        });
        // growthButton.setOnAction(e -> {
        //     root.setCenter(
        //         GrowthScene.buildPage()
        //     );
        // });

        Region spacer = new Region();
        VBox.setVgrow(spacer, Priority.ALWAYS);

        sidebar.getChildren().addAll(
            tabunganButton, wishlistButton, growthButton, spacer, logoutButton
        );
        return sidebar;
    }

    private static Button createMenuButton(String text) {
            Button button = new Button(text);

            button.setMaxWidth(Double.MAX_VALUE);
            button.setStyle("""
                -fx-background-color: transparent;
                -fx-text-fill: white;
                -fx-font-size: 14px;
                -fx-alignment: CENTER_LEFT;
                -fx-padding: 12 16;
                -fx-cursor: hand;
            """);

            return button;
    }
}
