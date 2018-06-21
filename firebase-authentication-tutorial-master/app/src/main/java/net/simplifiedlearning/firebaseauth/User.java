package net.simplifiedlearning.firebaseauth;

import java.io.Serializable;

public class User implements Serializable {

    private String idUser;
    private String emailUser;
    private String nicknameUser;
    private String linkAvatarUser;
    private String birthDayUser;
    private String genderUser;
    private String phoneNumberUser;
    private String addressUser;

    public User() {
    }

    public User(String idUser, String emailUser, String nicknameUser,
                String linkAvatarUser, String birthDayUser, String genderUser,
                String phoneNumberUser, String addressUser) {

        this.idUser = idUser;
        this.emailUser = emailUser;
        this.nicknameUser = nicknameUser;
        this.linkAvatarUser = linkAvatarUser;
        this.birthDayUser = birthDayUser;
        this.genderUser = genderUser;
        this.phoneNumberUser = phoneNumberUser;
        this.addressUser = addressUser;
    }

    public String getIdUser() {
        return idUser;
    }

    public void setIdUser(String idUser) {
        this.idUser = idUser;
    }

    public String getEmailUser() {
        return emailUser;
    }

    public void setEmailUser(String emailUser) {
        this.emailUser = emailUser;
    }

    public String getNicknameUser() {
        return nicknameUser;
    }

    public void setNicknameUser(String nicknameUser) {
        this.nicknameUser = nicknameUser;
    }

    public String getLinkAvatarUser() {
        return linkAvatarUser;
    }

    public void setLinkAvatarUser(String linkAvatarUser) {
        this.linkAvatarUser = linkAvatarUser;
    }

    public String getBirthDayUser() {
        return birthDayUser;
    }

    public void setBirthDayUser(String birthDayUser) {
        this.birthDayUser = birthDayUser;
    }

    public String getGenderUser() {
        return genderUser;
    }

    public void setGenderUser(String genderUser) {
        this.genderUser = genderUser;
    }

    public String getPhoneNumberUser() {
        return phoneNumberUser;
    }

    public void setPhoneNumberUser(String phoneNumberUser) {
        this.phoneNumberUser = phoneNumberUser;
    }

    public String getAddressUser() {
        return addressUser;
    }

    public void setAddressUser(String addressUser) {
        this.addressUser = addressUser;
    }
}
