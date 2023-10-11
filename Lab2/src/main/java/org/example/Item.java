package org.example;

public abstract class Item {
    public String Title;
    public String uniqueID;
    public boolean isBorrowed;
    public Item(String title, String uniqueID) {
        this.Title = title;
        this.uniqueID = uniqueID;
        this.isBorrowed = false;
    }

    public String getTitle() {
        return Title;
    }

    public void setTitle(String title) {
        this.Title = title;
    }

    public String getUniqueID() {
        return uniqueID;
    }

    public void setUniqueID(String uniqueID) {
        this.uniqueID = uniqueID;
    }

    public boolean isBorrowed() {
        return isBorrowed;
    }

    public void setBorrowed(boolean borrowed) {
        isBorrowed = borrowed;
    }

    public abstract void borrowItem();

    public abstract void returnItem();


}
