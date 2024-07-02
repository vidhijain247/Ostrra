package date0207;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

public class FileioMain {
    public static void main(String[] args) throws IOException{
        File file = new File("myfile.txt");
        FileOutputStream fos = new FileOutputStream(file);
        DataOutputStream dos = new DataOutputStream(fos);

        dos.writeUTF("Hello");
        dos.writeUTF("Test");

        FileInputStream fis = new FileInputStream(file);
        DataInputStream dis = new DataInputStream(fis);
        String msg = dis.readUTF();
        System.out.println(msg);
        
    }
}
