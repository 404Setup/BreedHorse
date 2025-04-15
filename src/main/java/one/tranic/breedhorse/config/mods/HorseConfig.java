package one.tranic.breedhorse.config.mods;

public class HorseConfig {
    private boolean enabled;
    private double moveRandomMin;
    private double moveRandomMax;
    private double moveMax;

    private double jumpRandomMin;
    private double jumpRandomMax;
    private double jumpMax;

    public HorseConfig() {
        this(
                true,
                0.03, 0.06, 0.3375,
                0.03, 0.06, 0.3375
        );
    }

    public HorseConfig(
            boolean enabled,
            double moveRandomMin, double moveRandomMax, double moveMax,
            double jumpRandomMin, double jumpRandomMax, double jumpMax
    ) {
        this.enabled = enabled;
        this.moveRandomMin = moveRandomMin;
        this.moveRandomMax = moveRandomMax;
        this.moveMax = moveMax;

        this.jumpRandomMin = jumpRandomMin;
        this.jumpRandomMax = jumpRandomMax;
        this.jumpMax = jumpMax;
    }

    public boolean isEnabled() {
        return enabled;
    }

    public void setEnabled(boolean enabled) {
        this.enabled = enabled;
    }

    public double getMoveRandomMin() {
        return moveRandomMin;
    }

    public void setMoveRandomMin(double moveRandomMin) {
        if (moveRandomMin > 0 && moveRandomMin < 20.0000 && moveRandomMin <= moveRandomMax)
            this.moveRandomMin = moveRandomMin;
    }

    public double getMoveRandomMax() {
        return moveRandomMax;
    }

    public void setMoveRandomMax(double moveRandomMax) {
        if (moveRandomMax > 0 && moveRandomMax < 20.00 && moveRandomMax >= moveRandomMin)
            this.moveRandomMax = moveRandomMax;
    }

    public double getMoveMax() {
        return moveMax;
    }

    public void setMoveMax(double moveMax) {
        if (moveMax > 0 && moveMax < 20.0000)
            this.moveMax = moveMax;
    }

    public double getJumpRandomMin() {
        return jumpRandomMin;
    }

    public void setJumpRandomMin(double jumpRandomMin) {
        if (jumpRandomMin > 0 && jumpRandomMin < 20.0000 && jumpRandomMin <= jumpRandomMax)
            this.jumpRandomMin = jumpRandomMin;
    }

    public double getJumpRandomMax() {
        return jumpRandomMax;
    }

    public void setJumpRandomMax(double jumpRandomMax) {
        if (jumpRandomMax > 0 && jumpRandomMax < 20.00 && jumpRandomMax >= jumpRandomMin)
            this.jumpRandomMax = jumpRandomMax;
    }

    public double getJumpMax() {
        return jumpMax;
    }

    public void setJumpMax(double jumpMax) {
        if (jumpMax > 0 && jumpMax < 20.0000)
            this.jumpMax = jumpMax;
    }
}
