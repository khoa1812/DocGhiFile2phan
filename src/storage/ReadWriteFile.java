package storage;

import model.User;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class ReadWriteFile {

    public static final String PATHNAME = "c01.dat";

    public static void writeFile(List<User> user){
        File a = new File(PATHNAME);
        try {
            OutputStream outputStream = new FileOutputStream(a);
            ObjectOutputStream oos =  new ObjectOutputStream(outputStream);
            oos.writeObject(user);
            oos.close();
            outputStream.close();
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }


    public static List<User> readFile(){
        File a = new File(PATHNAME);
        try {
            InputStream is = new FileInputStream(a);
            ObjectInputStream ois = new ObjectInputStream(is);
            Object object = ois.readObject();
            return (List<User>) object;
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
    }

    public static void main(String[] args) {
        List<User> l = readFile();
        System.out.println(l);
    }
}
