package fr.Dianox.US.MainClass.config.global;

import java.io.File;
import java.io.IOException;

import org.bukkit.configuration.file.YamlConfiguration;
import org.bukkit.plugin.Plugin;

public class ConfigGProtection {

    private static Plugin pl;
    private static File file;
    private static YamlConfiguration Config;

    public ConfigGProtection() {}

    public static void loadConfig(Plugin plugin) {
        pl = plugin;

        file = new File(pl.getDataFolder(), "Config/Global/Server-Protection.yml");
        Config = YamlConfiguration.loadConfiguration(file);

        if (!pl.getDataFolder().exists()) {
            pl.getDataFolder().mkdir();
        }

        create();
    }

    public static File getFile() {
        return file;
    }

    public static YamlConfiguration getConfig() {
        return Config;
    }

    public static void reloadConfig() {
        loadConfig(pl);
    }

    public static void saveConfigFile() {
        try {
            Config.save(file);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static void create() {
        if (!file.exists()) {
            try {
                file.createNewFile();
            } catch (IOException e) {
                e.printStackTrace();
            }
            
            // Construct
            Config.set("Protection.Construct.Place.Enable", Boolean.valueOf(true));
            Config.set("Protection.Construct.Place.Bypass", Boolean.valueOf(true));
            Config.set("Protection.Construct.Place.Message", Boolean.valueOf(true));
            Config.set("Protection.Construct.Place.World.All_World", Boolean.valueOf(false));
            Config.set("Protection.Construct.Place.World.Worlds", java.util.Arrays.asList(new String[] {
                    "world",
                    "world_nether"
                }));
            
            Config.set("Protection.Construct.Break.Enable", Boolean.valueOf(true));
            Config.set("Protection.Construct.Break.Bypass", Boolean.valueOf(true));
            Config.set("Protection.Construct.Break.Message", Boolean.valueOf(true));
            Config.set("Protection.Construct.Break.World.All_World", Boolean.valueOf(false));
            Config.set("Protection.Construct.Break.World.Worlds", java.util.Arrays.asList(new String[] {
                    "world",
                    "world_nether"
                }));
            Config.set("Protection.HagingBreakByEntity.Enable", Boolean.valueOf(true));
            Config.set("Protection.HagingBreakByEntity.World.All_World", Boolean.valueOf(false));
            Config.set("Protection.HagingBreakByEntity.World.Worlds", java.util.Arrays.asList(new String[] {
                    "world",
                    "world_nether"
                }));
            Config.set("Protection.PlayerInteractEntity-ItemFrame.Enable", Boolean.valueOf(true));
            Config.set("Protection.PlayerInteractEntity-ItemFrame.World.All_World", Boolean.valueOf(false));
            Config.set("Protection.PlayerInteractEntity-ItemFrame.World.Worlds", java.util.Arrays.asList(new String[] {
                    "world",
                    "world_nether"
                }));
            
            saveConfigFile();

        }
    }
}
