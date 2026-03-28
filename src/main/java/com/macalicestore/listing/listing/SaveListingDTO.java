package com.macalicestore.listing.listing;

import com.fasterxml.jackson.annotation.JsonSubTypes;
import com.fasterxml.jackson.annotation.JsonTypeInfo;
import com.macalicestore.listing.listing.digital.SaveDigitalListingDTO;
import com.macalicestore.listing.listing.physical.SavePhysicalListingDTO;
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
@Data
public class SaveListingDTO {

    private Long id;

    private List<ImageDTO> images;

    @JsonTypeInfo(
            include = JsonTypeInfo.As.EXISTING_PROPERTY,
            property = "imageType",
            use = JsonTypeInfo.Id.NAME,
            visible = true
    )
    @JsonSubTypes({
            @JsonSubTypes.Type(value = NewImageDTO.class, name = "NEW"),
            @JsonSubTypes.Type(value = ExistImageDTO.class, name = "EXIST")
    })
    @Data
    public static class ImageDTO {

        private int position;

        private String imageType;
    }

    @Data
    public static class NewImageDTO extends ImageDTO {

        private MultipartFile image;
    }

    @Data
    public static class ExistImageDTO extends ImageDTO {

        private Long id;
    }
}
