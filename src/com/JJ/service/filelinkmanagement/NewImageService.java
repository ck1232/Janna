package com.JJ.service.filelinkmanagement;

import java.awt.image.BufferedImage;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.URL;
import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

import javax.imageio.ImageIO;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.io.FilenameUtils;
import org.apache.commons.lang3.StringUtils;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.PropertySource;
import org.springframework.context.annotation.PropertySources;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.JJ.TO.FileLinkTO;
import com.JJ.TO.ImageLinkRsTO;
import com.JJ.TO.ProductTO;
import com.JJ.controller.common.vo.FileMetaVO;
import com.JJ.controller.common.vo.ImageLinkVO;
import com.JJ.helper.GeneralUtils;
import com.JJ.helper.IntegerComparator;
@PropertySources({
	@PropertySource(value = "classpath:admin-dev-config.properties", ignoreResourceNotFound = false),
	@PropertySource(value = "file:C:\\Inetpub\\vhosts\\ziumlight.com\\Configuration\\application-${spring.profiles.active}.properties", ignoreResourceNotFound=true)
})
@Service
@Scope("prototype")
@Transactional(rollbackFor=Exception.class, propagation = Propagation.REQUIRED)
public class NewImageService {
	private static final Logger logger = Logger.getLogger(NewImageService.class);
	@Value("${image.noImageFilePath}")
	private String noImageFilePath;
	
	@Value("${image.imageUrl}")
	private String imageUrl;
	
	@Value("${image.folder}")
    private String imageFolderSource;

	public static LinkedList<ImageLinkVO> convertToImageLinkVOMapOrdered(List<ImageLinkRsTO> imageLinkRsTOList) {
		LinkedList<ImageLinkVO> imageLinkedList = new LinkedList<ImageLinkVO>();
		if(imageLinkRsTOList != null && !imageLinkRsTOList.isEmpty()){
			IntegerComparator comparator = new IntegerComparator("sequence");
			Collections.sort(imageLinkRsTOList, comparator);
			for(ImageLinkRsTO rsTO : imageLinkRsTOList) {
				FileLinkTO fileLinkTO = rsTO.getFileLinkTO();
				if(fileLinkTO!=null){
					ImageLinkVO vo = new ImageLinkVO();
					vo.setImageLinkId(fileLinkTO.getFileLinkId());
					vo.setImagePath(fileLinkTO.getFilePath());
					vo.setContentType(fileLinkTO.getContentType());
					if(fileLinkTO.getFilePath() != null && !fileLinkTO.getFilePath().trim().isEmpty()){
						String fileName = FilenameUtils.getName(fileLinkTO.getFilePath());
						vo.setFileName(fileName);
					}
					vo.setDisplayPath(vo.getDisplayPath());
					vo.setSequence(rsTO.getSequence());
					vo.setImageLinkRsId(rsTO.getImageLinkRsId());
					vo.setRefType(rsTO.getRefType());
					imageLinkedList.add(vo);
				}
			}
		}
		return imageLinkedList;
	}
	
	public ImageLinkVO readImageFromURL(ImageLinkVO imageLinkVO) {
		try{
			String imageUrlLink = imageUrl+imageLinkVO.getImagePath();
			URL url = new URL(imageUrlLink.replaceAll("\\\\", "/"));
			logger.debug("url:"+url.getFile());
	        BufferedImage image = ImageIO.read(url);
	        String fileFormat = FilenameUtils.getExtension(url.getPath());
	        ByteArrayOutputStream baos = new ByteArrayOutputStream();
	        ImageIO.write(image, fileFormat, baos);
			imageLinkVO.setBytes(baos.toByteArray());
		}catch(Exception ex){
			logger.error("readImageFromURL", ex);
		}
		return imageLinkVO;
	}
	
	public void getNoFileFoundImage(HttpServletResponse response){
		InputStream is;
		try {
			File file = new File(noImageFilePath);
			is = new FileInputStream(file);
			ByteArrayOutputStream bos=new ByteArrayOutputStream();
			int b;
			byte[] buffer = new byte[1024];
			while((b=is.read(buffer))!=-1){
			   bos.write(buffer,0,b);
			}
			byte[] fileBytes=bos.toByteArray();
			is.close();
			bos.close();
			response.setContentType("image/jpeg");
			response.getOutputStream().write(fileBytes,0,fileBytes.length);
			response.getOutputStream().flush();  
			return;
		} catch (Exception e) {
			logger.error("getProductImage-2: Exception", e);
		}
	}
	
	public static LinkedList<ImageLinkVO> convertFileMetaVOListToImageLinkVOList(List<FileMetaVO> fileVOList, String type) {
		LinkedList<ImageLinkVO> imageLinkVOList = new LinkedList<ImageLinkVO>();
		if(fileVOList != null && !fileVOList.isEmpty()){
			for(FileMetaVO fileVO : fileVOList){
				ImageLinkVO imageVO = new ImageLinkVO();
				imageVO.setRefType(type);
				imageVO.setImagePath(type+"\\"+fileVO.getFileName());
				imageVO.setSequence(fileVO.getSequence());
				imageVO.setFileName(fileVO.getFileName());
				imageVO.setBytes(fileVO.getBytes());
				imageVO.setImageLinkRsId(fileVO.getImageId());
				imageVO.setContentType(fileVO.getFileType());
				imageLinkVOList.add(imageVO);
			}
		}
		return imageLinkVOList;
	}
	
