package vb.$virtualspawnner;
import java.io.*;
import java.nio.file.*;
import java.util.*;
import org.bukkit.*;
import org.bukkit.command.*;
import org.bukkit.event.*;
import org.bukkit.plugin.java.*;

public class PluginMain extends JavaPlugin implements Listener {

	private static PluginMain instance;

	public static java.util.regex.Pattern HEX_PATTERN = java.util.regex.Pattern
			.compile("#([A-Fa-f0-9])([A-Fa-f0-9])([A-Fa-f0-9])([A-Fa-f0-9])([A-Fa-f0-9])([A-Fa-f0-9])");

	@Override
	public void onEnable() {
		instance = this;
		getServer().getPluginManager().registerEvents(this, this);
		try {
			((org.bukkit.command.CommandSender) (Object) ((org.bukkit.command.ConsoleCommandSender) org.bukkit.Bukkit
					.getConsoleSender())).sendMessage(ChatColor.translateAlternateColorCodes('&',
							PluginMain.HEX_PATTERN
									.matcher((((((((((((((((((((((((((((((((String.valueOf('\n')
											+ "  ______ ______ ______ ______ ______  ") + String.valueOf('\n'))
											+ " |______|______|______|______|______|") + String.valueOf('\n'))
											+ " _   _ _      _               _ ") + String.valueOf('\n'))
											+ "| | | (_)    | |             | |") + String.valueOf('\n'))
											+ "| | | |_ _ __| |_ _   _  __ _| |") + String.valueOf('\n'))
											+ "| | | | | '__| __| | | |/ _` | |") + String.valueOf('\n'))
											+ "\\ \\_/ / | |  | |_| |_| | (_| | |") + String.valueOf('\n'))
											+ " \\___/|_|_|   \\__|\\__,_|\\__,_|_|") + String.valueOf('\n'))
											+ "  ____                                       ") + String.valueOf('\n'))
											+ " / ___| _ __   __ ___      ___ __   ___ _ __ ") + String.valueOf('\n'))
											+ " \\___ \\| '_ \\ / _` \\ \\ /\\ / / '_ \\ / _ \\ '__|")
											+ String.valueOf('\n')) + "  ___) | |_) | (_| |\\ V  V /| | | |  __/ |   ")
											+ String.valueOf('\n'))
											+ " |____/| .__/ \\__,_| \\_/\\_/ |_| |_|\\___|_|   ")
											+ String.valueOf('\n')) + "       |_|                                   ")
											+ String.valueOf('\n'))
											+ ((((String.valueOf('\n') + "  ______ ______ ______ ______ ______  ")
													+ String.valueOf('\n')) + " |______|______|______|______|______|")
													+ String.valueOf('\n')))
											+ "version ") + PluginMain.getInstance().getDescription().getVersion()))
									.replaceAll("&x&$1&$2&$3&$4&$5&$6")));
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	@Override
	public void onDisable() {
	}

	@Override
	public boolean onCommand(CommandSender commandSender, Command command, String label, String[] commandArgs) {
		if (command.getName().equalsIgnoreCase("virtualspawner")) {
			try {
				if (PluginMain.checkEquals((commandArgs.length > ((int) (0d)) ? commandArgs[((int) (0d))] : null),
						"help")) {
					commandSender.sendMessage(ChatColor.translateAlternateColorCodes('&',
							PluginMain.HEX_PATTERN
									.matcher((((((String.valueOf('\n') + "/vs help -- show help message ")
											+ String.valueOf('\n')) + "/vs give -- Give Spawner")
											+ String.valueOf('\n')) + "/vs reload -- reload the plugin"))
									.replaceAll("&x&$1&$2&$3&$4&$5&$6")));
				}
				if (PluginMain.checkEquals((commandArgs.length > ((int) (0d)) ? commandArgs[((int) (0d))] : null),
						"give")) {
					((org.bukkit.inventory.Inventory) ((org.bukkit.inventory.InventoryHolder) (Object) commandSender)
							.getInventory())
									.addItem(((org.bukkit.inventory.ItemStack[]) new ArrayList(
											Arrays.asList(PluginMain.getNamedItem(
													((org.bukkit.Material) org.bukkit.Material.LEGACY_MOB_SPAWNER),
													"specialspawner")))
															.toArray(new org.bukkit.inventory.ItemStack[]{})));
				}
			} catch (Exception e) {
				e.printStackTrace();
			}
			return true;
		}
		return true;
	}

	public static void procedure(String procedure, List procedureArgs) throws Exception {
	}

	public static Object function(String function, List functionArgs) throws Exception {
		return null;
	}

	public static List createList(Object obj) {
		if (obj instanceof List) {
			return (List) obj;
		}
		List list = new ArrayList<>();
		if (obj.getClass().isArray()) {
			int length = java.lang.reflect.Array.getLength(obj);
			for (int i = 0; i < length; i++) {
				list.add(java.lang.reflect.Array.get(obj, i));
			}
		} else if (obj instanceof Collection<?>) {
			list.addAll((Collection<?>) obj);
		} else if (obj instanceof Iterator) {
			((Iterator<?>) obj).forEachRemaining(list::add);
		} else {
			list.add(obj);
		}
		return list;
	}

	public static void createResourceFile(String path) {
		Path file = getInstance().getDataFolder().toPath().resolve(path);
		if (Files.notExists(file)) {
			try (InputStream inputStream = PluginMain.class.getResourceAsStream("/" + path)) {
				Files.createDirectories(file.getParent());
				Files.copy(inputStream, file);
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}

	public static PluginMain getInstance() {
		return instance;
	}

	@EventHandler(priority = EventPriority.NORMAL)
	public void event1(org.bukkit.event.server.TabCompleteEvent event) throws Exception {
		event.setCompletions(new ArrayList(Arrays.asList("give")));
	}

	@EventHandler(priority = EventPriority.NORMAL)
	public void event2(org.bukkit.event.block.BlockPlaceEvent event) throws Exception {
		((org.bukkit.command.CommandSender) (Object) ((org.bukkit.entity.Player) event.getPlayer()))
				.sendMessage(String.valueOf(
						((org.bukkit.inventory.meta.ItemMeta) ((org.bukkit.inventory.ItemStack) (Object) ((java.lang.String) ((org.bukkit.inventory.meta.ItemMeta) (Object) ((org.bukkit.block.Block) event
								.getBlock())).getDisplayName())).getItemMeta())));
	}

	public static org.bukkit.inventory.ItemStack getNamedItem(Material material, String name) {
		org.bukkit.inventory.ItemStack item = new org.bukkit.inventory.ItemStack(material);
		org.bukkit.inventory.meta.ItemMeta itemMeta = item.getItemMeta();
		if (itemMeta != null) {
			itemMeta.setDisplayName(name);
			item.setItemMeta(itemMeta);
		}
		return item;
	}

	public static boolean checkEquals(Object o1, Object o2) {
		if (o1 == null || o2 == null) {
			return false;
		}
		return o1 instanceof Number && o2 instanceof Number
				? ((Number) o1).doubleValue() == ((Number) o2).doubleValue()
				: o1.equals(o2);
	}
}
