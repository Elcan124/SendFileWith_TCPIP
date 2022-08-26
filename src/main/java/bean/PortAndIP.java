package bean;

public final class PortAndIP {
    private static String ip =null;
    private static int port;

    public static String getIp() {
        return ip;
    }

    public static void setIp(String ip) {
        PortAndIP.ip = ip;
    }

    public static int getPort() {
        return port;
    }

    public static void setPort(int port) {
        PortAndIP.port = port;
    }
}




