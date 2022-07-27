package com.test.weather;

import java.time.LocalDateTime;
import java.util.Random;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class mainController {

	public static String[] summaries = { "Freezing", "Bracing", "Chilly", "Cool", "Mild", "Warm", "Balmy", "Hot","Sweltering", "Scorching" };
	public static final int max = 5;


	@GetMapping("/weatherforecast")
	public WeatherForecast[] welcomeRedirect() {
		WeatherForecast[] forecast = new WeatherForecast[max];
		for (int i = 0; i < max; i++)
		{
		    forecast[i] = new WeatherForecast(LocalDateTime.now().plusDays(i),new Random().nextInt(-20, 55), summaries[new Random().nextInt(0, max)]);
		}
		return forecast;
	}
}
