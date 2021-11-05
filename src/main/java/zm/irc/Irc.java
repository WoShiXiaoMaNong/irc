package zm.irc;

import zm.irc.client.IrcClient;
import zm.irc.message.send.IrcSendMessage;

import java.io.*;

public class Irc {

    public static void main(String[] args) throws IOException, InterruptedException {

        String server = "irc.libera.chat";
        String nick = "Zhong_Ming_test";
        String login = "anyName";
        String channel = "#zmtest";

        IrcClient client = new IrcClient(server,IrcClient.DEFAULT_PORT,nick);
        client.start();
        client.logon(nick);
      //  Thread.sleep(3000);
      //  client.join(channel);
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        while(true){

            String msgStr = br.readLine();
            IrcSendMessage msg = IrcSendMessage.build(channel,msgStr);
            client.sendMessage(msg);
        }

    }



}
