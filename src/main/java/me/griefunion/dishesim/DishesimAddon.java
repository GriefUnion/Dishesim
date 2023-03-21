package me.griefunion.dishesim;

import com.mojang.logging.LogUtils;
import me.griefunion.dishesim.commands.TestCommand;
import me.griefunion.dishesim.modules.TestModule;
import meteordevelopment.meteorclient.addons.MeteorAddon;
import meteordevelopment.meteorclient.systems.commands.Commands;
import meteordevelopment.meteorclient.systems.modules.Category;
import meteordevelopment.meteorclient.systems.modules.Modules;
import org.slf4j.Logger;

public class DishesimAddon extends MeteorAddon {
    public static final Logger LOG = LogUtils.getLogger();
    public static final Category CATEGORY = new Category("Dishesim");

    @Override
    public void onInitialize() {
        LOG.info("Enabled Dishesim.");

        // Modules
        Modules.get().add(new TestModule());

        // Commands
        Commands.get().add(new TestCommand());
    }

    @Override
    public void onRegisterCategories() {
        Modules.registerCategory(CATEGORY);
    }

    @Override
    public String getPackage() {
        return "me.griefunion.dishesim";
    }
}