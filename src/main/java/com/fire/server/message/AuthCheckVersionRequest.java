package com.fire.server.message;

import com.fire.server.protocol.MessageInputStream;
import com.fire.server.protocol.Protocol;
import lombok.Data;

@Data
public class AuthCheckVersionRequest extends BaseMessage {
    private String fullchannelId;
    private short channelId;
    private short versionGame;
    private short versionData;
    private String ycchannelcode;

    public AuthCheckVersionRequest() {
        super(Protocol.MSG_CATEGORY_AUTH.getNum(), Protocol.MSG_ID_AUTH_CHECK_VERSION_REQUEST.getNum());
        this.fullchannelId = "";
        this.channelId = 0;
        this.versionGame = 0;
        this.versionGame = 0;
        this.ycchannelcode  = "";
    }

    public boolean decode(MessageInputStream is) throws Exception {
        super.decode(is);
        fullchannelId = is.read(fullchannelId);
        channelId = is.read(channelId);
        versionGame = is.read(versionGame);
        versionData = is.read(versionData);
        ycchannelcode  = is.read(ycchannelcode);
        return true;
    }


}
