/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package util;

import java.io.File;
import java.util.Scanner;

/**
 *
 * @author bruno
 */
public class GerenciaCsv {

    private File file;

    public GerenciaCsv() {
    }

    public File getFile() {
        return file;
    }

    public void setFile(File file) {
        this.file = file;
    }

    public String lerCSV(String pathFile) {

        file = new File(pathFile);
        String fileLines="";

        Scanner sc = null;

        try {
            sc = new Scanner(file);

            while (sc.hasNextLine()) {
                fileLines = sc.nextLine();

            }

        } catch (Exception e) {

            System.out.println(e.getMessage());

        } finally {
            if (sc != null) {

                sc.close();
            }
        }
        
        return fileLines;

    }

}
