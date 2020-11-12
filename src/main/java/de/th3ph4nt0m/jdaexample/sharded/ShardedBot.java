/*
 * Bot.java is part of the JDA-Example project
 *
 * The JDA-Example is licensed under The Unlicense.
 *
 * Copyright (c) 2020 Henrik Steffens
 */

package de.th3ph4nt0m.jdaexample.sharded;

import net.dv8tion.jda.api.OnlineStatus;
import net.dv8tion.jda.api.entities.Activity;
import net.dv8tion.jda.api.sharding.DefaultShardManagerBuilder;
import net.dv8tion.jda.api.sharding.ShardManager;

import javax.security.auth.login.LoginException;

public class ShardedBot
{
    private static ShardedBot instance;
    private ShardManager shardManager;


    public ShardedBot(int shards)
    {
        instance = this;
        try {
            this.shardManager = DefaultShardManagerBuilder.createDefault("token")  //Creates a DefaultShardManagerBuilder with recommended default settings
                    .setShardsTotal(shards)                                        //Sets the total amount of shards
                    .setAutoReconnect(true)                                        //Sets whether or not JDA should try to reconnect if a connection-error is encountered
                    .setStatus(OnlineStatus.ONLINE)                                //Sets the OnlineStatus our connection will display
                    .setActivity(Activity.listening("to everyone"))                //Sets the Activity for our session
                    .build();                                                      //Builds a new ShardManager instance and uses the provided token to start the login process
        } catch (LoginException e) {
            e.printStackTrace();
        }
    }


    public static ShardedBot getInstance()
    {
        return instance;
    }

    public ShardManager getShardManager()
    {
        return shardManager;
    }
}
