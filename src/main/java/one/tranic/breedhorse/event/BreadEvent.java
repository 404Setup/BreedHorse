package one.tranic.breedhorse.event;

import one.tranic.breedhorse.Config;
import org.bukkit.attribute.Attribute;
import org.bukkit.attribute.AttributeInstance;
import org.bukkit.entity.Horse;
import org.bukkit.entity.Pig;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntityBreedEvent;
import org.bukkit.potion.PotionEffect;
import org.bukkit.potion.PotionEffectType;

import java.util.Collection;
import java.util.concurrent.ThreadLocalRandom;

public class BreadEvent implements Listener {
    ThreadLocalRandom random = ThreadLocalRandom.current();

    @EventHandler
    public void onEntityBreed(EntityBreedEvent event) {
        if (event.getEntity() instanceof Horse baby) {
            if (!Config.isHorseEnabled()) return;
            setHorseValue((Horse) event.getFather(), (Horse) event.getMother(), baby);
            return;
        }

        if (event.getEntity() instanceof Pig baby) {
            if (!Config.isPigEnabled()) return;
            setPigValue((Pig) event.getFather(), (Pig) event.getMother(), baby);
        }
    }

    void setHorseValue(Horse father, Horse mother, Horse baby) {
        if (hasSameLevelEffect(father.getActivePotionEffects(), mother.getActivePotionEffects(), PotionEffectType.SPEED)) {
            AttributeInstance attr = baby.getAttribute(Attribute.GENERIC_MOVEMENT_SPEED);
            if (attr != null) {
                // default max speed: 0.3375
                double moveSpeed = attr.getValue() + random.nextDouble(Config.getHorseMoveRandomMin(), Config.getHorseMoveRandomMax());
                if (moveSpeed <= Config.getHorseMoveMax()) attr.setBaseValue(moveSpeed);
            }
        }
        if (hasSameLevelEffect(father.getActivePotionEffects(), mother.getActivePotionEffects(), PotionEffectType.JUMP)) {
            // default max jump strength: 1.0
            double jumpStrength = baby.getJumpStrength() + random.nextDouble(Config.getHorseJumpRandomMin(), Config.getHorseJumpRandomMax());
            if (jumpStrength <= Config.getHorseJumpMax()) baby.setJumpStrength(jumpStrength);
        }
    }

    void setPigValue(Pig father, Pig mother, Pig baby) {
        if (hasSameLevelEffect(father.getActivePotionEffects(), mother.getActivePotionEffects(), PotionEffectType.SPEED)) {
            AttributeInstance attr = baby.getAttribute(Attribute.GENERIC_MOVEMENT_SPEED);
            if (attr != null) {
                // default max speed: 0.3375
                double moveSpeed = attr.getValue() + random.nextDouble(Config.getPigMoveRandomMin(), Config.getPigMoveRandomMax());
                if (moveSpeed <= Config.getPigMoveMax()) attr.setBaseValue(moveSpeed);
            }
        }
    }

    boolean hasSameLevelEffect(Collection<PotionEffect> effects1, Collection<PotionEffect> effects2, PotionEffectType type) {
        return hasEffect(effects1, type) &&
                hasEffect(effects2, type) &&
                getEffectLevel(effects1, type) == getEffectLevel(effects2, type);
    }

    int getEffectLevel(Collection<PotionEffect> effects, PotionEffectType type) {
        for (PotionEffect effect : effects) {
            if (effect.getType() == type) return effect.getAmplifier();
        }
        return -1;
    }

    boolean hasEffect(Collection<PotionEffect> effects, PotionEffectType type) {
        return getEffectLevel(effects, type) != -1;
    }
}
