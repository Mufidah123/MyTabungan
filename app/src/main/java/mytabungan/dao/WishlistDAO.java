package mytabungan.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import mytabungan.database.DatabaseConfig;
import mytabungan.models.Wishlist;

public class WishlistDAO {

    public Wishlist getWishlistByUserId(int userId) {
        String sql = "SELECT * FROM wishlists WHERE user_id = ? ORDER BY created_at DESC LIMIT 1";
        try (Connection conn = DatabaseConfig.connect();
        PreparedStatement ps = conn.prepareStatement(sql)) {
            ps.setInt(1, userId);
            ResultSet rs = ps.executeQuery();
            
            if (rs.next()) {
                return new Wishlist(
                    rs.getInt("id"),
                    rs.getInt("user_id"),
                    rs.getString("title"),
                    rs.getDouble("target_price"),
                    rs.getDouble("saved_amount"),
                    rs.getDouble("max_limit"),
                    rs.getString("status"),
                    rs.getString("period"),
                    rs.getTimestamp("created_at").toLocalDateTime()
                );
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }
}