package threefiles;

import threefiles.IO.Constants;
import threefiles.IO.Input;
import threefiles.IO.Output;

/**
 *
 * @author dmitry
 */
public class ThreeFiles {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        //вывод в файлы
        Output.writeFiles(Input.readFile(Constants.FILE1)); 
        
    }
    
}
