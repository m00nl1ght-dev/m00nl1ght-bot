package dev.m00nl1ght.bot.commands.core;

import dev.m00nl1ght.bot.CommandParser;
import dev.m00nl1ght.bot.MainListener;

public class CoreMaintanance {

    public static void register(CoreCommand core) {
        core.addSubCommand(new Stop(core.parent, "stop"));
        core.addSubCommand(new Start(core.parent, "start"));
        core.addSubCommand(new Save(core.parent, "save"));
        core.addSubCommand(new Reload(core.parent, "reload"));
        core.addSubCommand(new Exit(core.parent, "exit"));
        core.addSubCommand(new Backup(core.parent, "backup"));
    }

    static class Stop extends CoreSubCommand {

        protected Stop(MainListener parent, String name) {
            super(parent, name);
        }

        @Override
        public void execute(CommandParser parser) {
            if (parent.isActive()) {
                parent.setActive(false);
                parser.sendResponse("Stopped.");
            } else {
                parser.sendResponse("The bot is already stopped.");
            }
        }

    }

    static class Start extends CoreSubCommand {

        protected Start(MainListener parent, String name) {
            super(parent, name);
        }

        @Override
        public void execute(CommandParser parser) {
            if (parent.isActive()) {
                parser.sendResponse("The bot is already active.");
            } else {
                parent.setActive(true);
                parser.sendResponse("Started.");
            }
        }

    }

    static class Save extends CoreSubCommand {

        protected Save(MainListener parent, String name) {
            super(parent, name);
        }

        @Override
        public void execute(CommandParser parser) {
            parser.sendResponse("Saving resources...");
            parent.save();
        }

    }

    static class Reload extends CoreSubCommand {

        protected Reload(MainListener parent, String name) {
            super(parent, name);
        }

        @Override
        public void execute(CommandParser parser) {
            parser.sendResponse("Reloading resources...");
            parent.load();
        }

    }

    static class Exit extends CoreSubCommand {

        protected Exit(MainListener parent, String name) {
            super(parent, name);
        }

        @Override
        public void execute(CommandParser parser) {
            parser.sendResponse("Disconnecting...");
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
            }
            parent.exit();
        }

    }

    static class Backup extends CoreSubCommand {

        protected Backup(MainListener parent, String name) {
            super(parent, name);
        }

        @Override
        public void execute(CommandParser parser) {
            parser.sendResponse("Creating backup...");
            parent.backup();
        }

    }

}