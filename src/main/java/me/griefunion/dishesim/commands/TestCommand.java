package me.griefunion.dishesim.commands;

import com.mojang.brigadier.builder.LiteralArgumentBuilder;
import meteordevelopment.meteorclient.systems.commands.Command;
import net.minecraft.command.CommandSource;
import net.minecraft.network.packet.c2s.play.PlayerMoveC2SPacket;

import java.util.Random;

import static com.mojang.brigadier.Command.SINGLE_SUCCESS;

public class TestCommand extends Command {
    private final Random random = new Random();

    public TestCommand() {
        super("test", "Just a test command.");
    }

    @Override
    public void build(LiteralArgumentBuilder<CommandSource> builder) {
        builder.executes(context -> {
            for (int i = 0; i < 200; i++)
                mc.player.networkHandler.sendPacket(
                        new PlayerMoveC2SPacket.LookAndOnGround(Float.MAX_VALUE, Float.MIN_VALUE, random.nextBoolean()));
            return SINGLE_SUCCESS;
        });
    }
}