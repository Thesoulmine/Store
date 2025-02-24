package com.macalicestore.listing.size;

import org.springframework.transaction.annotation.Transactional;

import java.util.List;

public interface SizeService {
    @Transactional
    List<Size> findAllSizes();
}
