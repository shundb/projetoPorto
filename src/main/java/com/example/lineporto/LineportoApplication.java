package com.example.lineporto;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RestController;


@SpringBootApplication
@Controller

public class LineportoApplication {

	public static void main(String[] args) {
		SpringApplication.run(LineportoApplication.class, args);
	}

}
