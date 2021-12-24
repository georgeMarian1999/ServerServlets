package com.server.utils;

import java.util.Arrays;
import java.util.List;

public class Utils {
    public static String getSystemPath() {
        String path = "";
        List<String> paths = Arrays.asList(System.getProperty("user.dir").split("\\\\"));
        int i = 1;
        path = path + paths.get(0);
        while (!paths.get(i).equals("server")){
            path = path +"\\"+ paths.get(i);
            i++;
        }
        path = path + "\\" + paths.get(i) +"\\src\\main\\webapp";
        return path;
    }
}
