from fastapi import FastAPI
import datetime
from random import seed
from random import randint
import json
from fastapi.responses import JSONResponse

app = FastAPI()

Summaries = ["Freezing", "Bracing", "Chilly", "Cool", "Mild", "Warm", "Balmy", "Hot", "Sweltering", "Scorching"]

@app.get("/weatherforecast")
def weatherforecastmain():
    forecastList = []
    for i in range(5):
        summary = Summaries[randint(0, len(Summaries) - 1)]
        forecast = WeatherForecast(datetime.datetime.today() + datetime.timedelta(days=i), randint(-20, 55), summary)
        forecastList.append(forecast)

    return JSONResponse(json.dumps(forecastList, default=json_default))

class WeatherForecast:
    def __init__(self, date, tempC, summary):
        self.Date = date
        self.TemperatureC = tempC
        self.Summary = summary
        self.TemperatureF = 32 + (int)(self.TemperatureC / 0.5556)

    Date: datetime
    TemperatureC: int
    TemperatureF: int
    Summary: str

def json_default(value):
    if isinstance(value, datetime.date):
        return dict(year=value.year, month=value.month, day=value.day)
    else:
        return value.__dict__