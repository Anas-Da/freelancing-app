package com.example.freelancing_app.models;

public class SignUpRequest {
    public SignUpRequest() {
    }

    private boolean al_haram=false,syriatel_cash=false,usdt=false;
    private String username;
    private String first_name;
    private String second_name;
    private String country;
    private String bdate;
    private String email;
    private String phone_number;
    private String img="";
    private String password;
    private String password2;
    private String id_picture;
    private String id_picture2;

    public SignUpRequest(String username, String first_name, String second_name, String country,
                         String bdate, String email, String phone_number, String password, String password2) {
        this.username = username;
        this.first_name = first_name;
        this.second_name = second_name;
        this.country = country;
        this.bdate = bdate;
        this.email = email;
        this.phone_number = phone_number;
        this.password = password;
        this.password2 = password2;
    }


    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getPassword2() {
        return password2;
    }

    public void setPassword2(String password2) {
        this.password2 = password2;
    }



    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getFirst_name() {
        return first_name;
    }

    public void setFirst_name(String first_name) {
        this.first_name = first_name;
    }

    public String getSecond_name() {
        return second_name;
    }

    public void setSecond_name(String second_name) {
        this.second_name = second_name;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public String getBdate() {
        return bdate;
    }

    public void setBdate(String bdate) {
        this.bdate = bdate;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhone_number() {
        return phone_number;
    }

    public void setPhone_number(String phone_number) {
        this.phone_number = phone_number;
    }

    public String getImg() {
        return img;
    }

    public void setImg(String img) {
        this.img = img;
    }

    public String getId_picture() {
        return id_picture;
    }

    public void setId_picture(String id_picture) {
        this.id_picture = id_picture;
    }

    public String getId_picture2() {
        return id_picture2;
    }

    public void setId_picture2(String id_picture2) {
        this.id_picture2 = id_picture2;
    }

    public boolean isAl_haram() {
        return al_haram;
    }

    public void setAl_haram(boolean al_haram) {
        this.al_haram = al_haram;
    }

    public boolean isSyriatel_cash() {
        return syriatel_cash;
    }

    public void setSyriatel_cash(boolean syriatel_cash) {
        this.syriatel_cash = syriatel_cash;
    }

    public boolean isUsdt() {
        return usdt;
    }

    public void setUsdt(boolean usdt) {
        this.usdt = usdt;
    }

    @Override
    public String toString() {
        return "SignUpRequest{" +
                "al_haram=" + al_haram +
                ", syriatel_cash=" + syriatel_cash +
                ", usdt=" + usdt +
                ", username='" + username + '\n' +
                ", first_name='" + first_name + '\n' +
                ", second_name='" + second_name + '\n' +
                ", country='" + country + '\n' +
                ", bdate='" + bdate + '\n' +
                ", email='" + email + '\n' +
                ", phone_number='" + phone_number + '\n' +
                ", img='" + img + '\n' +
                ", password='" + password + '\n' +
                ", password2='" + password2 + '\n' +
                ", id_picture='" + id_picture.substring(0,10) + '\n' +
                ", id_picture2='" + id_picture2.substring(0,10) + '\n' +
                '}';
    }

}
