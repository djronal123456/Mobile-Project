package ca.gbc.myapplication;

public class Restaurant {

    private String name;
    private String address;
    private String phone;
    private String description;
    private Boolean isVegetarian;
    private Boolean isVegan;
    private Boolean isOrganic;
    private Boolean isEuropean;
    private Boolean isAsian;
    private Boolean isOther;

    public Restaurant(String name, String address, String phone, String description, Boolean isVegetarian, Boolean isVegan, Boolean isOrganic, Boolean isEuropean, Boolean isAsian, Boolean isOther) {
        this.name = name;
        this.address = address;
        this.phone = phone;
        this.description = description;
        this.isVegetarian = isVegetarian;
        this.isVegan = isVegan;
        this.isOrganic = isOrganic;
        this.isEuropean = isEuropean;
        this.isAsian = isAsian;
        this.isOther = isOther;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Boolean getVegetarian() {
        return isVegetarian;
    }

    public void setVegetarian(Boolean vegetarian) {
        isVegetarian = vegetarian;
    }

    public Boolean getVegan() {
        return isVegan;
    }

    public void setVegan(Boolean vegan) {
        isVegan = vegan;
    }

    public Boolean getOrganic() {
        return isOrganic;
    }

    public void setOrganic(Boolean organic) {
        isOrganic = organic;
    }

    public Boolean getEuropean() {
        return isEuropean;
    }

    public void setEuropean(Boolean european) {
        isEuropean = european;
    }

    public Boolean getAsian() {
        return isAsian;
    }

    public void setAsian(Boolean asian) {
        isAsian = asian;
    }

    public Boolean getOther() {
        return isOther;
    }

    public void setOther(Boolean other) {
        isOther = other;
    }
}
