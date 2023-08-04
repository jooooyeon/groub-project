package kr.or.ddit.util;

import java.io.File;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.nio.file.Files;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.core.io.FileSystemResource;
import org.springframework.core.io.Resource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * @author 김종명
 *
 */
@Controller
public class CommonFile {
	/**
	 * log
	 */
	private static final Logger log = LoggerFactory.getLogger(CommonFile.class);

	/**
	 * Bbs 첨부파일 업로드 경로
	 */
	public static final String uploadFolderBbs = "C:\\final_proj\\workspace\\groub\\src\\main\\webapp\\resources\\bbsUpload";
	
	/**
	 * 메일 첨부파일 업로드 경로
	 */
	public static final String uploadFolderMail = "C:\\final_proj\\workspace\\groub\\src\\main\\webapp\\resources\\mailUpload";
	
	/**
	 * 내정보 사진 업로드 경로
	 */
	public static final String uploadFolderUserPic = "C:\\final_proj\\workspace\\groub\\src\\main\\webapp\\resources\\image\\user\\photo";
	/**
	 * 내정보 서명 업로드 경로
	 */
	public static final String uploadFolderUserSign = "C:\\final_proj\\workspace\\groub\\src\\main\\webapp\\resources\\image\\user\\sign";
	/**
	 * 기안 첨부 파일 업로드 경로
	 */
	public static final String uploadFolderDraft = "C:\\final_proj\\workspace\\groub\\src\\main\\webapp\\resources\\draft";

	
	/**
	 * 이미지 체킹여부
	 * @param file
	 * @return boolean
	 */
	public static boolean checkImageType(File file) {
		String contentType;

		try {
			contentType = Files.probeContentType(file.toPath());
			log.info("contentType : " + contentType);

			return contentType.startsWith("image");
		} catch (IOException e) {
			e.printStackTrace();
		}
		return false;

	}

	/**
	 * 연/월/일 폴더 생성
	 * @return String
	 */
	public static String getFolder() {
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		Date date = new Date();
		String str = sdf.format(date);

		return str.replace("-", File.separator);
	}

	/**
	 * 파일 다운로드 경로
	 * @param String filename
	 * @param String sort 
	 * @return
	 */
	@ResponseBody
	@GetMapping(value = "/download", produces = MediaType.APPLICATION_OCTET_STREAM_VALUE)
	public ResponseEntity<Resource> download(String filename, String sort) {
		log.info("filename : " + filename);
		String path = "";
		if(sort.equals("bbs")) path = CommonFile.uploadFolderBbs;
		if(sort.equals("mail")) path = CommonFile.uploadFolderMail;
		if(sort.equals("draft")) path = CommonFile.uploadFolderDraft;

		Resource resource = new FileSystemResource(path + filename);

		log.info("path : " + (path + filename));
		String resourceName = resource.getFilename();
		String[] resourceNameArr = resourceName.split("_");
		log.info("resourceName : " + resourceName);

		HttpHeaders headers = new HttpHeaders();
		try {
			headers.add("Content-Disposition", "attachment;filename="
					+ new String(resourceNameArr[resourceNameArr.length - 1].getBytes("UTF-8"), "ISO-8859-1"));

		} catch (UnsupportedEncodingException e) {
			return new ResponseEntity<Resource>(null, headers, HttpStatus.NOT_FOUND);
		}
		return new ResponseEntity<Resource>(resource, headers, HttpStatus.OK);
	}

}
