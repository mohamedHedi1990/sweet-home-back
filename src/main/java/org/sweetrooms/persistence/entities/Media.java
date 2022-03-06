package org.sweetrooms.persistence.entities;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.sweetrooms.enumeration.MediaContext;

import javax.persistence.*;

@Entity
@Table(name = "sweet_rooms_media")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Media {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long mediaId;
    private String mediaLabel;
    private Double mediaSize;
    private String mediaUrl;
    @Enumerated(EnumType.STRING)
    private MediaContext mediaContext;
}
