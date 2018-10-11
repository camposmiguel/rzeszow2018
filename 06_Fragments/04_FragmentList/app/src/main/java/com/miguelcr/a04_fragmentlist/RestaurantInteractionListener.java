package com.miguelcr.a04_fragmentlist;

import com.miguelcr.a04_fragmentlist.Restaurant;

public interface RestaurantInteractionListener {
    void showRestaurantDetail(Restaurant restaurant);
    void updateRestauntRate(Restaurant restaurant, float newRate);
}
