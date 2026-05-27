package mytabungan.models;

import java.time.LocalDateTime;

public class MonthlySaving extends Saving {
    
    private String periodMonth;
    
    public MonthlySaving(int id,
                        int userId,
                        double targetAmount,
                        double savedAmount,
                        String periodMonth,
                        LocalDateTime createdAt) {

        super(id, userId, targetAmount, savedAmount, createdAt);

        this.periodMonth = periodMonth;
    }

    public String getPeriodMonth() {
        return periodMonth;
    }

    // Cek sudah tercapai atau belum targetnya
    @Override
    public boolean isReached() {
        return getSavedAmount() >= getTargetAmount();
    }

    public double getRemainingSaving(double allocationAmount) {
        return savedAmount - allocationAmount;
    }

    // Persentase (opsional)
    public double getProgressPercentage() {
        if (targetAmount == 0) {
            return 0;
        }
        return (savedAmount / targetAmount) * 100;
    }
}

