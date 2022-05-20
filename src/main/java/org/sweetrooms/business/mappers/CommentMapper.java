package org.sweetrooms.business.mappers;

import org.sweetrooms.dtos.CommentDto;
import org.sweetrooms.persistence.entities.Comment;

public class CommentMapper {

    public static CommentDto toCommentDto(Comment comment){
        return new CommentDto(comment.getCommentText(), UserMapper.toUserDto(comment.getUser()));
    }
}
