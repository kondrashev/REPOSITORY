package net.ukr.kondrashev;

import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.lang.reflect.Field;

public class Saver {
    @SaveTo(patch = "text.txt")
    public void saveText(String way) {
        TextKeys tk = new TextKeys();
        Class<?> cl = tk.getClass();
        Field fieldOne = null;
        String text = "";
        try (PrintWriter pw = new PrintWriter(way)) {
            fieldOne = cl.getDeclaredField("text");
            fieldOne.setAccessible(true);
            text = (String) fieldOne.get(tk);
            pw.println(text);
        } catch (FileNotFoundException | NoSuchFieldException | IllegalAccessException e) {
            System.out.println("Error file write!!!");
        }
    }
}
