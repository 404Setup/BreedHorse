package one.tranic.breedhorse.config.mods;

public class MuleConfig extends HorseConfig {
    public MuleConfig(
            boolean enabled,
            double moveRandomMin, double moveRandomMax, double moveMax,
            double jumpRandomMin, double jumpRandomMax, double jumpMax
    ) {
        super(enabled, moveRandomMin, moveRandomMax, moveMax, jumpRandomMin, jumpRandomMax, jumpMax);
    }

    public MuleConfig() {
        super();
    }
}
