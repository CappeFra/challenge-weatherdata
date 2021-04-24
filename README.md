# WeatherData Challenge

## Architecture
I'm not very familiar with best practices for the architecture of java projects. <br>
What I would do in a .NET environment is I would create a solution with different projects, one for each architectural
layer (e.g. UseCases, EnterpriseBusinessRules, Persistence, API, etc...) and only add each layer as reference
to the layers it should be accessible from. I would use a dependency-injection service to pass the data along 
in order to maximize Separation of Concerns. <br>
I will try to reproduce this kind of behavior with my limited knowledge of java.