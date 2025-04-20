package com.macalicestore.listing.description;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class DescriptionServiceImpl implements DescriptionService {

    private final DescriptionRepository descriptionRepository;

    public DescriptionServiceImpl(DescriptionRepository descriptionRepository) {
        this.descriptionRepository = descriptionRepository;
    }
}
