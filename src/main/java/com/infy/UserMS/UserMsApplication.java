package com.infy.UserMS;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import com.infy.UserMS.dto.CartDTO;
@SpringBootApplication
public class UserMsApplication {

	@Autowired
	CartDTO cdto;
@Autowired
private KafkaTemplate<String, String> kafkaTemplate;
private static final String topic="TestTopic";
int bId=cdto.getBuyerId();
int pId=cdto.getProdId();
int qty=cdto.getQuantity();
public String message= bId+" "+pId+" "+qty;
public String publish(String msg) {
	msg=this.message;
	kafkaTemplate.send(topic,msg);
	return "Published Successfully";
}
	public static void main(String[] args) {
		SpringApplication.run(UserMsApplication.class, args);
	}

}
