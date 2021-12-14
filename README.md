# Go vs Net60

This repo has 2 simple api projects. `WebApplicationNet60` and `WebApplicationGo`. Both projects are creating WeatherForecast array with 5 elements in it and return that array as json.

| Application         |  Port  | Local Address                          |
|---------------------|--------|----------------------------------------|
| WebApplicationNet60 |  5000  | http://localhost:5000/weatherforecast  |
| WebApplicationGo    |  10000 | http://localhost:10000/weatherforecast |

## Load testing (k6s)
You'll find `net60.js` and `go.js` under `LoadTests` folder.

## 100 VUs 30 sec
![GoVsNet60-100VUs-30sec](/LoadTests/GoVsNet60-100VUs-30sec.png)