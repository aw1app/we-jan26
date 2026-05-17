import java.io.*;

public class ExceptionsDemo {

    public static void main(String[] args) {
        int x = 100;
        int y = 0;

//    if ( y != 0 )
// System.out.println(" x/y = " + x/y);

        FileWriter f = null;
        try {
            f = new FileWriter("F:\\Users\\home\\git\\sl-jan26\\PHASE3\\a.txt");
            f.write("Hello");
        }catch (FileNotFoundException fexp) {
            System.out.println(" Hey some thing went wrong! contact customer care " + fexp.getMessage());
        }
        catch (IOException ex) {
            System.out.println(" Hey some thing went wrong! contact customer care " + ex.getMessage());
        }
        finally {
            try {
                if (f != null)
                    f.close(); // best practice - we should always close the file
            } catch (IOException ex) {
                System.out.println(" Hey some thing went wrong! contact customer care " + ex.getMessage());
            }
        }



//    int[] myArr = {4,5,99,100};
//    System.out.println(" myArr[5] = " + myArr[5]);

        System.out.println(" End of program ");
    }

}
