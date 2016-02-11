package com.company.output;

import com.company.command.Command;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.List;

/**
 * Created by user on 12.02.16.
 */
public class Output {

    public static void writeToFile(File file, List<String> commands, int T){
        try {
            FileOutputStream fout = new FileOutputStream(file);
            fout.write((String.valueOf(T) + "\n").getBytes());
            for(String command: commands){
                fout.write((command + "\n").getBytes());
            }
            fout.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
