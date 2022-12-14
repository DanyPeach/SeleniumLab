package com.dudessa.pageobject.service;
import com.dudessa.pageobject.constants.UserTestConsts;
import com.dudessa.pageobject.model.User;

import static com.dudessa.pageobject.constants.UserTestConsts.*;

public class UserCreator {
    public static final String TESTDATA_USER_NAME = USER1_EMAIL;
    public static final String TESTDATA_USER_PASSWORD = USER1_PASSWORD;

    public static User withCredentialsFromProperty(){
        return new User(TESTDATA_USER_NAME, TESTDATA_USER_PASSWORD);
    }

    public static User withEmptyUsername(){
        return new User("", TESTDATA_USER_PASSWORD);
    }

    public static User withEmptyPassword(){
        return new User(TESTDATA_USER_NAME, "");
    }
}
