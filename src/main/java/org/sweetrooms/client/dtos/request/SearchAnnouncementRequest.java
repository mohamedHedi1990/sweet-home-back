package org.sweetrooms.client.dtos.request;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;
import org.sweetrooms.dtos.AnnouncementSearchCriteria;

@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class SearchAnnouncementRequest {

    private AnnouncementSearchCriteria searchCriteria=new AnnouncementSearchCriteria();
    private int currentPage;
    private int size;
}