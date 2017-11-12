package com.JJ.service.productmanagement;

import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.RenderingHints;
import java.awt.image.BufferedImage;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

import javax.imageio.ImageIO;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.JJ.controller.common.vo.FileMetaVO;
import com.JJ.controller.common.vo.ImageLinkVO;
import com.JJ.controller.productmanagement.vo.ProductVO;
import com.JJ.dao.ProductImageDbObjectMapper;
import com.JJ.helper.GeneralUtils;
import com.JJ.model.ProductImageDbObjectExample;
import com.JJ.model.ProductImageDbObjectWithBLOBs;
import com.JJ.service.filelinkmanagement.ImageService;
@Service
@Scope("prototype")
@Transactional(rollbackFor=Exception.class, propagation = Propagation.REQUIRED)
public class ProductImageService {
	
	private ProductImageDbObjectMapper productImageDbObjectMapper;
	private final static int thumbnail_width = 200;
	private final static int thumbnail_height = 200;
	private ImageService imageService;
	@Autowired
	public ProductImageService(ProductImageDbObjectMapper productImageDbObjectMapper,
			ImageService imageService) {
		this.productImageDbObjectMapper = productImageDbObjectMapper;
		this.imageService = imageService;
	}
	@Deprecated
	public List<ProductImageDbObjectWithBLOBs> getProductImage(List<Integer> productIdList){
		List<ProductImageDbObjectWithBLOBs> productImageList = new ArrayList<ProductImageDbObjectWithBLOBs>();
		if(productIdList != null && productIdList.size() > 0){
			ProductImageDbObjectExample example = new ProductImageDbObjectExample();
			example.createCriteria().andProductIdIn(productIdList).andDeleteIndEqualTo(GeneralUtils.NOT_DELETED);
			productImageList = productImageDbObjectMapper.selectByExampleWithBLOBs(example);
		}
		return productImageList;
	}
	
	public Map<Integer, LinkedList<ImageLinkVO>> getProductImageList(List<Integer> productIdList){
		Map<Integer, LinkedList<ImageLinkVO>> map = imageService.getAllImageLinkByRefTypeAndIdListOrdered(GeneralUtils.TYPE_PRODUCT, productIdList);
		return map;
	}
	
	public LinkedList<ImageLinkVO> getProductImage(Integer productId){
		Map<Integer, LinkedList<ImageLinkVO>> map = getProductImageList(Arrays.asList(productId));
		return map==null?null : map.get(productId);
	}
	
