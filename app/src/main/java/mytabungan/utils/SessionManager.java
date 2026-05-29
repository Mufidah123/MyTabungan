package mytabungan.utils;

import mytabungan.models.User;

public class SessionManager {
    private static User currentUser;

    // User yang sekarang sedang aktif
    public static void login(User user) {
        currentUser = user;
    }

    // Getter user aktif
    public static User getCurrentUser() {
        return currentUser;
    }

    // Getter ID user aktif
    public static int getCurrentUserId() {
        if (currentUser == null) {
            throw new IllegalStateException("User belum login!");
        }
        return currentUser.getId();
    }

    public static boolean isLoggedIn() {
        return currentUser != null;
    }

    public static void logout() {
        currentUser = null;
    }
}