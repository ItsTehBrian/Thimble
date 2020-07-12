package xyz.tehbrian.maventehplugin.util;

import org.bukkit.configuration.file.FileConfiguration;
import xyz.tehbrian.maventehplugin.MavenTehPlugin;

public class MsgBuilder {

    private String msgKey;
    private String msgString;
    private String prefixKey;
    private String prefixString;
    private Object[] formats;

    public MsgBuilder def(String msgKey) {
        this.msgKey = msgKey;
        this.prefixKey = "prefix.default";
        return this;
    }

    public MsgBuilder msgKey(String msgKey) {
        this.msgKey = msgKey;
        return this;
    }

    public MsgBuilder msgString(String msgString) {
        this.msgString = msgString;
        return this;
    }

    public MsgBuilder prefixKey(String prefixKey) {
        this.prefixKey = prefixKey;
        return this;
    }

    public MsgBuilder prefixString(String prefixString) {
        this.prefixString = prefixString;
        return this;
    }

    public MsgBuilder formats(Object... formats) {
        this.formats = formats;
        return this;
    }

    public String build() {
        FileConfiguration config = MavenTehPlugin.getInstance().getConfig();
        StringBuilder sb = new StringBuilder();

        if (prefixKey != null) {
            sb.append(config.getString(prefixKey)).append(" ");
        } else if (prefixString != null) {
            sb.append(prefixString).append(" ");
        }

        if (msgKey != null) {
            sb.append(config.getString(msgKey));
        } else if (msgString != null) {
            sb.append(msgString);
        }

        String message = sb.toString();

        if (formats != null) {
            message = String.format(message, formats);
        }

        return MiscUtils.color(message);
    }
}