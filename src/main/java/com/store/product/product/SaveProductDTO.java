package com.store.product.product;

import com.fasterxml.jackson.annotation.JsonSubTypes;
import com.fasterxml.jackson.annotation.JsonTypeInfo;
import jakarta.servlet.http.HttpServletRequest;
import lombok.Data;
import org.springframework.stereotype.Component;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.support.StandardMultipartHttpServletRequest;
import tools.jackson.core.JacksonException;
import tools.jackson.core.JsonParser;
import tools.jackson.databind.DeserializationContext;
import tools.jackson.databind.ValueDeserializer;
import tools.jackson.databind.annotation.JsonDeserialize;

import java.util.List;

@Data
public class SaveProductDTO extends ProductDTO {

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

        private ImageDtoType imageType;
    }

    @Data
    public static class NewImageDTO extends ImageDTO {

        @JsonDeserialize(using = MultipartFileDeserializer.class)
        private MultipartFile image;
    }

    @Data
    public static class ExistImageDTO extends ImageDTO {

        private Long id;
    }

    @Component
    private static class MultipartFileDeserializer extends ValueDeserializer<MultipartFile> {

        @Override
        public MultipartFile deserialize(JsonParser p, DeserializationContext ctxt) throws JacksonException {
            HttpServletRequest request = ((ServletRequestAttributes) RequestContextHolder.getRequestAttributes()).getRequest();
            StandardMultipartHttpServletRequest multipartHttpServletRequest = new StandardMultipartHttpServletRequest(request);
            return multipartHttpServletRequest.getMultiFileMap().get("images[%s]".formatted(p.readValueAsTree())).getFirst();
        }
    }
}
