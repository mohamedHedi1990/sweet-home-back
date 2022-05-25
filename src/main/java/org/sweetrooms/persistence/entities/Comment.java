package org.sweetrooms.persistence.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.*;

import javax.persistence.*;

@NoArgsConstructor
@AllArgsConstructor
@Setter
@Getter
@Entity
@Table(name = "sweet_rooms_comment")
public class Comment {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long commentId;
    private String commentText;

    @ManyToOne(cascade = CascadeType.MERGE)
    @JoinColumn(name = "announcementId")
    @JsonIgnore
    private Announcement announcement;

    @ManyToOne(cascade = CascadeType.MERGE)
    @JoinColumn(name = "userId")
    @JsonIgnore
    private User user;
}
