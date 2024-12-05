package one.tranic.breedhorse;

import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.plugin.java.JavaPlugin;


public final class Config {
    private static boolean PigEnabled;
    private static double PigMoveRandomMin;
    private static double PigMoveRandomMax;
    private static double PigMoveMax;

    private static boolean HorseEnabled;
    private static double HorseMoveRandomMin;
    private static double HorseMoveRandomMax;
    private static double HorseMoveMax;
    private static double HorseJumpRandomMin;
    private static double HorseJumpRandomMax;
    private static double HorseJumpMax;

    public static boolean isPigEnabled() {
        return PigEnabled;
    }

    public static boolean isHorseEnabled() {
        return HorseEnabled;
    }

    public static double getPigMoveRandomMin() {
        return PigMoveRandomMin;
    }

    public static double getPigMoveRandomMax() {
        return PigMoveRandomMax;
    }

    public static double getPigMoveMax() {
        return PigMoveMax;
    }

    public static double getHorseMoveRandomMin() {
        return HorseMoveRandomMin;
    }

    public static double getHorseMoveRandomMax() {
        return HorseMoveRandomMax;
    }

    public static double getHorseMoveMax() {
        return HorseMoveMax;
    }

    public static double getHorseJumpRandomMin() {
        return HorseJumpRandomMin;
    }

    public static double getHorseJumpRandomMax() {
        return HorseJumpRandomMax;
    }

    public static double getHorseJumpMax() {
        return HorseJumpMax;
    }

    public static synchronized void load(JavaPlugin plugin) {
        FileConfiguration config = plugin.getConfig();

        config.addDefault("pig.enabled", true);
        config.addDefault("pig.move.random.min", 0.03);
        config.addDefault("pig.move.random.max", 0.06);
        config.addDefault("pig.move.max", 0.3375);

        config.addDefault("horse.enabled", true);
        config.addDefault("horse.move.random.min", 0.03);
        config.addDefault("horse.move.random.max", 0.06);
        config.addDefault("horse.move.max", 0.3375);
        config.addDefault("horse.jump.random.min", 0.04);
        config.addDefault("horse.jump.random.max", 0.11);
        config.addDefault("horse.jump.max", 1.0);

        config.options().copyDefaults(true);
        plugin.saveConfig();

        loadConfig(config);
    }

    private static synchronized void loadConfig(FileConfiguration config) {
        PigEnabled = config.getBoolean("pig.enabled", true);
        PigMoveRandomMin = config.getDouble("pig.move.random.min", 0.03);
        PigMoveRandomMax = config.getDouble("pig.move.random.max", 0.06);
        PigMoveMax = config.getDouble("pig.move.max", 0.3375);

        HorseEnabled = config.getBoolean("horse.enabled", true);
        HorseMoveRandomMin = config.getDouble("horse.move.random.min", 0.03);
        HorseMoveRandomMax = config.getDouble("horse.move.random.max", 0.06);
        HorseMoveMax = config.getDouble("horse.move.max", 0.3375);
        HorseJumpRandomMin = config.getDouble("horse.jump.random.min", 0.04);
        HorseJumpRandomMax = config.getDouble("horse.jump.random.max", 0.11);
        HorseJumpMax = config.getDouble("horse.jump.max", 1.0);
    }
}
