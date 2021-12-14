var builder = WebApplication.CreateBuilder(args);

// Add services to the container.

var app = builder.Build();

var summaries = new[]
{
    "Freezing", "Bracing", "Chilly", "Cool", "Mild", "Warm", "Balmy", "Hot", "Sweltering", "Scorching"
};

app.MapGet("/weatherforecast", () =>
{
    const int max = 5;
    var forecast = new WeatherForecast[max];
    for (var i = 0; i < max; i++)
    {
        forecast[i] = new WeatherForecast
        (
            DateTime.Now.AddDays(i),
            Random.Shared.Next(-20, 55),
            summaries[Random.Shared.Next(summaries.Length)]
        );
    }
    return forecast;
});

app.Run();

internal record WeatherForecast(DateTime Date, int TemperatureC, string? Summary)
{
    public int TemperatureF => 32 + (int)(TemperatureC / 0.5556);
}