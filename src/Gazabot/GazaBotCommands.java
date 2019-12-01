/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Gazabot;

import com.sun.xml.internal.bind.v2.schemagen.Util;
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
import net.dv8tion.jda.api.OnlineStatus;
import net.dv8tion.jda.api.entities.Member;
import net.dv8tion.jda.api.entities.Message;
import net.dv8tion.jda.api.entities.Role;
import net.dv8tion.jda.api.requests.restaction.MessageAction;
import net.dv8tion.jda.internal.requests.Route.Users;
/**
 *
 * @author troy
 */
public class GazaBotCommands extends ListenerAdapter{
    
    File Coin = new File("Coin.txt");
    double i = 0;
    double x = 0;
    double y = 0;
    double z = 0;
    double value;
    double totalscore;
    double freeMarket;
    double decimalScore;
    int j = 0;
    private int[] wallet;
    File Econ = new File("Econ.txt");
    String score = "";
    Scanner sc;
    boolean check = false;
    String Wallet;
    String User;
    String tempUser = "";
    String tempUser1 = "";
    String tempWall = "";
    Scanner sc1;
    double manip;
    Gaza gazaObj = new Gaza();

    public void onGuildMessageReceived(GuildMessageReceivedEvent event){
        String payer = event.getAuthor().getName();
       String[] args = event.getMessage().getContentRaw().split(" ");
       Gaza.k = args.length;
       for (int j = 0; j < Gaza.k; j++) {
           
          if(Gaza.k > j && args[j].equalsIgnoreCase("gaza")){
           i++;
            manip = i;
           x = i * 0.3;
           score = "";
           totalscore = 0;
           totalscore = totalscore + x;
           score = score + x;
              }

          }
       
       
       
       if (args[0].equalsIgnoreCase(Gaza.prefix + "CryptoHelp")) {
            event.getChannel().sendTyping().queue();
            event.getChannel().sendMessage("REVOLUTIONARY NEW CRYPTOCURRENCY: GAZACOIN\n Use ;;Create to make a wallet. - If you use this command more than once your gazaWallet with break, so dont do that.").queue();
        }
       
       
       
       if(args[0].equalsIgnoreCase(Gaza.prefix + "help")){
            EmbedBuilder help = new EmbedBuilder();
            help.setTitle("🤡GazaBot2000🤡");
            help.addField("COMMANDS:","Just a foreword, GazaBot is pretty useless and hes a little bit fucky - chances are you're going to break him; please be gentle while new features are being added\n\n,,CryptoHelp - Explains the GAZACoin System \n ,,Crypto - Displays current value of an GAZACoin \n,,Create - Creates a randomized GazaCoin Wallet \n,,Wallet - Displays how many GAZACoins you have\n,,Inflate - Inflates economy\n,,Crash - Crashes the economy \n,,jr - Gerickas your message", false);
            help.setFooter("brought to you by Freezafeesh Industries");
            help.setColor(0x3fce7);
            event.getChannel().sendMessage(help.build()).queue();
            help.clear();
       }
       
       
        if (args[0].equalsIgnoreCase(Gaza.prefix + "crypto")) {
            event.getChannel().sendMessage("`Global Individual Use Gazas: " + i + "\nOne GazaCoin is worth: " + score + "\nGazaCoin is currently trending: Upwards \n!!!!!Invest in GazaCoin!!!!!`").queue();
        }
        
        
         if(args[0].equalsIgnoreCase(Gaza.prefix + "Create")){
             String Users = event.getAuthor().getName();
             try {
                 Scanner sc = new Scanner(Econ);
                 sc.useDelimiter(",\n");

                     try {
                 z =(Math.random() * ((10-1) + 1)) + 1;
                 y = Math.round(z);
                 decimalScore = Math.round(y * totalscore);
                                    try(FileWriter fwUsers = new FileWriter(this.Econ, true)){
                                    fwUsers.write(System.lineSeparator()+Users+"\n"+ y);
                                    check=true;
         }
                         } catch (Exception e) {
                         }
                     
                 
                 
  

                     event.getChannel().sendMessage("Success! you created a wallet and recieved: " + y + " Coins with a value of: "+ decimalScore +" Sheckles").queue();
             } catch (Exception e){
                 System.out.println(Exception.class);
             }
             
             
         }
         if(args[0].equalsIgnoreCase(Gaza.prefix + "Wallet")){
            
             String Users = event.getAuthor().getName();
             try {
                 sc = new Scanner(Econ);
                 sc.useDelimiter("\n");
                              } catch (Exception e) {
             }
                while(sc.hasNextLine()){
                           try {
                            if(sc.next().trim().equalsIgnoreCase(Users.trim())){
                               tempWall = sc.next();
                               freeMarket = Double.parseDouble(tempWall);
                               freeMarket = freeMarket * totalscore;                                                                                                                                               
                               event.getChannel().sendMessage("`WELCOME TO YOUR GAZACOIN CRYPTO WALLET`"+"\n`Coins: " + tempWall + "\nSheckle Value: " + freeMarket + "\nCurrent Exchange Rate: " + score + "\n" + "\n" + "\nType ;;Crypto for more stock info`").queue();
                            }

                        
                    } catch (Exception e) {
                               System.out.println(Exception.class);
                    }
                                        }

    }
       if(args[0].equalsIgnoreCase(Gaza.prefix + "JR")){
           String message = "";
          for (int k = 1; k < args.length; k++) {
               
               int j = k; 
               message = message +" "+ args[k];
               
           
       }       
          System.out.println("unprocessed args for ,,jr :"+ message);
               String boticka ="icka";
               message = message + boticka;
               System.out.println("processed args for ,,jr :" + message);
               event.getChannel().sendMessage(message).queue();
           }
        for (int k = 0; k < args.length; k++) {
            String message = "";
            if (args[0].equalsIgnoreCase("im")){
                for (int l = 1; l < args.length; l++) {
                     message = message + args[l]+ " ";
                    if (l==args.length) {
                        args[l] = "";
                        message = message + args[l];   
                    }


                }
                event.getChannel().sendMessage("Hello " + message + "I'm Gazabot2000 you know that right?").queue(); 
            }
          
        }
          if(args[0].equalsIgnoreCase(Gaza.prefix + "Inflate")){
              for (int k = 0; k < 3; k++) {
                event.getChannel().sendMessage("Gaza Gaza Gaza Gaza Gaza Gaza Gaza Gaza Gaza Gaza Gaza Gaza").queue(); 

              }
              event.getChannel().sendMessage("`END INFLATE`").queue();
          }
            if(args[0].equalsIgnoreCase(Gaza.prefix + "Crash")){
              manip = manip - (Math.random() * ((30-1) + 1)) + 1;
              i = manip;
              event.getChannel().sendMessage("New Sheckle Value: " + manip).queue(); 
            }
            if (args[0].equalsIgnoreCase(Gaza.prefix + "GarbageIn")) {
                event.getChannel().sendMessage("Garbage Out hehehehehehe").queue(); 
            }
            if (args[0].equalsIgnoreCase(Gaza.prefix + "Gaza")) {
                event.getChannel().sendMessage("`Gaza is gay ~ Quaza`").queue(); 
            }
             for (int k = 0; k < args.length; k++) {
            String message = "";
            if (args[k].equalsIgnoreCase("communism")){
                for (int l = 1; l < args.length; l++) {
                     message = message + args[l]+ " ";
                    if (l==args.length) {
                        args[l] = "";
                        message = message + args[l];   
                    }


                }
                event.getChannel().sendMessage("if my girl👧😍 and communism☭ 🔥 are both drowning🌊😦 and I could only save one😄☝️you can catch me seizing the means of production 😤 at my girls funeral😅👻💀 cause it's time to guillotine the rich bruh 🙏👊😠☭😭\n" +
"").queue(); 
            }
            if (args[k].equalsIgnoreCase("spam")){
                for (int l = 1; l < args.length; l++) {
                     message = message + args[l]+ " ";
                    if (l==args.length) {
                        args[l] = "";
                        message = message + args[l];
            }
                    event.getChannel().sendMessage("Gaza spam").queue();
             }
}
             if (args[k].equalsIgnoreCase("Wheres")){
                 event.getChannel().sendMessage("Accounting").queue();
                 break;
            }
                   
             
             
             }
            if(args[0].equalsIgnoreCase(Gaza.prefix + "Math.Multiply")) {
                float x = Float.parseFloat(args[1]);
                float y = Float.parseFloat(args[2]);
                float product = x * y;
                event.getChannel().sendMessage("Product: "+product).queue();
             }
            if(args[0].equalsIgnoreCase(Gaza.prefix + "MainConsole.log()")){
                event.getChannel().sendMessage("Exception: ").queue();
            }
             if(args[0].equalsIgnoreCase(Gaza.prefix + "Check")){
               event.getChannel().sendMessage("Gaza bot is:\nworking (Kinda)").queue();  
             }
              for (int k = 0; k < args.length; k++) {
            String message = "";
            if (args[k].equalsIgnoreCase("zinondo")){
                for (int l = 1; l < args.length; l++) {
                     message = message + args[l]+ " ";
                    if (l==args.length) {
                        args[l] = "";
                        message = message + args[l];   
                    }


                }
                event.getChannel().sendMessage("hehhehee mr zinondo").queue();

    }
}
                            for (int k = 0; k < args.length; k++) {
            String message = "";
            if (args[k].equalsIgnoreCase("fuck") || args[k].equalsIgnoreCase("shit") || args[k].equalsIgnoreCase("gay") || args[k].equalsIgnoreCase("sex") || args[k].equalsIgnoreCase("pussy")){
                for (int l = 1; l < args.length; l++) {
                     message = message + args[l]+ " ";
                    if (l==args.length) {
                        args[l] = "";
                        message = message + args[l];   
                    }


                }
                event.getChannel().sendMessage("DO NOT USE THAT FUCKING LANGUAGE").queue();

    }
}
                   if(args[0].equalsIgnoreCase(Gaza.prefix + "kill")) {
                      String User = event.getAuthor().getName();
                      if((User.equalsIgnoreCase("FreezaFeesh") || User.equalsIgnoreCase("JR") || User.equalsIgnoreCase("TechnicalToast") || User.equalsIgnoreCase("Nitron_Biohazard") || User.equalsIgnoreCase("Gaza"))){
                          System.out.println("Killed by: " + event.getAuthor().getName());
                          event.getChannel().sendMessage("GazaBot is going offline...").queue(); 
                      event.getChannel().sendMessage("Closing...").queue(); 
                      event.getChannel().sendMessage("!!!GazaBot will not function until next runtime!!!").queue(); 
                       try {
                        Thread.sleep(1000);
                         System.exit(0);
                       } catch (Exception e) {
                       }
                      }
                     if(args[0].equalsIgnoreCase(Gaza.prefix + "kill")){
                         if ((User.equalsIgnoreCase("FreezaFeesh") || User.equalsIgnoreCase("JR") || User.equalsIgnoreCase("TechnicalToast") || User.equalsIgnoreCase("Nitron_Biohazard") || User.equalsIgnoreCase("Gaza"))) {
                        event.getChannel().sendMessage("Hello username: " + event.getAuthor().getName() + " -You do not have permission to kill me, get permission from Troy" ).queue();     
                         }
                        
                   }
                     
                         }
                    if(args[0].equalsIgnoreCase(Gaza.prefix + "cull")) {
                            String User = event.getAuthor().getName();
                            
                            if(args.length < 2){
                            event.getChannel().sendMessage("Include the num of messages you want to delete").queue();
                        }
                            
                        else{
                            if(User.equalsIgnoreCase("FreezaFeesh") || User.equalsIgnoreCase("JR") || User.equalsIgnoreCase("TechnicalToast") || User.equalsIgnoreCase("Nitron_Biohazard")){
                            try{List<Message> messages = event.getChannel().getHistory().retrievePast(Integer.parseInt(args[1])).complete();
                            event.getChannel().deleteMessages(messages).queue();
                            Thread.sleep(1000);
                            event.getChannel().sendMessage("`deleted "+args[1]+" messages successfully`").queue();
                           
                            }catch(Exception e){
                               if(e.toString().startsWith("java.lang.IllegalArgumentException: Message")){
                                event.getChannel().sendMessage("`Can't delete > 100 messages at once`").queue();
                            }
                               else{
                                    event.getChannel().sendMessage("`Can't delete messages > 2 weeks`").queue();
                               }
                            }
                        }    
                            }
                        if(!User.equalsIgnoreCase("FreezaFeesh") || User.equalsIgnoreCase("JR") || User.equalsIgnoreCase("TechnicalToast") || User.equalsIgnoreCase("Nitron_Biohazard")){
                              event.getChannel().sendMessage("You do not have permission to use this command").queue();
                            
                            }
                        }
                    if(args[0].equalsIgnoreCase(Gaza.prefix + "pay")){
                        User = event.getAuthor().getName();
                        try {
                       sc = new Scanner(Econ);
                            System.out.println("payer: " + User);
                       while(sc.hasNext()){
                          
                          if(sc.nextLine().equalsIgnoreCase(payer)){
                             float payBalance = sc.nextFloat();
                             payBalance = payBalance - Float.parseFloat(args[2]);
                              System.out.println(payBalance);
                              while(sc.hasNext()){
                       if(sc.nextLine().equalsIgnoreCase(payer)){
                           try{
                                try(FileWriter fwUsers = new FileWriter(this.Econ, true)){
                                fwUsers.write(System.lineSeparator()+payBalance);
                           } 
                           }catch (Exception e) {
                                    System.out.println(e);
                           }
                           }
                          }
                          
                       }
                       
                       
                       }
                       
                        } catch (Exception e) {
                                System.out.println(e);
                                }
                        }

                    }
                        
}

                     
                                
            
                     