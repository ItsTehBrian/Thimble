package xyz.tehbrian.maventehplugin.commands;

import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import xyz.tehbrian.maventehplugin.MavenTehPlugin;
import xyz.tehbrian.maventehplugin.util.MsgBuilder;

public class TestCommand implements CommandExecutor {

    private final MavenTehPlugin main;

    public TestCommand(MavenTehPlugin main) {
        this.main = main;
    }

    @Override
    public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
        sender.sendMessage(new MsgBuilder().def("msg.test").formats(sender.getName()).build());
        return true;
    }
}


