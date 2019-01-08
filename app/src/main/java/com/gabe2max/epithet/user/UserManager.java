package com.gabe2max.epithet.user;

import java.util.List;

public interface UserManager {
    List<User> getUsers();
    User getCurrentUser();
}
