package Models;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import java.util.List;

public class Restaurants {
    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public List<String> getRating() {
        return rating;
    }

    public void setRating(List<String> rating) {
        this.rating = rating;
    }

    public List<String> getFoods() {
        return foods;
    }

    public void setFoods(List<String> foods) {
        this.foods = foods;
    }

    private String address;
    private String name;
    private String phone;
    private List<String> rating;
    private List<String> foods;

    public Restaurants(String address, String name, String phone, List<String> rating, List<String> foods) {
        this.address = address;
        this.name = name;
        this.phone = phone;
        this.rating = rating;
        this.foods = foods;
    }

    @NonNull
    @Override
    public String toString() {
        return this.name;
    }

    @Override
    public boolean equals(@Nullable Object obj) {
        return super.equals(obj);
    }
}
