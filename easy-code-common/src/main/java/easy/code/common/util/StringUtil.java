package easy.code.common.util;

import java.io.UnsupportedEncodingException;
import java.net.URL;

public class StringUtil {

    public static String toString(Object value) {
        return value == null ? "" : value.toString();
    }

    public static String formatFilePath(String inPath) {

        ClassLoader classLoader = StringUtil.class.getClassLoader();
//        String fileClassPath = inPath.substring(10, inPath.length());
        String fileClassPath = inPath;
        URL url = classLoader.getResource(fileClassPath);
        if (url != null) {
            String file = url.getFile();
            try {
                file = java.net.URLDecoder.decode(file, "utf-8");
            } catch (UnsupportedEncodingException e) {
                e.printStackTrace();
            }
            return file;
        }
        throw new RuntimeException("------not have: " + inPath);
    }
}
