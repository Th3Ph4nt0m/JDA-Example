/*
 * Bot.java is part of the JDA-Example project
 *
 * The JDA-Example is licensed under The Unlicense.
 *
 * Copyright (c) 2020 Henrik Steffens
 */

package de.th3ph4nt0m.jdaexample;

import net.dv8tion.jda.api.JDA;
import net.dv8tion.jda.api.JDABuilder;
import net.dv8tion.jda.api.OnlineStatus;
import net.dv8tion.jda.api.entities.Activity;

import javax.security.auth.login.LoginException;

public class Bot
{
    private static Bot instance;
    private JDA jda;


    public Bot()
    {
        instance = this;
        try {
            this.jda = JDABuilder.createDefault("token")                //Creates a JDABuilder with recommended default settings
                    .setAutoReconnect(true)                             //Sets whether or not JDA should try to reconnect if a connection-error is encountered
                    .setStatus(OnlineStatus.ONLINE)                     //Sets the OnlineStatus our connection will display
                    .setActivity(Activity.listening("to everyone"))     //Sets the Activity for our session
                    .build();                                           //Builds a new JDA instance and uses the provided token to start the login process
        } catch (LoginException e) {
            e.printStackTrace();
        }
    }


    public static Bot getInstance()
    {
        return instance;
    }

    public JDA getJda()
    {
        return jda;
    }
}
