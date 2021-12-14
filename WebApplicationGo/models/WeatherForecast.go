package WeatherForecast

import (
	"time"
)

type WeatherForecast struct {
	Date         time.Time
	TemperatureC int
	Summary      string
	TemperatureF int
}

func (wf *WeatherForecast) GetTemperatureF() int {
	return (int)(float32(wf.TemperatureC)*1.8) + 32
}
