package com.macalicestore.listing.listing;

import com.fasterxml.jackson.annotation.JsonSubTypes;
import com.fasterxml.jackson.annotation.JsonTypeInfo;
import com.macalicestore.listing.listing.digital.DigitalListingDTO;
import com.macalicestore.listing.listing.digital.SaveDigitalListingDTO;
import com.macalicestore.listing.listing.physical.PhysicalListingDTO;
import com.macalicestore.listing.listing.physical.SavePhysicalListingDTO;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

@JsonTypeInfo(
        include = JsonTypeInfo.As.EXISTING_PROPERTY,
        property = "listingType",
        use = JsonTypeInfo.Id.NAME,
        visible = true
)
@JsonSubTypes({
        @JsonSubTypes.Type(value = SaveDigitalListingDTO.class, name = "DIGITAL"),
        @JsonSubTypes.Type(value = SavePhysicalListingDTO.class, name = "PHYSICAL")
})
@Schema(subTypes = {SaveDigitalListingDTO.class, SavePhysicalListingDTO.class})
@Data
public class SaveListingDTO {

    private final Long id;

    private final List<MultipartFile> newImages;

    private final List<Long> existingImageIds;
}
