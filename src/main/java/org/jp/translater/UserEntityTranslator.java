package org.jp.translater;

import org.jp.dto.UserEntityReq;
import org.jp.entity.UserEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.fasterxml.jackson.databind.ObjectMapper;

@Component
public class UserEntityTranslator {
	
	@Autowired
	private ObjectMapper mapper;
	
	public UserEntity entitytranslator(UserEntityReq entityReq) {
		return mapper.convertValue(entityReq, UserEntity.class);
	}

}
