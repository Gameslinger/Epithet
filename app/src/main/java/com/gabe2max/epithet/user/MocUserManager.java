package com.gabe2max.epithet.user;

import com.gabe2max.epithet.Util;

import java.util.ArrayList;
import java.util.List;

public class MocUserManager implements UserManager {
    //TODO: Change to less static path, move to internal data directory?
    static String PATH = "/storage/emulated/0/Android/data/com.gabe2max.epithet/files/data/profilePictures/";

    @Override
    public User getCurrentUser(){
        return new User("LabelKing15", Util.getBitMap(PATH+"labelKing15.jpg"),99,75000);

    }
    @Override
    public List<User> getUsers() {
        List<User> users = new ArrayList<>();
        //Add moc users to load.
        users.add(new User("User123", Util.getBitMap(PATH+"user123.jpg"),7,15000));
        users.add(new User("HelloKitty", Util.getBitMap(PATH+"helloKitty.png"),14,99000));
        users.add(new User("LabelKing15", Util.getBitMap(PATH+"labelKing15.jpg"),99,75000));
        users.add(new User("I_Rock", Util.getBitMap(PATH+"iRock.png"),7,14000));
        users.add(new User("Neo", Util.getBitMap(PATH+"neo.jpg"),7,13000));
        users.add(new User("Caveman", Util.getBitMap(PATH+"caveman.jpg"),7,12000));
        users.add(new User("Grandma", Util.getBitMap(PATH+"grandma.jpg"),7,11000));

        return users;
    }
}
