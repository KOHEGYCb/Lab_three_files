package threefiles.IO;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;

/**
 *
 * @author dmitry
 */
public class Input {

    //чтение файла 1 и возврат строчки
    public static ArrayList<String> readFile(String filename) {
        ArrayList<String> strings = new ArrayList<>();
        String str = "";
        //создание входного потока 
        FileInputStream fis = null;
        try {
            fis = new FileInputStream(filename);
            //чтение файла
            int s = fis.read();
            while (s != -1) {
                //если прочитанное значение является буквой
                if (isCharacter(s)) {
                    //добавление в строку
                    str += (char) s;
                }
                if (isSpace(s)){
                    strings.add(str);
//                    System.out.println(str);
                    str = "";
                }
                //чтение сделующего символа файла
                s = fis.read();
            }
        } catch (FileNotFoundException ex) {
            //если файл не найден, вывод ошибки
            System.out.println("File " + filename + " not found");
        } catch (IOException ex) {
            System.out.println("File not readable");
        } finally {
            //закрытие входного потока
            if (fis != null) {
                try {
                    fis.close();
                } catch (IOException ex) {
                    System.out.println("IO exception");
                }
            }
        }
        return strings;
    }

    //если код является символом
    private static boolean isCharacter(int s) {
        return (s >= 97 && s <= 122) || (s >= 65 && s <= 90);
    }
    
    //если код является пробелом
    private static boolean isSpace(int s){
        return s == 32;
    }

}
