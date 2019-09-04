package com.fire.server.protocol;


public enum  Protocol {
	//消息头标志
	MSG_HEAD_FLAG {public int getNum() {return 47;}},
	//最大消息长度
	MAX_COMMAND_LENGTH {public int getNum() {return 2048;}},

	//消息类别
	MSG_CATEGORY_AUTH {public int getNum() {return 0;}},
	MSG_CATEGORY_LOGIN {public int getNum() {return 1;}},
	MSG_CATEGORY_GM {public int getNum() {return 51;}},

	MSG_ID_AUTH_CHECK_VERSION_REQUEST {public int getNum() {return 108;}},
	MSG_ID_AUTH_CHECK_VERSION_RESPONSE {public int getNum() {return 105;}};


	public abstract int getNum();

	public static Protocol getProtocolByNum(int num){
		for (Protocol value : Protocol.values()) {
			if (value.getNum() == num) {
				return value;
			}
		}
		return null;
	}
}
