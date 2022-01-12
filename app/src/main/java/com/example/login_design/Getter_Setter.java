package com.example.login_design;

import java.util.ArrayList;

public class Getter_Setter extends ArrayList<Getter_Setter> {
    public String getButton() {
        return Button;
    }

    public void setButton(String button) {
        Button = button;
    }

    String Button;
    public int getImage() {
        return Image;
    }

    public void setImage(int image) {
        Image = image;
    }

    public String getName() {
        return Name;
    }

    public void setName(String name) {
        Name = name;
    }

    public String getCapacity() {
        return Capacity;
    }

    public void setCapacity(String capacity) {
        Capacity = capacity;
    }

    public String getContact() {
        return Contact;
    }

    public void setContact(String contact) {
        Contact = contact;
    }

    public String getLocation() {
        return Location;
    }

    public void setLocation(String location) {
        Location = location;
    }

    int Image;
    String Name,Capacity,Contact,Location;
}
