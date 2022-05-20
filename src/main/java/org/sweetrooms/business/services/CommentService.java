package org.sweetrooms.business.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.sweetrooms.persistence.entities.Announcement;
import org.sweetrooms.persistence.entities.Comment;
import org.sweetrooms.persistence.entities.Lodger;
import org.sweetrooms.persistence.entities.User;
import org.sweetrooms.persistence.repositories.CommentRepository;
import org.sweetrooms.utils.SecurityUtil;

@Service
public class CommentService {
    @Autowired
    CommentRepository commentRepository;

    @Autowired
    UserService userService;

    @Autowired
    AnnouncementService announcementService;

    public void comentAnnouncement(Long announcementId, String commentText){
        System.out.println("id : "+SecurityUtil.getCurrentUserId());
        User user=userService.getUserById(SecurityUtil.getCurrentUserId());
        Announcement announcement = announcementService.getAnnouncementById(announcementId);

        Comment comment=new Comment();
        comment.setAnnouncement(announcement);
        comment.setUser(user);
        comment.setCommentText(commentText);

        commentRepository.save(comment);

    }
}
