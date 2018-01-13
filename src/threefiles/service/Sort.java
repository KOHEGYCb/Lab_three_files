package threefiles.service;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;

/**
 *
 * @author dmitry
 */
public class Sort {

    public static ArrayList<String> sortArrayString(ArrayList<String> strings) {
        //создание массива строк
        String[] str = new String[strings.size()];

        for (int i = 0; i < str.length; i++) {
            str[i] = strings.get(i);
        }
        //сортировка массива
        Arrays.sort(str);
        //содание из массива ArrayList
        ArrayList<String> sort = new ArrayList<String>();
        for (int i = 0; i < str.length; i++) {
            sort.add(str[i]);
        }

        return sort;
    }

}
