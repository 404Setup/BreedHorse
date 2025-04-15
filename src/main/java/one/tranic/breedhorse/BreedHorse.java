package one.tranic.breedhorse;

import one.tranic.breedhorse.bstats.Metrics;
import one.tranic.breedhorse.commands.BreedHorseCommand;
import one.tranic.breedhorse.event.BreadEvent;
import org.bukkit.Bukkit;
import org.bukkit.command.SimpleCommandMap;
import org.bukkit.event.Listener;
import org.bukkit.plugin.java.JavaPlugin;

import java.lang.reflect.Field;

public final class BreedHorse extends JavaPlugin implements Listener {
    private static FetchVersion fetchVersion;
    private static BreedHorse instance;
    private Metrics metrics;

    public static FetchVersion getFetchVersion() {
        return fetchVersion;
    }

    public static BreedHorse getInstance() {
        return instance;
    }

    @Override
    public void onEnable() {
        instance = this;
        fetchVersion = new FetchVersion(getDescription().getVersion());
        if (fetchVersion.checkForUpdates()) {
            getServer().getConsoleSender().sendMessage(fetchVersion.getUpdateMessage());
        }
        fetchVersion.run();

        metrics = new Metrics(this, 24077);
        Config.reload(this);
        getServer().getPluginManager().registerEvents(new BreadEvent(), this);

        try {
            Field commandMapField = Bukkit.getPluginManager().getClass().getDeclaredField("commandMap");
            commandMapField.setAccessible(true);
            SimpleCommandMap commandMap = (SimpleCommandMap) commandMapField.get(Bukkit.getPluginManager());

            commandMap.register("bhc", "breedhorse", new BreedHorseCommand(this));
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public void onDisable() {
        fetchVersion.stop();
        if (metrics != null) {
            metrics.shutdown();
        }
    }
}
