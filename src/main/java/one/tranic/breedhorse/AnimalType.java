package one.tranic.breedhorse;

import one.tranic.breedhorse.config.Config;
import org.bukkit.entity.*;

public enum AnimalType {
    HORSE(0) {
        @Override
        public boolean isEnabled() {
            return Config.HORSE_CONFIG.isEnabled();
        }
    },
    DONKEY(1) {
        @Override
        public boolean isEnabled() {
            return Config.DONKEY_CONFIG.isEnabled();
        }
    },
    MULE(2) {
        @Override
        public boolean isEnabled() {
            return Config.MULE_CONFIG.isEnabled();
        }
    },
    PIG(3) {
        @Override
        public boolean isEnabled() {
            return Config.PIG_CONFIG.isEnabled();
        }
    },
    UNKNOWN(-1) {
        @Override
        public boolean isEnabled() {
            return false;
        }
    };

    private final int value;

    AnimalType(int value) {
        this.value = value;
    }

    public int getValue() {
        return value;
    }

    public abstract boolean isEnabled();

    public static AnimalType fromEntity(Entity entity) {
        if (entity instanceof Horse) return HORSE;
        if (entity instanceof Donkey) return DONKEY;
        if (entity instanceof Mule) return MULE;
        if (entity instanceof Pig) return PIG;
        return UNKNOWN;
    }
}
