package org.sweetrooms.rest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.sweetrooms.business.services.CommentService;
import org.sweetrooms.dtos.CommentDto;
import org.sweetrooms.persistence.repositories.CommentRepository;

@RestController
@RequestMapping("/comment")
@CrossOrigin("*")
public class CommentController {

    @Autowired
    CommentService commentService;

    @PostMapping("/comment-announce")
    public void commentAnnounce(@RequestParam("idAnnounce") Long announceId, @RequestBody CommentDto commentDto){
        commentService.comentAnnouncement(announceId, commentDto.getCommentText());
    }
}
