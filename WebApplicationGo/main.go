package main

import (
	"encoding/json"
	"fmt"
	"log"
	"math/rand"
	"net/http"
	"time"

	models "WebApplicationGo/models"
)

var summaries = [10]string{"Freezing", "Bracing", "Chilly", "Cool", "Mild", "Warm", "Balmy", "Hot", "Sweltering", "Scorching"}

func weatherForecast(w http.ResponseWriter, r *http.Request) {
	w.Header().Set("Content-Type", "application/json")
	rand.Seed(time.Now().UnixNano())
	var forecast [5]models.WeatherForecast
	for i := 0; i < 5; i++ {
		forecastItem := new(models.WeatherForecast)
		forecastItem.Date = time.Now().AddDate(0, 0, i)
		forecastItem.TemperatureC = rand.Intn(75) - 20
		forecastItem.Summary = summaries[rand.Intn(len(summaries))]
		forecastItem.TemperatureF = forecastItem.GetTemperatureF()
		forecast[i] = *forecastItem
	}

	forecastJson, _ := json.Marshal(forecast)
	forecastJsonString := string(forecastJson)
	fmt.Fprintln(w, forecastJsonString)
}

func handleRequests() {
	http.HandleFunc("/weatherforecast", weatherForecast)
	log.Fatal(http.ListenAndServe(":10000", nil))
}

func main() {
	handleRequests()
}
