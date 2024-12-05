package one.tranic.breedhorse;

import one.tranic.breedhorse.bstats.Metrics;
import one.tranic.breedhorse.event.BreadEvent;
import org.bukkit.event.Listener;
import org.bukkit.plugin.java.JavaPlugin;

public final class BreedHorse extends JavaPlugin implements Listener {
    Metrics metrics;

    @Override
    public void onEnable() {
        metrics = new Metrics(this, 24077);
        Config.load(this);
        getServer().getPluginManager().registerEvents(new BreadEvent(), this);
    }

    @Override
    public void onDisable() {
        if (metrics != null) {
            metrics.shutdown();
        }
    }
}
