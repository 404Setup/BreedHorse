package one.tranic.breedhorse.config.mods;

public class DonkeyConfig extends HorseConfig {
    public DonkeyConfig(
            boolean enabled,
            double moveRandomMin, double moveRandomMax, double moveMax,
            double jumpRandomMin, double jumpRandomMax, double jumpMax
    ) {
        super(enabled, moveRandomMin, moveRandomMax, moveMax, jumpRandomMin, jumpRandomMax, jumpMax);
    }

    public DonkeyConfig() {
        super();
    }
}
