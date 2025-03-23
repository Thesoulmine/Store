package com.macalicestore.listing.listing;

import com.macalicestore.listing.listingsgroup.ListingsGroup;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

@EqualsAndHashCode(callSuper = true)
@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "digital_product_listings")
@DiscriminatorValue("digital_listing")
public class DigitalListing extends Listing {

    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "listing_group_id")
    private ListingsGroup listingsGroup;
}
