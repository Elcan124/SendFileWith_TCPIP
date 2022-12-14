package tcp_ClientAndServer;

import bean.PortAndIP;
import fileUtility.FileUtil;
import main.Main;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.net.Socket;

public class Client {
    private static DataOutputStream dataOutputStream = null;
    private static DataInputStream dataInputStream = null;

    public static void main() {
        String ip = PortAndIP.getIp();
        int port = PortAndIP.getPort();
        try (Socket socket = new Socket(ip, port)) {
            dataInputStream = new DataInputStream(socket.getInputStream());
            dataOutputStream = new DataOutputStream(socket.getOutputStream());
            String filePath = FileUtil.getFilePath();
            sendFile(filePath);


            dataInputStream.close();
            dataInputStream.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private static void sendFile(String path) throws Exception {
        int bytes = 0;
        File file = new File(path);
        FileInputStream fileInputStream = new FileInputStream(file);

        // send file size
        dataOutputStream.writeLong(file.length());
        // break file into chunks
        byte[] buffer = new byte[4 * 1024];
        while ((bytes = fileInputStream.read(buffer)) != -1) {
            dataOutputStream.write(buffer, 0, bytes);
            dataOutputStream.flush();
        }
        fileInputStream.close();
    }
}