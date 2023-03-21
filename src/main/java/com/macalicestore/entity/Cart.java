package com.macalicestore.entity;

import lombok.Data;
import org.springframework.stereotype.Component;
import org.springframework.web.context.annotation.SessionScope;

import java.util.ArrayList;
import java.util.List;

@Data
@Component
@SessionScope
public class Cart {

    private List<Listing> listings = new ArrayList<>();

    public void add(Listing listing) {
        listings.add(listing);
    }

    public void clear() {
        listings.clear();
    }
}
