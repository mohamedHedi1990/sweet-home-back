package org.sweetrooms.persistence.entities;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.DiscriminatorColumn;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import org.sweetrooms.enumeration.Provider;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

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
    private String userPhoneNumber;
    private String userPassword;
    private String userLogin;
    private String userFirstName;
    private String userLastName;
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd", timezone = "Africa/Tunis")
	@Temporal(TemporalType.DATE)
    private Date userDateInscription;
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd", timezone = "Africa/Tunis")
	@Temporal(TemporalType.DATE)
    private Date userBirthDate;

    @JsonIgnore
    private boolean userIsActif;

    @ManyToOne(cascade = CascadeType.MERGE)
    private Role userRole;
    @ManyToOne
    private Position userPosition;
    @ManyToOne(cascade = CascadeType.PERSIST)
    private Address userAddress;
    @Enumerated(EnumType.STRING)
    private Provider provider;
    
    @OneToMany
    private List<Media> userMedias = new ArrayList<>();

    @OneToMany(mappedBy = "user")
    private List<Comment> comments;
}
