package com.sagu.gyk401;


public class Diet {

    private int foodPicture;
    private String foodName;
    private String totalCalorie;

    public Diet(int foodPicture, String foodName, String totalCalorie) {
        this.foodPicture = foodPicture;
        this.foodName = foodName;
        this.totalCalorie = totalCalorie;
    }

    public int getFoodPicture() {
        return foodPicture;
    }

    public String getFoodName() {
        return foodName;
    }

    public String getTotalCalorie() {
        return totalCalorie;
    }
}
