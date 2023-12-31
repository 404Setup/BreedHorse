package stream.fset.plugin.breedhorse;

import org.bukkit.configuration.file.FileConfiguration;


public final class Config {

    public static double moveSpeedStr1;
    public static double moveSpeedStr2;
    public static double moveSpeedMax;
    public static double jumpStrengthStr1;
    public static double jumpStrengthStr2;
    public static double jumpStrengthMax;

    public static synchronized void load(BreedHorse plugin) {
        FileConfiguration config = plugin.getConfig();

        config.addDefault("moveSpeed.str1", 0.03);
        config.addDefault("moveSpeed.str2", 0.06);
        config.addDefault("moveSpeed.max", 0.3375);
        config.addDefault("jumpStrength.str1", 0.04);
        config.addDefault("jumpStrength.str2", 0.11);
        config.addDefault("jumpStrength.max", 1.0);
        config.options().copyDefaults(true);
        plugin.saveConfig();

        loadConfig(config);
    }

    private static synchronized void loadConfig(FileConfiguration config) {
        moveSpeedMax = config.getDouble("moveSpeed.max");
        moveSpeedStr1 = config.getDouble("moveSpeed.str1");
        moveSpeedStr2 = config.getDouble("moveSpeed.str2");

        jumpStrengthMax = config.getDouble("jumpStrength.max");
        jumpStrengthStr1 = config.getDouble("jumpStrength.str1");
        jumpStrengthStr2 = config.getDouble("jumpStrength.str2");
    }
}
