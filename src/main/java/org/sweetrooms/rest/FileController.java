package org.sweetrooms.rest;

import java.io.IOException;
import java.util.Arrays;

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
import org.sweetrooms.business.services.AnnouncementService;
import org.sweetrooms.business.services.MediaService;
import org.sweetrooms.business.services.files.DBFileStorageService;
import org.sweetrooms.enumeration.MediaContext;
import org.sweetrooms.persistence.entities.Announcement;
import org.sweetrooms.persistence.entities.Media;

@RequestMapping("/file")
@RestController
public class FileController {
	@Autowired
	private DBFileStorageService dBFileStorageService;

	@Autowired
	private AnnouncementService announcementService;

	@Autowired
	private MediaService mediaService;

	@CrossOrigin
	@PostMapping("/post-media/{context}")
	public void uploadLogoFile(@RequestParam("file") MultipartFile[] files,
			@PathVariable("context") MediaContext context, @RequestParam(value="contextId", required = false) Long contextId) {

		Arrays.stream(files).forEach(file -> {

			try {
				Media media = mediaService.saveMedia(file, context);
				if (context == MediaContext.ANNOUNCEMENT) {
					Announcement announcement = announcementService.getAnnouncementById(contextId);
					announcement.getAnnouncementMedias().add(media);
					announcementService.save(announcement);
				}

			} catch (Exception e) {
				// TODO Auto-generated catch block
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

}
