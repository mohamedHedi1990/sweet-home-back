package org.sweetrooms.client.dtos.response;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class SearchAnnouncementResponse {

    private List<AnnouncementResponse> announcementResponseList;
    private Long totalItems;
}
