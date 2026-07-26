package com.store.product.attachement;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.Data;

@Data
@Entity
public class Attachment {

    @Id
    private Long id;
}
