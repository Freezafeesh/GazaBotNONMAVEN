/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Gazabot;

import net.dv8tion.jda.api.AccountType;
import net.dv8tion.jda.api.JDA;
import net.dv8tion.jda.api.JDABuilder;
import net.dv8tion.jda.api.OnlineStatus;
import net.dv8tion.jda.api.entities.Activity;

/**
 *
 * @author troy
 */
public class Gaza {
    public static JDA jda;
    public static String prefix = ",,";  
    public static int i = 1;
    public static int k;
    public static void main(String[] args){
        
        try {
         jda = new JDABuilder(AccountType.BOT).setToken("NjQ0NTE2NzIxMzc3NTQyMTY1.Xc1NQA.oNY8KFK7LLDIvsfRRN0uGKXEbdg").build(); 
        } catch (Exception e) {
            System.out.println("couldnt setup");
        }
        jda.getPresence().setStatus(OnlineStatus.ONLINE);
         jda.getPresence().setActivity(Activity.playing("@Twitch.tv/Gaza02 \n type ;;help for more commands"));
         jda.addEventListener(new GazaBotCommands());
         jda.addEventListener(new GazaRPG());
    }
   
}
