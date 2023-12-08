package com.example.lineporto;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.lineporto.Navios.NavioInfoClass;

@SpringBootApplication
public class LineportoApplication {

	public static void main(String[] args) {
		SpringApplication.run(LineportoApplication.class, args);
	}

}
