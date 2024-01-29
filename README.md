# Sports Results Android App

This Android app displays sports results using Clean Architecture, Jetpack Compose for UI, Hilt for dependency injection, Retrofit for API calls, JUnit 5 for unit tests, and Espresso for UI tests.

<img src="https://github.com/kaustubhkp/SportResults/assets/15397741/3ae5e86f-64c0-402e-beee-5cffca32bb5c" width="200" height="400">

<img src="https://github.com/kaustubhkp/SportResults/assets/15397741/07f20f8e-e724-46c7-bff4-79c60625343e" width="200" height="400">



## Design decisions and Assumptions

I had a tight deadline of 2-3 days for the assignment, so I made some decisions to work efficiently. I chose Clean Architecture because I'm familiar with it and it helps keep the code organized.

I identified parsing the server response as crucial. I went with the standard Android method of defining model classes and using the Gson library for parsing. However, this approach has a limitation – if the server adds a new sport, the app would need modifications.

To address this, I considered creating a custom utility to parse JSON strings and display data. This way, the app could dynamically handle new sports without requiring changes. Due to time constraints, I opted not to create this utility and stuck with the standard approach using Gson.

Despite this, I designed the model classes to minimize changes on the app side when the server introduces new sports or modifications. The goal was to ensure that the app remains extendable with minimal future adjustments.

## Dependencies and Reasoning

### Jetpack Compose
- **UI Framework:** Jetpack Compose simplifies UI development with a declarative syntax, improving the overall development experience.

### Hilt
- **Dependency Injection:** Hilt is used for dependency injection, making it easier to manage and test dependencies in the application.

### Retrofit
- **Networking:** Retrofit is used to make API calls to retrieve sports results from remote servers.

- **JUnit 5 Tests:** Check the unit tests for critical business logic and use cases. The `./gradlew clean test` command generates a unit test report.

  <img width="403" alt="Screenshot 2024-01-29 at 5 34 16 PM" src="https://github.com/kaustubhkp/SportResults/assets/15397741/a325737b-09cc-4881-8b37-ee8bb899863c">

- **Espresso UI Tests:** Review the Espresso UI tests for the correctness of the UI components. The `./gradlew clean connectedAndroidTest` command generates a UI test report.

  <img width="821" alt="Screenshot 2024-01-29 at 6 36 50 PM" src="https://github.com/kaustubhkp/SportResults/assets/15397741/2b4e9b72-46fe-4da9-b00e-ce0bbc4f380b">

## Improvements

- **Dynamic UI Logic:** The current implementation assumes a generic structure for displaying sports results. Improve this area to dynamically adapt to new sports and automatically render UI changes based on the latest date.

- **Flexible Response Model:** Enhance the logic to handle new sports without requiring manual updates to the result response model. Consider creating a utility to read JSON responses directly and dynamically adapt to changes.

## Additional Notes

Your feedback and suggestions for improvement are highly appreciated. Thank you for reviewing my work!
