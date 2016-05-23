package ge.evgo.shop.controller.servlets;

import java.io.File;
import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;

/**
 * Created by root_pc on 4/23/2016.
 */
public class App {

    public static void main(String[] args) {

        String path = App.class.getClassLoader().getResource("").getPath();

        String fullPath = null;
        try {
            fullPath = URLDecoder.decode(path, "UTF-8");

        String pathArr[] = fullPath.split("/WEB-INF/classes/");
        System.out.println(fullPath);
        System.out.println(pathArr[0]);
        fullPath = pathArr[0];

        String reponsePath = "";

        reponsePath = new File(fullPath).getPath() + File.separatorChar + "newfile.txt";

            System.out.println(reponsePath);
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }

    }
}
