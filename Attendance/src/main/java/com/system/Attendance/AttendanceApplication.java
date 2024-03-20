package com.system.Attendance;

import com.system.Attendance.integrate.GenerateData;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication(scanBasePackages = {"edu.miu.common", "com.system.Attendance"})
public class AttendanceApplication implements CommandLineRunner {

	@Autowired
	GenerateData generateData;
	public static void main(String[] args) {
		SpringApplication.run(AttendanceApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		generateData.generateData();
	}

}