	public void saveProductImage(ProductVO productVo, Integer productId){
		//delete selected images
		List<FileMetaVO> fileMetaVOs = productVo.getRemoveImagesLink();
		if(fileMetaVOs != null && !fileMetaVOs.isEmpty()){
			for(FileMetaVO removeImage : fileMetaVOs){
				ImageLinkVO imageVO = imageService.convertFileMetaVOToImageLinkVO(removeImage, productVo.getProductId(), GeneralUtils.TYPE_PRODUCT);
				if(imageVO != null && imageVO.getImageLinkRsId() != null){
					imageService.deleteImageLinkByImageLinkRsId(imageVO);
				}
			}
		}
		
		//table image
		LinkedList<FileMetaVO> images = productVo.getImages();
		for(FileMetaVO image : images){
			ImageLinkVO imageVO = imageService.convertFileMetaVOToImageLinkVO(image, productVo.getProductId(), GeneralUtils.TYPE_PRODUCT);
			if(imageVO.getImageLinkRsId() == null){
				boolean uploadSuccess = imageService.uploadFileToDisk(imageVO);
				if(!uploadSuccess){
					continue;
				}
			}
			imageService.saveImageLink(imageVO);
		}
	}
	@SuppressWarnings("unused")
	@Deprecated
	private List<ProductImageDbObjectWithBLOBs> convertToProductImage(Integer productId,List<FileMetaVO> images){
		List<ProductImageDbObjectWithBLOBs> productImages = new ArrayList<ProductImageDbObjectWithBLOBs>();
		if(images != null && images.size() > 0 && productId != null){
			for(FileMetaVO image : images){
				ProductImageDbObjectWithBLOBs productImage = new ProductImageDbObjectWithBLOBs();
				productImage.setProductImageId(image.getImageId());
				productImage.setProductId(productId);
				productImage.setImageName(image.getFileName());
				productImage.setSequence(image.getSequence());
				productImage.setFileType(image.getFileType());
				if(image.getImageId() != null && image.getImageId().intValue() > 0){
					
				}else{
					productImage.setImage(image.getBytes());
					productImage.setThumbNailImage(getThumbnail(image.getBytes(), thumbnail_width, thumbnail_height));
				}
				productImages.add(productImage);
			}
		}
		return productImages;
	}
	@Deprecated
	private byte[] getThumbnail(byte[] source,int w, int h){
		try {
			InputStream in = new ByteArrayInputStream(source);
			BufferedImage buf = ImageIO.read(in);
			
			BufferedImage thumb = new BufferedImage(w, h, BufferedImage.TYPE_INT_RGB);
		    Graphics2D graphics2D = thumb.createGraphics();
		    graphics2D.setBackground(Color.WHITE);
		    graphics2D.setPaint(Color.WHITE); 
		    graphics2D.fillRect(0, 0, w, h);
		    graphics2D.setRenderingHint(RenderingHints.KEY_INTERPOLATION, RenderingHints.VALUE_INTERPOLATION_BILINEAR);
		    graphics2D.drawImage(buf, 0, 0, w, h, null);
		    
			ByteArrayOutputStream baos = new ByteArrayOutputStream();
	  
			ImageIO.write( thumb, "jpg", baos );
			baos.flush();
			byte[] imageInByte = baos.toByteArray();
			baos.close();
			return imageInByte;
		} catch (IOException e) {
			e.printStackTrace();
			return new byte[0];
		}
	}

	public List<ProductVO> getProductVOImage(List<ProductVO> voList) {
		if(voList != null && voList.size() > 0){
			List<Integer> productIdList = new ArrayList<Integer>();
			for(ProductVO vo : voList){
				productIdList.add(vo.getProductId());
			}
			
			if(productIdList != null && productIdList.size() > 0){
				List<ProductImageDbObjectWithBLOBs> imageList= getProductImage(productIdList);
				List<FileMetaVO> fileMetaList = convertToFileMetaVO(imageList);
				Map<Integer, LinkedList<FileMetaVO>> imageMap = new HashMap<Integer, LinkedList<FileMetaVO>>();
				if(imageList != null && imageList.size() > 0){
					for(FileMetaVO vo : fileMetaList){
						if(!imageMap.containsKey(vo.getProductId())){
							imageMap.put(vo.getProductId(), new LinkedList<FileMetaVO>());
						}
						imageMap.get(vo.getProductId()).add(vo);
					}
				}
				
				for(ProductVO vo : voList){
					LinkedList<FileMetaVO> productImageList = imageMap.get(vo.getProductId());
					if(productImageList != null && productImageList.size() > 0){
						vo.setImages(productImageList);
					}
				}
			}
		}
		return voList;
	}

	private List<FileMetaVO> convertToFileMetaVO(List<ProductImageDbObjectWithBLOBs> imageList) {
		List<FileMetaVO> fileMetaList = new ArrayList<FileMetaVO>();
		if(imageList != null && imageList.size() > 0){
			for(ProductImageDbObjectWithBLOBs image : imageList){
				FileMetaVO vo = new FileMetaVO();
				vo.setBytes(image.getImage());
				vo.setFileName(image.getImageName());
				vo.setFileSize(image.getImage().length+"");
				vo.setImageId(image.getProductImageId());
				vo.setThumbnail(image.getThumbNailImage());
				vo.setSequence(image.getSequence());
				vo.setProductId(image.getProductId());
				fileMetaList.add(vo);
			}
		}
		return fileMetaList;
	}
	
	public ImageLinkVO getCoverImageByProductId(Integer productId){
		LinkedList<ImageLinkVO> list = getProductImage(productId);
		if(list != null && !list.isEmpty()){
			ImageLinkVO imageLinkVO = list.get(0);
			imageLinkVO = imageService.readImageFromURL(imageLinkVO);
			return imageLinkVO;
		}
		return null;
	}
}
