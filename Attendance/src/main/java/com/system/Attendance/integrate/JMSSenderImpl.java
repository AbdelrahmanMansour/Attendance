package com.system.Attendance.integrate;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jms.annotation.EnableJms;
import org.springframework.jms.annotation.JmsListener;
import org.springframework.jms.core.JmsTemplate;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@EnableJms
public class JMSSenderImpl implements JMSSender {

	@Autowired
	JmsTemplate jmsTemplate;

	public void sendJMSMessage (String text){
		jmsTemplate.convertAndSend("testQueue",text);
	}

	@JmsListener(destination = "testQueue")
	public void receiveMessage(String text) {
		String[] res = text.split("_");
		System.out.println("Email to "+res[1]+" text: "+res[2]);
	}

}
