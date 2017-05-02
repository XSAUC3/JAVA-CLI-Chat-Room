import java.io.*;
import java.net.*;
import java.time.*;

public class Server
{
      static ServerSocket server=null;
      static Socket socket=null;
      static ClientThread th[]=new ClientThread[10];
      public static void main(String args[])
      {
            int port=1234;
            System.out.println("Server started...");
            System.out.println("  [Press Ctrl C to terminate ]");
            try
            {
                  server=new ServerSocket (port);
            }
            catch(IOException e)
            {
                  System.out.println("Exception for Input/Output");
            }
            while(true)
            {
                  try
                  {
                        socket=server.accept();
                        for(int i=0;i<=9;i++)
                        {
                              if(th[i]==null)
                              {
                                    (th[i]=new ClientThread(socket,th)).start();
                                    break;
                              }
                        }
                        }
                        catch(IOException e)
                        {
                              System.out.println("Exception for Input/Output");
                        }
                  }
            }
      }

      class ClientThread extends Thread
      {
            BufferedReader input=null;
            PrintStream output=null;
            Socket socket=null;
            ClientThread th[];
            public ClientThread(Socket socket,ClientThread[] th)
            {
                  this.socket=socket;
                  this.th=th;
            }

            public void run()
            {
                String msg;
                String msgb;
                String bString="";
                String temp="";
                String username= null;
                String BLACK = "\u001B[30m";
        String RED = "\u001B[31m";
        String GREEN = "\u001B[32m";
        String YELLOW = "\u001B[33m";
        String BLUE = "\u001B[34m";
        String PURPLE = "\u001B[35m";
        String CYAN = "\u001B[36m";
        String WHITE = "\u001B[37m";
        String MEGENTA = "\u001B[35m";
        String BW = "\u001B[30;47m";
        String BOLD = "\u001B[30;1m";
        String RESET = "\u001B[0m";

                  try
                  {

                        input = new BufferedReader(new InputStreamReader(socket.getInputStream()));

                        output = new PrintStream(socket.getOutputStream());
              
                 output.println(RED+ 	" ▄████▄   ██░ ██  ▄▄▄     ▄▄▄█████▓    ██▀███   ▒█████   ▒█████   ███▄ ▄███▓");
                 output.println(YELLOW+ "▒██▀ ▀█  ▓██░ ██▒▒████▄   ▓  ██▒ ▓▒   ▓██ ▒ ██▒▒██▒  ██▒▒██▒  ██▒▓██▒▀█▀ ██▒");
                 output.println(GREEN+  "▒▓█    ▄ ▒██▀▀██░▒██  ▀█▄ ▒ ▓██░ ▒░   ▓██ ░▄█ ▒▒██░  ██▒▒██░  ██▒▓██    ▓██░");
                 output.println(CYAN+ 	"▒▓▓▄ ▄██▒░▓█ ░██ ░██▄▄▄▄██░ ▓██▓ ░    ▒██▀▀█▄  ▒██   ██░▒██   ██░▒██    ▒██ ");
                 output.println(BLUE+ 	"▒ ▓███▀ ░░▓█▒░██▓ ▓█   ▓██▒ ▒██▒ ░    ░██▓ ▒██▒░ ████▓▒░░ ████▓▒░▒██▒   ░██▒");
                 output.println(PURPLE+ "░ ░▒ ▒  ░ ▒ ░░▒░▒ ▒▒   ▓▒█░ ▒ ░░      ░ ▒▓ ░▒▓░░ ▒░▒░▒░ ░ ▒░▒░▒░ ░ ▒░   ░  ░");
                 output.println(MEGENTA+"  ░  ▒    ▒ ░▒░ ░  ▒   ▒▒ ░   ░         ░▒ ░ ▒░  ░ ▒ ▒░   ░ ▒ ▒░ ░  ░      ░");
                 output.println(MEGENTA+"░         ░  ░░ ░  ░   ▒    ░           ░░   ░ ░ ░ ░ ▒  ░ ░ ░ ▒  ░      ░   ");
                 output.println(MEGENTA+"░ ░       ░  ░  ░      ░  ░              ░         ░ ░      ░ ░         ░   ");
                 output.println(MEGENTA+"░                                                                           "+RESET);
                           output.println(BW+"ENTER USERNAME : "+RESET);
                            username = input.readLine();
                         	while(true)
								
								if(username.trim().isEmpty() || username == " " || username.contains(" ")){
								 output.println(BW+"ENTER APROPRIATE USERNAME : "+RESET);
								 username = input.readLine();
								}
								
								else{
									break ;
								  
								}

                 System.out.println(username +":CONNECTED TO THE SERVER");      


                 		   
                 		   output.println(BW+      "•===== Hey user , Welcome To The Chat Room ==============•" + RESET);
                           output.println(RED +    "•[type @ to let everyone know who made it]===============•" + RESET);
                           output.println(YELLOW + "•[type $$ to leave the chat room]========================•" + RESET);
                           output.println(GREEN +  "•[type ^^ to clear the chat]=============================•" + RESET);
                           output.println(CYAN +   "•[type 01 to start binary mode]==========================•" + RESET); 
                           output.println(BLUE +   "•[type 00 to revert from binary mode]====================•" + RESET);
                           output.println(MEGENTA +"•[type servre and your msg to sent it to server]=========•" + RESET);
                           output.println(BW+      "•========================================================•" + RESET + "\n");                       
                         for (int i = 0; i <= 9; i++)
                              if (th[i] != null && th[i] != this)
                                    th[i].output.println(BW+"\n======="+ username +" ENTERED THE CHAT ROOM======"+RESET);
                              while (true)
                              {
                                    msg = input.readLine();

                                    if (msg.startsWith("01")) {
                                        msgb=input.readLine();
                                         for(int i=0;i<msgb.length();i++)
                                         {
                                             temp=Integer.toBinaryString(msgb.charAt(i));
                                             for(int j=temp.length();j<8;j++)
                                             {
                                                 temp="0"+temp;
                                             }
                                             bString+=temp+"";
                                         }                             
                                          }
                                    if (msg.startsWith("00")) {
                                      bString ="";
                                    }
                                    if (msg.startsWith("server")) {
                                      System.out.println(username+": "+msg);
                                    }
                                    if (msg.startsWith("$$"))
                                          break;
                                    if (msg.startsWith("^^")) {
                                      output.print("\033[H\033[2J");  
                      output.flush();
                                    }
                                    if (msg.startsWith("@")) {
                                      output.println(BW+"CHAT ROOM hosted on localhost on PORT=1234");
                                      output.println(BW+"THE AUTHOR IS :");
                                        output.println(BW+"          /                        ");
                                        output.println(BW+"      _. /_  o ____  ______  __.  ,");
                                        output.println(BW+"     (__/ /_<_/ / <_/ / / <_(_/|_/ ");
                                        output.println(BW+"                                /  ");
                                        output.println(BW+"                               '   "+RESET);
                                        }  

                                         while(true)
								
								if(msg.trim().isEmpty() || username == " "){
								 
								 msg = input.readLine();
								}
								
								else{
									break ;
								  
								}

                                    for (int i = 0; i <= 9; i++)
                                          if (th[i] != null)
                                          
                                                th[i].output.println(BW+"\n[" + username + "] : " + msg+bString +RESET);
                          try { 
                                      File f1 = new File("Chat_Log.txt");
                                          if(!f1.exists()) 
                                            {f1.createNewFile();} 
                                     FileWriter fileWritter = new FileWriter(f1.getName(),true);
                                     BufferedWriter bw = new BufferedWriter(fileWritter);
                                     bw.write("\n["+java.time.LocalDate.now()+"]================================================\n");
                                     bw.write("\n["+username+"] : "+msg+"\n");
                                     bw.write("\n=============================================================\n\n");
                                     bw.close();
                         } 
                         catch(IOException ex)
                         {System.out.println("BACKUP WAS OT CREATED !");}

                              }
                              for (int k = 0; k <= 9; k++)
                                    if (th[k] != null && th[k] != this)
                                          th[k].output.println(BW +"\n======" + username + ": Left The Chat Room ======");
                              output.println(BW+"•==========Press Ctrl + C to terminate==========•");
                              System.out.println(username +":disconnected from the server");
                              for (int j = 0; j <= 9; j++)
                                    if (th[j] == this)
                                          th[j] = null;
                    
                              input.close();
                              output.close();
                              socket.close();
                  }
                  catch (IOException e)
                  {
                        System.out.println("Exception for Input/Output");
                  }
                  catch(NullPointerException ex)
                  {
                    System.out.println(username+": TERMINATED");
                  }
                  }

            }