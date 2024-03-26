package controller;

import model.User;
import storage.ReadWriteFile;

import java.util.List;

public class UserManager {
    private static List<User> userList = ReadWriteFile.readFile();

    public static void addNewUser(User user){
        userList.add(user);
        ReadWriteFile.writeFile(userList);
    }
}
