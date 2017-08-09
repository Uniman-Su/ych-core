package com.ych.core.jms;

import java.io.Serializable;

import javax.jms.JMSException;
import javax.jms.Message;
import javax.jms.Session;

import org.springframework.jms.core.MessageCreator;

/**
 * 序列化对象的消息创建器
 * 
 * @author U
 *
 */
public class SerializableMessageCreator implements MessageCreator {

	/**
	 * 要传送的序列化对象
	 */
	private Serializable data;

	/**
	 * 构造方法
	 * 
	 * @param data
	 *            序列化对象
	 */
	public SerializableMessageCreator(Serializable data) {
		this.data = data;
	}

	@Override
	public Message createMessage(Session session) throws JMSException {
		return session.createObjectMessage(data);
	}

}
