package com.fire.server.message;

import com.fire.server.protocol.MessageInputStream;
import lombok.AllArgsConstructor;
import lombok.Data;

import java.io.Serializable;

@Data
@AllArgsConstructor
public class BaseMessage implements Serializable {
    private int msgId;
    private int msgCategory;

//    public boolean encode(MessageOutputStream os) {
//        return true;
//    }

    public boolean decode(MessageInputStream is) throws Exception {
        return true;
    }
}
