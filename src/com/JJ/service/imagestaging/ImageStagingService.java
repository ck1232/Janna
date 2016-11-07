package com.JJ.service.imagestaging;

import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.JJ.dao.ImagestagingMapper;
import com.JJ.model.Imagestaging;

@Service
@Transactional
public class ImageStagingService {
	private ImagestagingMapper imageStagingMapper;
	
	@Autowired
	public ImageStagingService(ImagestagingMapper imageStagingMapper){
		this.imageStagingMapper = imageStagingMapper;
	}
	
	public Integer insertImageStaging(byte[] image, String imageName, String username){
		Imagestaging obj = new Imagestaging();
		obj.setCreateddate(new Date());
		obj.setImage(image);
		obj.setImagename(imageName);
		obj.setCreatedby(username);
		imageStagingMapper.insert(obj);
		return obj.getImagestagingid();
	}
}
