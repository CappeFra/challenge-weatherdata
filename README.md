# WeatherData Challenge

## Architectural considerations
I'm not very familiar with best practices for the architecture of java projects. <br>
What I would do in a .NET environment is I would create a solution with different projects, one for each architectural
layer (e.g. UseCases, EnterpriseBusinessRules, Persistence, API, etc...) and only add each layer as reference
to the layers it should be accessible from. I would use a dependency-injection service to pass the data along 
in order to maximize Separation of Concerns. <br>
I will try to reproduce this kind of behavior with my limited knowledge of java.

I'm treating the main of the program as a minimalistic frontend. Otherwise, the entry point of this program would be,
for instance, a REST API that does the same as this main is doing, i.e. call a Use Case.
The Use Case coordinates how the response looks like. In these examples it first calls the persistence layer in order
to extract the data needed for the calculations. 
The persistence layer returns instances of the Domain Model, and the use cases calls some business logic on these
instances to process the data. Finally, the calculated output is returned to the caller of the use case, i.e. 
the main.