package fileUtility;

public final class FileUtil {
    private static String  newFileName =null;
    private static String filePath = null;

    public static String getNewFileName() {
        return newFileName;
    }

    public static void setNewFileName(String newFileName) {
        String newName = "NewFile"+"."+newFileName;
        FileUtil.newFileName = newName;
    }

    public static String getFilePath() {
        return filePath;
    }

    public static void setFilePath(String filePath) {
        FileUtil.filePath = filePath;
    }


    public static String getFilename(String filePath) {
        return filePath.split("\\.")[0];


    }

    public static String getExtension(String filePath){
      return filePath.split("\\.")[1];


    }
}
