package one.tranic.breedhorse.event;

import one.tranic.breedhorse.Config;
import org.bukkit.attribute.Attribute;
import org.bukkit.attribute.AttributeInstance;
import org.bukkit.entity.Horse;
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
    public void onHorseBreed(EntityBreedEvent event) {
        if (event.getEntity() instanceof Horse baby) {
            Horse horse1 = (Horse) event.getFather();
            Horse horse2 = (Horse) event.getMother();

            if (hasSameLevelEffect(horse1.getActivePotionEffects(), horse2.getActivePotionEffects(), PotionEffectType.SPEED)) {
                AttributeInstance attr = baby.getAttribute(Attribute.GENERIC_MOVEMENT_SPEED);
                if (attr != null) {
                    // default max speed: 0.3375
                    double moveSpeed = attr.getValue() + random.nextDouble(Config.moveSpeedStr1, Config.moveSpeedStr2);
                    if (moveSpeed <= Config.moveSpeedMax) attr.setBaseValue(moveSpeed);
                }
            }
            if (hasSameLevelEffect(horse1.getActivePotionEffects(), horse2.getActivePotionEffects(), PotionEffectType.JUMP)) {
                // default max jump strength: 1.0
                double jumpStrength = baby.getJumpStrength() + random.nextDouble(Config.jumpStrengthStr1, Config.jumpStrengthStr2);
                if (jumpStrength <= Config.jumpStrengthMax) baby.setJumpStrength(jumpStrength);
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
