package org.sweetrooms.dtos;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class CommentDto {
    private String commentText;
    private UserDto writer;
}
