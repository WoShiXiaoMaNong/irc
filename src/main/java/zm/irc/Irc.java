package zm.irc;

import zm.irc.client.IrcClient;
import zm.irc.message.send.IrcSendMessage;

import java.io.*;

public class Irc {

    public static void main(String[] args) throws IOException {

        String server = "irc.libera.chat";
        String nick = "B_fd_test";
        String channel = "#0dev";

        IrcClient client = new IrcClient(server,IrcClient.DEFAULT_PORT,nick);
        client.start();
        client.logon(nick);
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        while(true){

            String msgStr = br.readLine();
            IrcSendMessage msg = IrcSendMessage.build(channel,msgStr);
            client.sendMessage(msg);
        }

    }



}