	public static LinkedList<FileMetaVO> convertImageLinkVOToFileMetaVO(LinkedList<ImageLinkVO> imageLinkVOList) {
		LinkedList<FileMetaVO> fileMetaVOList = new LinkedList<FileMetaVO>();
		if(imageLinkVOList != null && !imageLinkVOList.isEmpty()){
			for(ImageLinkVO image: imageLinkVOList){
				FileMetaVO metaVO = new FileMetaVO();
				metaVO.setFileName(image.getFileName());
				metaVO.setFileType(image.getContentType());
				metaVO.setFileSize("100KB");
				metaVO.setImageId(image.getImageLinkRsId());
				metaVO.setSequence(image.getSequence());
				fileMetaVOList.add(metaVO);
			}
		}
		return fileMetaVOList;
	}
	
	public void setProductImage(List<ImageLinkVO> imageLinkRsVOList, ProductTO productTO){
		//delete all current image
		Map<Long, ImageLinkRsTO> toMap = GeneralUtils.convertListToLongMap(productTO.getImageLinkRsTOList(), "imageLinkRsId");
		if(productTO.getImageLinkRsTOList() != null && !productTO.getImageLinkRsTOList().isEmpty()){
			for(ImageLinkRsTO to : productTO.getImageLinkRsTOList()){
				to.setDeleteInd(GeneralUtils.DELETED);
			}
		}else{
			productTO.setImageLinkRsTOList(new ArrayList<ImageLinkRsTO>());
		}
		//change those inside VOList to NOT_DELTED, and set new sequence, if new VO then insert into List
		if(imageLinkRsVOList != null && !imageLinkRsVOList.isEmpty()){
			for(ImageLinkVO vo : imageLinkRsVOList){
				ImageLinkRsTO to = toMap.get(vo.getImageLinkRsId());
				if(to != null){
					to.setDeleteInd(GeneralUtils.NOT_DELETED);
					to.setSequence(vo.getSequence());
				}else{
					boolean success = uploadFileToDisk(vo);
					if(!success)continue;
					ImageLinkRsTO newTO = convertToProductImageLinkRsTOList(vo, productTO);
					if(newTO != null){
						productTO.getImageLinkRsTOList().add(newTO);
					}
				}
			}
		}
	}
	
	public static ImageLinkRsTO convertToProductImageLinkRsTOList(ImageLinkVO imageLinkRsVO, ProductTO productTO){
		if(imageLinkRsVO != null){
			ImageLinkRsTO rsTO = new ImageLinkRsTO();
			rsTO.setImageLinkRsId(imageLinkRsVO.getImageLinkRsId());
			rsTO.setRefType(GeneralUtils.TYPE_PRODUCT);
			rsTO.setProductTO(productTO);
			rsTO.setFileLinkTO(convertToFileLinkTO(imageLinkRsVO));
			rsTO.setSequence(imageLinkRsVO.getSequence());
			return rsTO;
		}
		return null;
	}
	
	public static FileLinkTO convertToFileLinkTO(ImageLinkVO vo){
		FileLinkTO to = new FileLinkTO();
		to.setFilePath(vo.getImagePath());
		to.setContentType(vo.getContentType());
		to.setDeleteInd(GeneralUtils.NOT_DELETED);
		return to;
	}
	
	public boolean uploadFileToDisk(ImageLinkVO img) {
		//fileName - filename.jpg
		//img.imagePath - d://images/category\filename.jpg
		//
		try {
			int i = 1;
			int s = StringUtils.ordinalIndexOf(img.getImagePath(), "/", 3);
			img.setImagePath(img.getImagePath().replaceAll(" ", "_"));
			String fileLoc = imageFolderSource.replace("/", "\\")+img.getImagePath().substring(s+1);
			int periodIndex = fileLoc.lastIndexOf(".");
			int slashIndex = fileLoc.lastIndexOf("\\");
			String fileName = fileLoc.substring(slashIndex+1, periodIndex);
			
			while(checkFileExist(fileLoc)){
				fileLoc = fileLoc.substring(0,slashIndex+1) + fileName + "_" + i + fileLoc.substring(periodIndex);
				periodIndex = fileLoc.lastIndexOf(".");
				slashIndex = fileLoc.lastIndexOf("\\");
				img.setFileName(fileLoc.substring(slashIndex+1));
				i++;
			}
//			img.setImagePath(fileLoc);
			FileOutputStream fos = new FileOutputStream(fileLoc);
			fos.write(img.getBytes());
			fos.close();
		} catch (IOException e) {
			e.printStackTrace();
			return false;
		}
		return true;
	}
	
	private boolean checkFileExist(String path){
		File file = new File(path);
		if(file.exists()){
			return true;
		}
		return false;
	}
}