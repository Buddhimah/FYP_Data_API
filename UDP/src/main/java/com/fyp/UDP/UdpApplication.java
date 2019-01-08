package com.fyp.UDP;

import com.fyp.UDP.FYP.MeterContoller;
import com.fyp.UDP.FYP.Receiver;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class UdpApplication {

	public static void main(String[] args) {

		SpringApplication.run(UdpApplication.class, args);

		Receiver.main(new String[0]);

	}
}
