package org.sweetrooms.rest;

import java.io.IOException;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.Resource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;
import org.sweetrooms.business.mappers.AnnouncementMapper;
import org.sweetrooms.business.services.AnnouncementService;
import org.sweetrooms.business.services.MediaService;
import org.sweetrooms.business.services.UserService;
import org.sweetrooms.business.services.files.DBFileStorageService;
import org.sweetrooms.enumeration.MediaContext;
import org.sweetrooms.persistence.entities.Announcement;
import org.sweetrooms.persistence.entities.Media;
import org.sweetrooms.persistence.entities.Owner;
import org.sweetrooms.persistence.entities.User;

@RequestMapping("/file")
@RestController
public class FileController {
	@Autowired
	private DBFileStorageService dBFileStorageService;

	@Autowired
	private AnnouncementService announcementService;

	@Autowired
	private MediaService mediaService;

	@Autowired
	private UserService userService;

	@CrossOrigin
	@PostMapping("/post-media/{context}")
	public void uploadLogoFile(@RequestParam("file") MultipartFile[] files,
			@PathVariable("context") MediaContext context,
			@RequestParam(value = "contextId", required = false) Long contextId) {

		Arrays.stream(files).forEach(file -> {

			try {
				Media media = mediaService.saveMedia(file, context);
				if (context == MediaContext.ANNOUNCEMENT) {
					Announcement announcement = announcementService.getAnnouncementById(contextId);
					announcement.getMedias().add(media);
					announcementService.save(announcement);
				} else if (context == MediaContext.PICTURE_PROFIL) {
					User user = userService.getCurrentUser();
					if (!user.getUserMedias().isEmpty()) {
						Optional<Media> pictureProfilOp = user.getUserMedias().stream()
								.filter(userMedia -> userMedia.getMediaContext() == MediaContext.PICTURE_PROFIL).findFirst();
						Media pictureProfil = pictureProfilOp.isPresent() ? pictureProfilOp.get() : null;
						if (pictureProfil != null) {
							user.getUserMedias().remove(pictureProfil);
						}

					}
					user.getUserMedias().add(media);
					userService.saveUser(user);
				}

			} catch (Exception e) {
				e.printStackTrace();
			}

		});

		// selon le context, on fait le taraitement

	}

	@CrossOrigin
	@GetMapping("/downloadFile/{fileName:.+}")
	public ResponseEntity<Resource> downloadFile(@PathVariable String fileName, HttpServletRequest request)
			throws Exception {
		// Load file as Resource
		Resource resource = dBFileStorageService.loadFileAsResource(fileName);

		// Try to determine file's content type
		String contentType = null;
		try {
			contentType = request.getServletContext().getMimeType(resource.getFile().getAbsolutePath());
		} catch (IOException ex) {

		}

		// Fallback to the default content type if type could not be determined
		if (contentType == null) {
			contentType = "application/octet-stream";
		}

		return ResponseEntity.ok().contentType(MediaType.parseMediaType(contentType))
				.header(HttpHeaders.CONTENT_DISPOSITION, "attachment; filename=\"" + resource.getFilename() + "\"")
				.body(resource);
	}

	@CrossOrigin
	@GetMapping("delete-user-photo")
	public void deleteUserPhoto(){
		User user = userService.getCurrentUser();
		if (!user.getUserMedias().isEmpty()) {
			Optional<Media> pictureProfilOp = user.getUserMedias().stream()
					.filter(userMedia -> userMedia.getMediaContext() == MediaContext.PICTURE_PROFIL).findFirst();
			Media pictureProfil = pictureProfilOp.isPresent() ? pictureProfilOp.get() : null;
			if (pictureProfil != null) {
				user.getUserMedias().remove(pictureProfil);
			}

		}
		userService.saveUser(user);
	}

	@CrossOrigin
	@PostMapping("delete-announce-picture")
	public void deleteAnnouncementPictures(@RequestParam Long announcementId, @RequestParam String mediaUrl){
		System.out.println("img to remove "+mediaUrl);
		Owner owner = (Owner) this.userService.getCurrentUser();
		Announcement existingAnn=announcementService.getAnnouncementById(announcementId);
		System.out.println(owner.equals(existingAnn.getAnnouncementOwnerPublished()));
		if (owner != null && existingAnn!=null && owner.equals(existingAnn.getAnnouncementOwnerPublished()) && !existingAnn.getMedias().isEmpty()) {
			Optional<Media>  existingMedia=existingAnn.getMedias().stream().filter(m -> m.getMediaUrl().equals(mediaUrl)).findFirst();
			System.out.println("Media to remove : "+existingMedia.get().toString());
			if(existingMedia.get() != null) {

				existingAnn.getMedias().removeIf(url -> url.getMediaUrl().equals(mediaUrl));
				System.out.println("After removing : "+existingAnn.getMedias());

				announcementService.save(existingAnn);
			}



		}


		//announcementService.save(existingAnn);
	}

}
