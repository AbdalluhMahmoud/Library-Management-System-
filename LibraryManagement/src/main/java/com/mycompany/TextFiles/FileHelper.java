package com.mycompany.TextFiles;

import java.io.*;
import java.util.*;

public class FileHelper {
    public static List<String> readFile(String fileName) throws IOException {
        List<String> lines = new ArrayList<>();
        File file = new File(fileName);
        if(!file.exists()){
            file.createNewFile();
        }
        try(Scanner sc = new Scanner(file)){
            while(sc.hasNextLine()){
                lines.add(sc.nextLine());
            }
        }
        return lines;
    }
    
    public static void writeFile(String fileName,List<String> lines)throws IOException{
        try(PrintWriter pw = new PrintWriter(new FileWriter(fileName))){
            for(String line : lines){
                pw.println(line);
            }
        }
    }
    
    public static void appendLine(String fileName , String line)throws IOException{
        try(PrintWriter pw = new PrintWriter(new FileWriter(fileName, true))){
            pw.println(line);
        }
    }
 
}
