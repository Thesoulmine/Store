package com.macalicestore.listing.description;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class DescriptionServiceImpl implements DescriptionService {

    private final DescriptionRepository descriptionRepository;

    public DescriptionServiceImpl(DescriptionRepository descriptionRepository) {
        this.descriptionRepository = descriptionRepository;
    }

    @Transactional
    @Override
    public Description findDescriptionByTextOrElseNull(String text) {
        return descriptionRepository.findByText(text).orElse(null);
    }
}
