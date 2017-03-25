package com.JJ.service.productmanagement;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.JJ.controller.inventorymanagement.vo.ViewItemCodeVO;
import com.JJ.dao.ViewItemCodeDbObjectMapper;
import com.JJ.model.ViewItemCodeDbObject;
import com.JJ.model.ViewItemCodeDbObjectExample;
@Service
@Transactional(rollbackFor=Exception.class, propagation = Propagation.REQUIRED)
public class ItemCodeService {
	
	private ViewItemCodeDbObjectMapper viewItemCodeDbObjectMapper;
	
	@Autowired
	public ItemCodeService(ViewItemCodeDbObjectMapper viewItemCodeDbObjectMapper) {
		this.viewItemCodeDbObjectMapper = viewItemCodeDbObjectMapper;
	}
	
	public List<ViewItemCodeVO> getAllItemCode() {
		ViewItemCodeDbObjectExample viewItemCodeExample = new ViewItemCodeDbObjectExample();
		return convertToViewItemCodeVOList(viewItemCodeDbObjectMapper.selectByExample(viewItemCodeExample));
	}
	
	private List<ViewItemCodeVO> convertToViewItemCodeVOList(List<ViewItemCodeDbObject> viewItemCodeDbObjectList) {
		List<ViewItemCodeVO> ViewItemCodeVOList = new ArrayList<ViewItemCodeVO>();
		if(viewItemCodeDbObjectList != null && !viewItemCodeDbObjectList.isEmpty()) {
			for(ViewItemCodeDbObject dbObj : viewItemCodeDbObjectList) {
				ViewItemCodeVO vo = new ViewItemCodeVO(dbObj.getProductSuboptionRsId(), dbObj.getProductId(),
						dbObj.getProductName(), dbObj.getSuboption1Name(), dbObj.getSuboption1Id(), 
						dbObj.getSuboption2Name(), dbObj.getSuboption2Id(), dbObj.getSuboption3Name(),
						dbObj.getSuboption3Id(), dbObj.getItemCode());
				ViewItemCodeVOList.add(vo);
			}
		}
		return ViewItemCodeVOList;
	}
}
