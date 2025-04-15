package one.tranic.breedhorse.config;

import one.tranic.breedhorse.BreedHorse;
import one.tranic.breedhorse.config.mods.*;
import org.bukkit.configuration.file.YamlConfiguration;

import java.io.File;
import java.io.IOException;
import java.nio.file.Path;

public final class Config {
    public static final PigConfig PIG_CONFIG = new PigConfig();
    public static final HorseConfig HORSE_CONFIG = new HorseConfig();
    public static final DonkeyConfig DONKEY_CONFIG = new DonkeyConfig();
    public static final MuleConfig MULE_CONFIG = new MuleConfig();
    public static final OtherConfig OTHER_CONFIG = new OtherConfig();
    private static File configFile;
    private static YamlConfiguration configuration;

    public static Path getConfigDirectory() {
        return BreedHorse.getInstance().getDataFolder().toPath();
    }

    public static synchronized void reload() {
        reload(false);
    }

    public static synchronized void reload(boolean save) {
        configFile = getConfigDirectory().resolve("BreedHorse").resolve("config.yml").toFile();
        try {
            if (!configFile.exists()) {
                if (!configFile.getParentFile().exists()) {
                    configFile.getParentFile().mkdir();
                }
                configFile.createNewFile();
            }
            configuration = YamlConfiguration.loadConfiguration(configFile);
            if (save)
                set();
            else save();
            read();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    private static synchronized void set() throws IOException {
        configuration.set("pig.enabled", PIG_CONFIG.isEnabled());
        configuration.set("pig.move.random.min", PIG_CONFIG.getMoveRandomMin());
        configuration.set("pig.move.random.max", PIG_CONFIG.getMoveRandomMax());
        configuration.set("pig.move.max", PIG_CONFIG.getMoveMax());

        configuration.set("horse.enabled", HORSE_CONFIG.isEnabled());
        configuration.set("horse.move.random.min", HORSE_CONFIG.getMoveRandomMin());
        configuration.set("horse.move.random.max", HORSE_CONFIG.getMoveRandomMax());
        configuration.set("horse.move.max", HORSE_CONFIG.getMoveMax());
        configuration.set("horse.jump.random.min", HORSE_CONFIG.getJumpRandomMin());
        configuration.set("horse.jump.random.max", HORSE_CONFIG.getJumpRandomMax());
        configuration.set("horse.jump.max", HORSE_CONFIG.getJumpMax());

        configuration.set("donkey.enabled", DONKEY_CONFIG.isEnabled());
        configuration.set("donkey.move.random.min", DONKEY_CONFIG.getMoveRandomMin());
        configuration.set("donkey.move.random.max", DONKEY_CONFIG.getMoveRandomMax());
        configuration.set("donkey.move.max", DONKEY_CONFIG.getMoveMax());
        configuration.set("donkey.jump.random.min", DONKEY_CONFIG.getJumpRandomMin());
        configuration.set("donkey.jump.random.max", DONKEY_CONFIG.getJumpRandomMax());
        configuration.set("donkey.jump.max", DONKEY_CONFIG.getJumpMax());

        configuration.set("mule.enabled", MULE_CONFIG.isEnabled());
        configuration.set("mule.move.random.min", MULE_CONFIG.getMoveRandomMin());
        configuration.set("mule.move.random.max", MULE_CONFIG.getMoveRandomMax());
        configuration.set("mule.move.max", MULE_CONFIG.getMoveMax());
        configuration.set("mule.jump.random.min", MULE_CONFIG.getJumpRandomMin());
        configuration.set("mule.jump.random.max", MULE_CONFIG.getJumpRandomMax());
        configuration.set("mule.jump.max", MULE_CONFIG.getJumpMax());

        configuration.set("other.mixed-properties", OTHER_CONFIG.isMixedProperties());

        //configuration.options().copyDefaults(true);
        configuration.save(configFile);
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

        configuration.addDefault("donkey.enabled", true);
        configuration.addDefault("donkey.move.random.min", 0.03);
        configuration.addDefault("donkey.move.random.max", 0.06);
        configuration.addDefault("donkey.move.max", 0.3375);
        configuration.addDefault("donkey.jump.random.min", 0.04);
        configuration.addDefault("donkey.jump.random.max", 0.11);
        configuration.addDefault("donkey.jump.max", 1.0);

        configuration.addDefault("mule.enabled", true);
        configuration.addDefault("mule.move.random.min", 0.03);
        configuration.addDefault("mule.move.random.max", 0.06);
        configuration.addDefault("mule.move.max", 0.3375);
        configuration.addDefault("mule.jump.random.min", 0.04);
        configuration.addDefault("mule.jump.random.max", 0.11);
        configuration.addDefault("mule.jump.max", 1.0);

        configuration.options().copyDefaults(true);
        configuration.save(configFile);
    }

    private static synchronized void read() {
        PIG_CONFIG.setEnabled(configuration.getBoolean("pig.enabled"));
        PIG_CONFIG.setMoveRandomMin(configuration.getDouble("pig.move.random.min"));
        PIG_CONFIG.setMoveRandomMax(configuration.getDouble("pig.move.random.max"));
        PIG_CONFIG.setMoveMax(configuration.getDouble("pig.move.max"));

        HORSE_CONFIG.setEnabled(configuration.getBoolean("horse.enabled"));
        HORSE_CONFIG.setMoveRandomMin(configuration.getDouble("horse.move.random.min"));
        HORSE_CONFIG.setMoveRandomMax(configuration.getDouble("horse.move.random.max"));
        HORSE_CONFIG.setMoveMax(configuration.getDouble("horse.move.max"));
        HORSE_CONFIG.setJumpRandomMin(configuration.getDouble("horse.jump.random.min"));
        HORSE_CONFIG.setJumpRandomMax(configuration.getDouble("horse.jump.random.max"));
        HORSE_CONFIG.setJumpMax(configuration.getDouble("horse.jump.max"));

        DONKEY_CONFIG.setEnabled(configuration.getBoolean("donkey.enabled"));
        DONKEY_CONFIG.setMoveRandomMin(configuration.getDouble("donkey.move.random.min"));
        DONKEY_CONFIG.setMoveRandomMax(configuration.getDouble("donkey.move.random.max"));
        DONKEY_CONFIG.setMoveMax(configuration.getDouble("donkey.move.max"));
        DONKEY_CONFIG.setJumpRandomMin(configuration.getDouble("donkey.jump.random.min"));
        DONKEY_CONFIG.setJumpRandomMax(configuration.getDouble("donkey.jump.random.max"));
        DONKEY_CONFIG.setJumpMax(configuration.getDouble("donkey.jump.max"));

        MULE_CONFIG.setEnabled(configuration.getBoolean("mule.enabled"));
        MULE_CONFIG.setMoveRandomMin(configuration.getDouble("mule.move.random.min"));
        MULE_CONFIG.setMoveRandomMax(configuration.getDouble("mule.move.random.max"));
        MULE_CONFIG.setMoveMax(configuration.getDouble("mule.move.max"));
        MULE_CONFIG.setJumpRandomMin(configuration.getDouble("mule.jump.random.min"));
        MULE_CONFIG.setJumpRandomMax(configuration.getDouble("mule.jump.random.max"));
        MULE_CONFIG.setJumpMax(configuration.getDouble("mule.jump.max"));

        OTHER_CONFIG.setMixedProperties(configuration.getBoolean("other.mixed-properties"));
    }
}
