package com.gabe2max.epithet.user;

import java.util.List;

public abstract class UserManager {
    //This feels wrong:
    public static UserManager INSTANCE = new MocUserManager();
    public abstract List<User> getUsers();
    public abstract User getCurrentUser();
    public abstract User getUserByUsername(String name);
}
