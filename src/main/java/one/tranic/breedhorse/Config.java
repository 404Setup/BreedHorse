package one.tranic.breedhorse;

import org.bukkit.configuration.file.YamlConfiguration;
import org.bukkit.plugin.java.JavaPlugin;

import java.io.File;
import java.io.IOException;


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
    private static File configFile;
    private static YamlConfiguration configuration;

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

    public static synchronized void reload(JavaPlugin plugin) {
        configFile = plugin.getDataFolder().toPath().getParent().resolve("BreedHorse").resolve("config.yml").toFile();
        try {
            if (!configFile.exists()) {
                if (!configFile.getParentFile().exists()) {
                    configFile.getParentFile().mkdir();
                }
                configFile.createNewFile();
            }
            configuration = YamlConfiguration.loadConfiguration(configFile);
            save();
            read();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    private static synchronized void save() throws IOException {
        configuration.addDefault("pig.enabled", true);
        configuration.addDefault("pig.move.random.min", 0.03);
        configuration.addDefault("pig.move.random.max", 0.06);
        configuration.addDefault("pig.move.max", 0.3375);

        configuration.addDefault("horse.enabled", true);
        configuration.addDefault("horse.move.random.min", 0.03);
        configuration.addDefault("horse.move.random.max", 0.06);
        configuration.addDefault("horse.move.max", 0.3375);
        configuration.addDefault("horse.jump.random.min", 0.04);
        configuration.addDefault("horse.jump.random.max", 0.11);
        configuration.addDefault("horse.jump.max", 1.0);

        configuration.options().copyDefaults(true);
        configuration.save(configFile);
    }

    private static synchronized void read() {
        PigEnabled = configuration.getBoolean("pig.enabled");
        PigMoveRandomMin = configuration.getDouble("pig.move.random.min");
        PigMoveRandomMax = configuration.getDouble("pig.move.random.max");
        PigMoveMax = configuration.getDouble("pig.move.max");

        HorseEnabled = configuration.getBoolean("horse.enabled");
        HorseMoveRandomMin = configuration.getDouble("horse.move.random.min");
        HorseMoveRandomMax = configuration.getDouble("horse.move.random.max");
        HorseMoveMax = configuration.getDouble("horse.move.max");
        HorseJumpRandomMin = configuration.getDouble("horse.jump.random.min");
        HorseJumpRandomMax = configuration.getDouble("horse.jump.random.max");
        HorseJumpMax = configuration.getDouble("horse.jump.max");
    }
}
