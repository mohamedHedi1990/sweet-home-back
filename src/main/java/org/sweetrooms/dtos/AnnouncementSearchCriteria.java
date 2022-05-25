package org.sweetrooms.dtos;

import java.util.Date;

import lombok.ToString;
import org.sweetrooms.enumeration.AnnouncementType;

import com.fasterxml.jackson.annotation.JsonFormat;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class AnnouncementSearchCriteria {
    String announcementCityLabel;
    @JsonFormat( shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd",timezone = "Africa/Tunis")
    Date announcementStartDate;
    @JsonFormat( shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd",timezone = "Africa/Tunis")
    Date announcementEndDate;
    Integer nbGuest;
    AnnouncementType announcementType;
}
