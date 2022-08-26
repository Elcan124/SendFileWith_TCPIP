package main;

import bean.PortAndIP;
import fileUtility.FileUtil;
import tcp_ClientAndServer.Client;
import tcp_ClientAndServer.Server;
import utility.Utility;

import java.io.File;

public class Main {


    public static void main(String[] args) {
        String nameAndSurname = Utility.getNameAndSurname();
        FileUtil.setFilePath(Utility.requireText("Enter file path that which file you want to send"));
        String extension =  FileUtil.getExtension(FileUtil.getFilePath());
        FileUtil.setNewFileName(extension);
        String ipPort = Utility.requireText("Enter ip and port (like localhost:0000  must have -->':')");
        String[] sArr = ipPort.split(":");
        PortAndIP.setIp(sArr[0]);
        PortAndIP.setPort(Integer.parseInt(sArr[1]));
        Server.main();
        System.out.println("File sent successfully from ->"+ nameAndSurname);

    }
}



