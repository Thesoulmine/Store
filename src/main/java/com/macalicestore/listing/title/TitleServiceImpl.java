package com.macalicestore.listing.title;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class TitleServiceImpl implements TitleService {

    private final TitleRepository titleRepository;

    public TitleServiceImpl(TitleRepository titleRepository) {
        this.titleRepository = titleRepository;
    }
}
