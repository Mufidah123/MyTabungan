package mytabungan.scenes;

import javafx.scene.control.Label;
import javafx.scene.layout.VBox;

public class WishlistScene {
    public static VBox buildPage() {
        return new VBox(
            new Label("Wishlist")
        );
    }
}