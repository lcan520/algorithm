package io.select;

import java.io.IOException;
import java.io.OutputStream;
import java.net.Socket;

/**
 * <p>
 *
 * </p>
 *
 * @author lcan520.cn
 * @date Created in 8:51 2022/3/8
 * @since 1.0.0
 */
public class NIOClient {
    public static void main(String[] args) throws IOException {
        Socket socket = new Socket("127.0.0.1", 8888);
        OutputStream out = socket.getOutputStream();
        String s = "hello world";
        out.write(s.getBytes());
        out.close();
    }
}
