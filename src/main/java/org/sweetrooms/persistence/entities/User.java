package org.sweetrooms.persistence.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.sweetrooms.enumeration.Provider;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

@Entity
@Table(name = "sweet_rooms_user")
@Data
@NoArgsConstructor
@AllArgsConstructor
@Inheritance(strategy=InheritanceType.SINGLE_TABLE)
@DiscriminatorColumn(name="user_type")
public  class User extends AuditableSql implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long userId;
    private String userEmail;
    private String userPassword;
    private String userLogin;
    private String userFirstName;
    private String userLastName;
    private Date userDateInscription;
    private Date userBirthDate;

    @JsonIgnore
    private boolean userIsActif;

    @ManyToOne
    private Role userRole;
    @ManyToOne
    private Position userPosition;
    @ManyToOne
    private Address userAddress;
    @Enumerated(EnumType.STRING)
    private Provider provider;
}
