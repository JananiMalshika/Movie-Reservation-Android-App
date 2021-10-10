package com.example.blueskycinema.Janani;

public class FoodModelClass {
    String  foodID, FoodName, FoodPrice;

    public FoodModelClass(String foodID, String foodName, String foodPrice) {
        this.foodID = foodID;
        FoodName = foodName;
        FoodPrice = foodPrice;
    }

    public String getFoodID() {
        return foodID;
    }

    public void setFoodID(String foodID) {
        this.foodID = foodID;
    }

    public String getFoodName() {
        return FoodName;
    }

    public void setFoodName(String foodName) {
        FoodName = foodName;
    }

    public String getFoodPrice() {
        return FoodPrice;
    }

    public void setFoodPrice(String foodPrice) {
        FoodPrice = foodPrice;
    }
}
