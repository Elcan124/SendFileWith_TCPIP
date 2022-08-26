package tcp_ClientAndServer;

import bean.PortAndIP;
import fileUtility.FileUtil;
import main.Main;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.FileOutputStream;
import java.net.ServerSocket;
import java.net.Socket;

public class Server {
    private static DataOutputStream dataOutputStream = null;
    private static DataInputStream dataInputStream = null;

    public static void main() {
        try(ServerSocket serverSocket = new ServerSocket(PortAndIP.getPort())){
            System.out.println("listening to port :"+PortAndIP.getPort());
            Client.main();
            Socket clientSocket = serverSocket.accept();
            System.out.println(clientSocket+" connected to port: "+PortAndIP.getPort());
            dataInputStream = new DataInputStream(clientSocket.getInputStream());
            dataOutputStream = new DataOutputStream(clientSocket.getOutputStream());
String newFileName = FileUtil.getNewFileName();
            receiveFile(newFileName);


            dataInputStream.close();
            dataOutputStream.close();
            clientSocket.close();

        } catch (Exception e){
            e.printStackTrace();
        }
    }

    private static void receiveFile(String fileName) throws Exception{
        int bytes = 0;
        FileOutputStream fileOutputStream = new FileOutputStream(fileName);

        long size = dataInputStream.readLong();     // read file size
        byte[] buffer = new byte[4*1024];
        while (size > 0 && (bytes = dataInputStream.read(buffer, 0, (int)Math.min(buffer.length, size))) != -1) {
            fileOutputStream.write(buffer,0,bytes);
            size -= bytes;      // read upto file size
        }
        fileOutputStream.close();
    }
}
