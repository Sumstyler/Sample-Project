package com.mountain.service.impl;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

import com.mountain.common.AbstractService;
import com.mountain.dao.MessageDao;
import com.mountain.po.Message;
import com.mountain.service.IMessageService;

@Service
public class MessageService extends AbstractService<Message, Long> implements
		IMessageService {
	
	@Autowired
	private MessageDao messageDao;
	
	private final Logger logger = LoggerFactory.getLogger(this.getClass());

	@Autowired
	public void setBaseMapper() {
		super.setBaseMapper(messageDao);
	}
}
