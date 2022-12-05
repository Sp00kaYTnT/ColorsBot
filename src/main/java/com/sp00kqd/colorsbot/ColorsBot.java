package com.sp00kqd.colorsbot;

import io.github.cdimascio.dotenv.Dotenv;
import net.dv8tion.jda.api.OnlineStatus;
import net.dv8tion.jda.api.entities.Activity;
import net.dv8tion.jda.api.sharding.DefaultShardManagerBuilder;
import net.dv8tion.jda.api.sharding.ShardManager;

import javax.security.auth.login.LoginException;

public class ColorsBot {

    private final Dotenv config;
    private final ShardManager shardManager;

    public ColorsBot() throws LoginException {
        config = Dotenv.configure().ignoreIfMissing().load();
        DefaultShardManagerBuilder builder = DefaultShardManagerBuilder.createLight(config.get("TOKEN"));

        builder.setStatus(OnlineStatus.ONLINE);
        builder.setActivity(Activity.watching("you"));
        shardManager = builder.build();
    }

    public ShardManager getShardManager() {
        return shardManager;
    }

    public static void main(String[] args) {
        try {
            ColorsBot bot = new ColorsBot();
        } catch(LoginException e) {
            e.printStackTrace();
        }
    }

}
