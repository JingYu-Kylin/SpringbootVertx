package com.fire.server.handler;

import com.fire.server.message.AuthCheckVersionRequest;
import com.fire.server.protocol.MessageInputStream;
import com.fire.server.protocol.Protocol;
import io.vertx.core.AsyncResult;
import io.vertx.core.Handler;
import io.vertx.core.buffer.Buffer;
import io.vertx.core.logging.Logger;
import io.vertx.core.logging.LoggerFactory;

import java.io.ByteArrayInputStream;
import java.io.InputStream;

public class DecodeHandler implements Handler<Buffer> {
    public static Logger logger = LoggerFactory.getLogger(DecodeHandler.class);

    private final Handler<AsyncResult<Object>> client;

    public DecodeHandler(Handler<AsyncResult<Object>> client) {
        this.client = client;
    }

    @Override
    public void handle(Buffer buffer) {
        while (true) {
            try {
                InputStream inputStream = new ByteArrayInputStream(buffer.getBytes());
                MessageInputStream mis = new MessageInputStream(inputStream);

                short ret = -1;
                ret = mis.read((byte)ret);
                if (ret != Protocol.MSG_HEAD_FLAG.getNum())
                {
                    for (int i=0; i<50; i++)
                        logger.info("head: "+ret+" "+mis.read((byte)ret));
                    mis.close();
                    return;
                }
                do {
                    int msgCategory = mis.read((byte) ret);
                    int msgId = mis.read(ret);
                    logger.info(msgCategory + "," + msgId);
                    int msgLen = mis.read(ret);
                    if (msgLen > Protocol.MAX_COMMAND_LENGTH.getNum() || msgLen < 0) {
                        mis.close();
                        throw new Exception("Socket request is null.");
                    }

                    Protocol protocolType = Protocol.getProtocolByNum(msgCategory);
                    switch (protocolType) {
                        case MSG_CATEGORY_AUTH:
                            Protocol protocolNum = Protocol.getProtocolByNum(msgId);
                            switch (protocolNum) {
                                case MSG_ID_AUTH_CHECK_VERSION_REQUEST:
                                    //版本验证
                                    AuthCheckVersionRequest request = new AuthCheckVersionRequest();
                                    request.decode(mis);

                                    break;
                                case MSG_HEAD_FLAG:
                                    break;
                            }
                            break;
                        case MSG_CATEGORY_LOGIN:
                            break;
                        case MSG_CATEGORY_GM:
                            break;
                    }
                } while (ret == Protocol.MSG_HEAD_FLAG.getNum());

            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }
}
