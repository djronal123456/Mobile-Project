package ca.gbc.myapplication;

public class RestaurantList {

    private int maxNum;
    private int minNum;
    private Restaurant restaurantList[];

    public RestaurantList(int maxNum) {
        this.maxNum = maxNum;
        this.minNum = 0;
        this.restaurantList = new Restaurant[maxNum];
    }

    public boolean addRestaurant(String name, String address, String phone, String description, Boolean isVegetarian, Boolean isVegan, Boolean isOrganic, Boolean isEuropean, Boolean isAsian, Boolean isOther) {
        if (minNum < maxNum) {
            restaurantList[minNum] = new Restaurant(name, address, phone, description, isVegetarian, isVegan, isOrganic, isEuropean, isAsian, isOther);
        }
        return false;
    }

    public Restaurant findRestaurant(int index) {
        if (index >= minNum) {
            return restaurantList[index];
        }
        return null;
    }
}
