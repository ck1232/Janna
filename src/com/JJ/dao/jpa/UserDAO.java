package com.JJ.dao.jpa;

import java.util.List;

import org.springframework.transaction.annotation.Transactional;

import com.JJ.TO.UserTO;
@Transactional(readOnly = true)
public interface UserDAO extends BaseDAO<UserTO> {
	UserTO findByUserId(Long userId);
	List<UserTO> findByUserIdIn(List<Long> userIdList);
	List<UserTO> findByUserNameAndDeleteInd(String userName, String deleteInd);
}
