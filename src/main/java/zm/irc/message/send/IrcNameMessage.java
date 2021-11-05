package zm.irc.message.send;

import zm.irc.consts.IrcMessageType;


/**
 * Command: NAMES
 *
 * Parameters: [<channel>{,<channel>}]
 * 一个用户可以列出一个频道里所有他们可见的nickname。他们只能查看哪些非+p标志和+s标志，
 * 或者他么已经进入的频道。<channel>参数指定的就是他们想要查看的频道名。不会因为一个错误频道名而返回错误信息。
 */
public class IrcNameMessage implements IrcSendMessage {


    private String channel;

    public String getChannel() {
        return channel;
    }

    public void setChannel(String channel) {
        this.channel = channel;
    }

    @Override
    public String getMessage() {
        return IrcMessageType.NAMES_MESSAGE + channel + "\r\n";
    }
}
