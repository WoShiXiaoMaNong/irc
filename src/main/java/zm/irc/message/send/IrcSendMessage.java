package zm.irc.message.send;

import zm.irc.consts.IrcCommand;

public interface IrcSendMessage {

    static IrcSendMessage build(String channel,String msgStr){
        if( msgStr == null || msgStr.trim().length() == 0){
            return null;
        }

        IrcSendMessage msg = null;
        if( msgStr.startsWith(IrcCommand.JOIN)){
            msg = new IrcJoinMessage();
            ((IrcJoinMessage)msg).setChannel(msgStr.split(" ")[1]);
        }else if( msgStr.startsWith(IrcCommand.MSG)){
            msg = new IrcMsgMessage();
            ((IrcJoinMessage)msg).setChannel(msgStr.split(" ")[1]);
        }else if( msgStr.startsWith(IrcCommand.NAMES)){
            msg = new IrcNameMessage();
            ((IrcNameMessage)msg).setChannel(msgStr.split(" ")[1]);
        }else if( msgStr.startsWith(IrcCommand.PART)){
            msg = new IrcPartMessage();
            ((IrcPartMessage)msg).setChannel(msgStr.split(" ")[1]);
        }else{
            msg = new IrcChatMessage();
            ((IrcChatMessage)msg).setMsg(msgStr);
            ((IrcChatMessage)msg).setTargetChanel(channel);
        }






        return msg;
    }

    String getMessage();
}
