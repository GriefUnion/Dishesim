package me.griefunion.dishesim.modules;

import me.griefunion.dishesim.DishesimAddon;
import meteordevelopment.meteorclient.events.world.TickEvent;
import meteordevelopment.meteorclient.systems.modules.Module;
import meteordevelopment.orbit.EventHandler;
import net.minecraft.network.packet.c2s.play.VehicleMoveC2SPacket;

public class TestModule extends Module {
    public TestModule() {
        super(DishesimAddon.CATEGORY, "test", "Just a test module.");
    }

    @EventHandler
    private void onTick(TickEvent.Post event) {
        mc.player.getVehicle().setVelocity(0, 0, 0);
        for (int i = 0; i < 4; i++) {
            mc.player.getVehicle().updatePosition(
                    mc.player.getVehicle().getX(), mc.player.getVehicle().getY() + 20, mc.player.getVehicle().getZ());
            mc.player.networkHandler.sendPacket(new VehicleMoveC2SPacket(mc.player.getVehicle()));
        }
    }
}