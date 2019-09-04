package com.fire.server.utils;

import io.vertx.core.logging.Logger;
import io.vertx.core.logging.LoggerFactory;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.util.Random;

public class StreamUtil {
    public static Logger logger = LoggerFactory.getLogger(StreamUtil.class);
    public static Random rand = new Random(); // Random

    public static int readInt(byte[] buf, int offset) { // 读一个int
        return ((buf[offset + 3] & 0xFF) << 24)
                | ((buf[offset + 2] & 0xFF) << 16)
                | ((buf[offset + 1] & 0xFF) << 8) | (buf[offset] & 0xFF);
    }

    public static int readIntB(byte[] buf, int offset) { // 读一个int
        return ((buf[offset] & 0xFF) << 24) | ((buf[offset + 1] & 0xFF) << 16)
                | ((buf[offset + 2] & 0xFF) << 8) | (buf[offset + 3] & 0xFF);
    }

    public static int readLong(byte[] buf, int offset) {
        return readInt(buf, offset + 4) << 24 | readInt(buf, offset);
    }

    public static int readUShort(byte[] buf, int offset) {
        int t = (((buf[offset + 1] & 0xFF) << 8) | (buf[offset] & 0xFF));
        return t;
    }

    public static int readUByte(byte[] buf, int offset) {
        int t = buf[offset] & 0xFF;
        return t;
    }

    public static short readShort(byte[] buf, int offset) {
        int t = (((buf[offset + 1] & 0xFF) << 8) | (buf[offset] & 0xFF));
        return (short) (t);
    }

    public static void appendInt(byte[] buf, int offset, int value) {
        buf[offset] = (byte) (value & 0xFF);
        buf[offset + 1] = (byte) ((value >> 8) & 0xFF);
        buf[offset + 2] = (byte) ((value >> 16) & 0xFF);
        buf[offset + 3] = (byte) ((value >> 24) & 0xFF);
    }

    public static void appendIntB(byte[] buf, int offset, int value) {
        buf[offset + 3] = (byte) (value & 0xFF);
        buf[offset + 2] = (byte) ((value >> 8) & 0xFF);
        buf[offset + 1] = (byte) ((value >> 16) & 0xFF);
        buf[offset] = (byte) ((value >> 24) & 0xFF);
    }

    public static void appendLong(byte[] buf, int offset, long value) {
        appendInt(buf, offset, (int) value);
        appendInt(buf, offset + 4, (int) (value >> 32));
    }

    public static void appendShort(byte[] buf, int offset, int value) {
        buf[offset] = (byte) (value & 0xFF);
        buf[offset + 1] = (byte) ((value >> 8) & 0xFF);
    }

    // --- asic码 中2字节 英1字节 ---
    public static String readString(byte[] buf, int from, int len) {
        byte[] bytes = new byte[len];
        for (int i = 0; i < len; i++)
            bytes[i] = buf[i + from];
        return AsciitoString(bytes);
    }

    public static String byte2String(byte[] bytes) {

        try {
            ByteArrayInputStream bais = new ByteArrayInputStream(bytes);
            DataInputStream dis = new DataInputStream(bais);
            String s = dis.readUTF();
            // 关闭流
            dis.close();
            bais.close();
            return s;
        } catch (Exception e) {
            return null;
        }
    }

    public static int appendString(byte[] buf, int offset, String value) throws Exception {
        byte[] bytes = StringtoAscii(value);
        //byte[] bytes = value.getBytes("UTF-8");
        //byte[] bytes = value.getBytes();
        int len = bytes.length;
        appendShort(buf, offset, len);
        offset += 2;
        // buf[offset++] = (byte)(len >> 8);
        // buf[offset++] = (byte)len;
        for (int i = 0; i < bytes.length; i++) {
            if (offset + i > 1022) {
                int a = offset;
                int b = a;
            }
            buf[offset + i] = bytes[i];
        }
        return len + 2;
    }

    public static byte[] string2Byte(String s) {
        try {
            ByteArrayOutputStream baos = new ByteArrayOutputStream();
            DataOutputStream bos = new DataOutputStream(baos);
            bos.writeUTF(s);
            byte[] bytes = baos.toByteArray();

            // 关闭流
            bos.close();
            baos.close();
            return bytes;
        } catch (Exception e) {
            return null;
        }
    }

