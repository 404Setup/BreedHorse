package one.tranic.breedhorse.commands;

import one.tranic.breedhorse.BreedHorse;
import one.tranic.breedhorse.Config;
import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.plugin.java.JavaPlugin;
import org.jetbrains.annotations.NotNull;

import java.util.ArrayList;
import java.util.List;

public class BreedHorseCommand extends Command {
    private final JavaPlugin plugin;
    private final String permissionMessage = ChatColor.AQUA + "[BreedHorse] " + ChatColor.RED + "You don't have permission to use this command!";

    public BreedHorseCommand(JavaPlugin plugin) {
        super("bhc");
        this.plugin = plugin;
        this.setUsage("/bhc <reload|version>");
    }

    private String getUsageMessage() {
        return ChatColor.AQUA + "[BreedHorse] " + ChatColor.RED + "Usage: " + this.getUsage();
    }

    @Override
    public boolean execute(@NotNull CommandSender sender, @NotNull String commandLabel, String[] args) {
        if (args.length == 0) {
            sender.sendMessage(getUsageMessage());
            return true;
        }
        if (args[0].equalsIgnoreCase("reload")) {
            executeReload(sender);
            return true;
        }
        if (args[0].equalsIgnoreCase("version")) {
            executeVersion(sender);
            return true;
        }
        sender.sendMessage(getUsageMessage());
        return true;
    }

    private void executeReload(@NotNull CommandSender sender) {
        if (!sender.hasPermission("breedhorse.command.reload")) {
            sender.sendMessage(permissionMessage);
            return;
        }
        Config.reload(this.plugin);
        sender.sendMessage(ChatColor.AQUA + "[BreedHorse] " + ChatColor.GREEN + "The configuration file has been reloaded. Some changes require reloading the plugin or restarting the server to take effect.");
    }

    private void executeVersion(@NotNull CommandSender sender) {
        if (!sender.hasPermission("breedhorse.command.version")) {
            sender.sendMessage(permissionMessage);
            return;
        }
        if (BreedHorse.getFetchVersion().checkForUpdates()) sender.sendMessage(BreedHorse.getFetchVersion().getUpdateMessage());
        else sender.sendMessage(BreedHorse.getFetchVersion().getNoUpdateMessage());
    }

    @Override
    public @NotNull List<String> tabComplete(@NotNull CommandSender sender, @NotNull String alias, @NotNull String[] args) {
        List<String> list = new ArrayList<>();
        if (args.length == 1) {
            if (sender.hasPermission("breedhorse.command.reload")) list.add("reload");
            if (sender.hasPermission("breedhorse.command.version")) list.add("version");
        }
        return list;
    }
}
