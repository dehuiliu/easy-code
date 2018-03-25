package easy.code.common.util;

import java.io.*;

public class FileUtil {

    private final static String U8 = "utf-8";

    /**
     * 读取文件内容
     *
     * @param file 文件对象
     * @return 文件内容
     */
    public static String stringFile(File file) {
        assert file != null;
        InputStreamReader reader = null;
        FileInputStream fileInputStream = null;
        BufferedReader br = null;
        StringBuilder configStr = new StringBuilder();
        try {
            fileInputStream = new FileInputStream(file);
            reader = new InputStreamReader(fileInputStream, U8);
            br = new BufferedReader(reader);
            String temp;
            while ((temp = br.readLine()) != null) {
                configStr.append(temp).append("\r\n");
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (br != null) {
                try {
                    br.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            if (reader != null) {
                try {
                    reader.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            if (fileInputStream != null) {
                try {
                    fileInputStream.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
        return configStr.toString();
    }
}