    public static byte[] StringtoAscii(String str) {
        byte[] bytes = null;
        try {
            bytes = str.getBytes("UTF-8");
            // String string = new String(bytes, "GB2312");
        } catch (Exception e) {
            logger.info(str + " changed to ascii error!");
        }
        return bytes;
    }

    public static String AsciitoString(byte[] asc) {
        String str = null;
        try {
            str = new String(asc, "UTF-8");
        } catch (Exception e) {
            logger.info(" asicii can not changed to String error!");
        }
        return str;
    }

    // 把单个汉字字符转换为ASCII码
    private static int getCnAscii(char cn) {
        byte[] bytes = null;
        try {
            bytes = (String.valueOf(cn)).getBytes("UTF-8");

        } catch (Exception e) {
            e.printStackTrace();
        }
        if (bytes == null || bytes.length > 2 || bytes.length <= 0) {
            return 0;
        }
        if (bytes.length == 1) {
            return bytes[0];
        } else {
            int hightByte = 256 + bytes[0];
            int lowByte = 256 + bytes[1];
            int ascii = (256 * hightByte + lowByte) - 256 * 256;
            return ascii;
        }
    }

    public static int getRandom(int num) {
        int i = rand.nextInt();
        if (i == 0)
            return (0);
        if (i < 0)
            i = -i;
        return (i % num);
    }

    public static int convertInt(String text) {
        int value = -1;
        try {
            value = Integer.parseInt(text);
        } catch (NumberFormatException e) {
        }
        return value;
    }

    public static void printBytes(byte[] buf, int blen) {
        String tmp = "";
        for (int i = 0; i < blen; i++)
            tmp = tmp + Integer.toString(buf[i]) + " ";
        tmp = null;
    }

    public static void printBytesH(byte[] buf, int blen) {
        String tmp = "";
        for (int i = 0; i < blen; i++) {
            tmp = tmp + Integer.toHexString(buf[i]) + " ";
        }
        tmp = null;
    }

    public static String GetName(String str) {
        int find = str.indexOf('|');
        if (find == -1)
            return str;
        return str.substring(0, find);
    }

    static int Min(int x, int y) {
        int ret = 0;
        if (x >= y)
            ret = y;
        else
            ret = x;
        return ret;
    }

    static int Max(int x, int y) {
        int ret = 0;
        if (x >= y)
            ret = x;
        else
            ret = y;
        return ret;
    }

    static int outputnumber(int num, int index) {// 输入第INDEX位的数值
        if (index == 0)
            return num % 10;
        if (index == 1)
            return num / 10 % 10;
        if (index == 2)
            return num / 100 % 10;
        if (index == 3)
            return num / 1000 % 10;
        if (index == 4)
            return num / 10000 % 10;
        if (index == 5)
            return num / 100000 % 10;
        if (index == 6)
            return num / 1000000 % 10;
        if (index == 7)
            return num / 10000000 % 10;
        if (index == 8)
            return num / 100000000 % 10;
        return 0;
    }

    public static int power(int index) {
        if (index == 0)
            return 1;
        if (index == 1)
            return 10;
        if (index == 2)
            return 100;
        if (index == 3)
            return 1000;
        if (index == 4)
            return 10000;
        if (index == 5)
            return 100000;
        if (index == 6)
            return 1000000;
        if (index == 7)
            return 10000000;
        if (index == 8)
            return 100000000;
        return 0;
    }

    public static int revert(int num) // 1234 --> 4321
    {
        int ch = num;
        int n = 0;
        while (ch != 0) {
            n = n * 10 + ch % 10;
            ch /= 10;
        }
        return num < 0 ? -ch : ch;
    }

    public static int[] revertArray(int num) {
        num = num < 0 ? -num : num;
        int ch = num;
        int n = ch == 0 ? 1 : 0;
        while (ch != 0) {
            n++;
            ch /= 10;
        }
        int[] array = new int[n];
        while (num != 0) {
            array[--n] = num % 10;
            num /= 10;
        }
        return array;
    }
}
