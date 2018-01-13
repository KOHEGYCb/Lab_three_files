package threefiles.IO;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import threefiles.service.Sort;

/**
 *
 * @author dmitry
 */
public class Output {

    //запись в файлы
    public static void writeFiles(ArrayList<String> strings) {
        //сортируем массив строк полученных при чтении файла
        ArrayList<String> sortStr = Sort.sortArrayString(strings);

        //создание выходного потока
        FileOutputStream fos = null;
        try {
            fos = new FileOutputStream(Constants.FILE2);
            //запись в вайл 2 отсортированных строчек
            for (int i = 0; i < sortStr.size(); i++) {
                for (int j = 0; j < sortStr.get(i).length(); j++) {
                    fos.write((int) sortStr.get(i).charAt(j));
                }
                fos.write(32);
            }

        } catch (FileNotFoundException ex) {
            Logger.getLogger(Output.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(Output.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            //закрытие выходного потока
            if (fos != null) {
                try {
                    fos.close();
                } catch (IOException ex) {
                    Logger.getLogger(Output.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        }
        //запись третьего файла
        try{
            //создание выводного потока 
            fos = new FileOutputStream(Constants.FILE3);
            //запись в вайл 3 исходных строчек
            for (int i = 0; i < strings.size(); i++) {
                for (int j = 0; j < strings.get(i).length(); j++) {
                    fos.write((int) strings.get(i).charAt(j));
                }
                fos.write(32);
            }
            //переход на новую строку
            fos.write((int) '\n');
            //запись в вайл 3 отсортированных строчек
            for (int i = 0; i < sortStr.size(); i++) {
                for (int j = 0; j < sortStr.get(i).length(); j++) {
                    fos.write((int) sortStr.get(i).charAt(j));
                }
                fos.write(32);
            }
        } catch (FileNotFoundException ex) {
            Logger.getLogger(Output.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(Output.class.getName()).log(Level.SEVERE, null, ex);
        }finally{
            //закрытие потока
            if (fos != null){
                try {
                    fos.close();
                } catch (IOException ex) {
                    Logger.getLogger(Output.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        }

    }

}
