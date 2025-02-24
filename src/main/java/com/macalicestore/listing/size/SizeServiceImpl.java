package com.macalicestore.listing.size;

import com.macalicestore.listing.image.ImageService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class SizeServiceImpl implements SizeService {

    private final SizeRepository sizeRepository;

    public SizeServiceImpl(SizeRepository sizeRepository) {
        this.sizeRepository = sizeRepository;
    }

    @Transactional
    @Override
    public List<Size> findAllSizes() {
        return sizeRepository.findAll();
    }
}
