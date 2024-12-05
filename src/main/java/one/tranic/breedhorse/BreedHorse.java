package one.tranic.breedhorse;

import one.tranic.breedhorse.bstats.Metrics;
import one.tranic.breedhorse.event.BreadEvent;
import org.bukkit.event.Listener;
import org.bukkit.plugin.java.JavaPlugin;

public final class BreedHorse extends JavaPlugin implements Listener {
    Metrics metrics;
    FetchVersion fetchVersion;

    @Override
    public void onEnable() {
        fetchVersion = new FetchVersion(getDescription().getVersion());
        if (fetchVersion.checkForUpdates()) {
            getServer().getConsoleSender().sendMessage(fetchVersion.getUpdateMessage());
        }
        fetchVersion.run();

        metrics = new Metrics(this, 24077);
        Config.load(this);
        getServer().getPluginManager().registerEvents(new BreadEvent(), this);
    }

    @Override
    public void onDisable() {
        fetchVersion.stop();
        if (metrics != null) {
            metrics.shutdown();
        }
    }
}
