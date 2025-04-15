package one.tranic.breedhorse.config.mods;

public class PigConfig {
    private boolean enabled;
    private double moveRandomMin;
    private double moveRandomMax;
    private double moveMax;

    public PigConfig() {
        this(true, 0.03, 0.06, 0.3375);
    }

    public PigConfig(boolean enabled, double moveRandomMin, double moveRandomMax, double moveMax) {
        this.enabled = enabled;
        this.moveRandomMin = moveRandomMin;
        this.moveRandomMax = moveRandomMax;
        this.moveMax = moveMax;
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
}
