package com.macalicestore.listing.description;

import org.springframework.transaction.annotation.Transactional;

public interface DescriptionService {
    @Transactional
    Description findDescriptionByTextOrElseNull(String text);
}
