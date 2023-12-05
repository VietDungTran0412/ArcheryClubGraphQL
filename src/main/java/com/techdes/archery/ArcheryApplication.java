package com.techdes.archery;

import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.security.servlet.SecurityAutoConfiguration;

import java.util.ArrayList;
import java.util.HashMap;

@SpringBootApplication(exclude = {SecurityAutoConfiguration.class})
@Slf4j
public class ArcheryApplication {

	public static void main(String[] args) {
		String[] s = {"H", "E"};
		String res = "";
		for(String s1 : s) {
			res += s1;
		}
		log.info(res);
		SpringApplication.run(ArcheryApplication.class, args);
	}

}
