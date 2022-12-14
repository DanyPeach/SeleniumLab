package com.dudessa.pageobject.model;

public class User {
    private String userMail;
    private String password;

    public User(String userMail, String password) {
        this.userMail = userMail;
        this.password = password;
    }

    public String getUserMail() {
        return userMail;
    }

    public void setUserMail(String userMail) {
        this.userMail = userMail;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof User)) return false;

        User user = (User) o;

        if (getUserMail() != null ? !getUserMail().equals(user.getUserMail()) : user.getUserMail() != null)
            return false;
        return getPassword() != null ? getPassword().equals(user.getPassword()) : user.getPassword() == null;
    }

    @Override
    public int hashCode() {
        int result = getUserMail() != null ? getUserMail().hashCode() : 0;
        result = 31 * result + (getPassword() != null ? getPassword().hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        return "User{" +
                "userMail='" + userMail + '\'' +
                ", password='" + password + '\'' +
                '}';
    }
}
