package mytabungan.dao;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import mytabungan.database.DatabaseConfig;
import mytabungan.models.MonthlySaving;

public class SavingDAO {
    // mengelola tabel "tabungan_utama" yang dapat dilihat pada file DBInitializer.java di folder Database
    // semua query SQL tabungan ada di sini

    public boolean createSaving(MonthlySaving saving) {
        String tabungan = "INSERT INTO tabungan_utama (user_id, target_amount, saved_amount, period_month) VALUES (?, ?, ?, ?)";
    
        try (Connection conn = DatabaseConfig.connect();
        PreparedStatement ps = conn.prepareStatement(tabungan)) {
            ps.setInt(1, saving.getUserId());
            ps.setDouble(2, saving.getTargetAmount());
            ps.setDouble(3, saving.getSavedAmount());
            ps.setString(4, saving.getPeriodMonth());
    
            return ps.executeUpdate() > 0;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return false;
    }

    public MonthlySaving getSavingByUserId(int userId) {
        String sql = "SELECT * FROM tabungan_utama WHERE user_id = ? ORDER BY created_at DESC LIMIT 1";

        try (Connection conn = DatabaseConfig.connect();
        PreparedStatement ps = conn.prepareStatement(sql)) {
            ps.setInt(1, userId);
            ResultSet rs = ps.executeQuery();

            if (rs.next()) {
                return new MonthlySaving(
                    rs.getInt("id"),
                    rs.getInt("user_id"),
                    rs.getDouble("target_amount"),
                    rs.getDouble("saved_amount"),
                    rs.getString("period_month"),
                    rs.getTimestamp("created_at").toLocalDateTime()
                );
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    public boolean updateSavingAmount(int savingId, double amount) {
        String sql = "UPDATE tabungan_utama SET saved_amount =saved_amount + ? WHERE id = ?";

        try (Connection conn = DatabaseConfig.connect();
        PreparedStatement ps = conn.prepareStatement(sql)) {
            ps.setDouble(1, amount);
            ps.setInt(2, savingId);

            return ps.executeUpdate() > 0;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return false;
    }

    public boolean resetTabungan(int savingId, String newPeriodMonth) {

        String sql = "UPDATE tabungan_utama SET saved_amount = 0, period_month = ? WHERE id = ?";
        try (Connection conn = DatabaseConfig.connect();
        PreparedStatement ps = conn.prepareStatement(sql)) {
            ps.setString(1, newPeriodMonth);
            ps.setInt(2, savingId);

            return ps.executeUpdate() > 0;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return false;
    }
}