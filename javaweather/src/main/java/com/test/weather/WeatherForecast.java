package com.test.weather;

import java.time.LocalDateTime;

import org.springframework.stereotype.Service;

@Service
public class WeatherForecast {

	private LocalDateTime date;
	private int tempC;
	private int TemperatureF;

	public WeatherForecast(LocalDateTime date, int tempC, String summaries) {

		this.date = date;
		this.tempC = tempC;
		this.TemperatureF = 32 + (int) (tempC / 0.5556);

	}

	public WeatherForecast() {

	}

	public LocalDateTime getDate() {
		return date;
	}

	public void setDate(LocalDateTime date) {
		this.date = date;
	}

	public int getTempC() {
		return tempC;
	}

	public void setTempC(int tempC) {
		this.tempC = tempC;
	}

	public int getTemperatureF() {
		return TemperatureF;
	}

	public void setTemperatureF(int temperatureF) {
		TemperatureF = temperatureF;
	}



}
