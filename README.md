# Sports Results Android App

This Android app displays sports results using Clean Architecture, Jetpack Compose for UI, Hilt for dependency injection, Retrofit for API calls, JUnit 5 for unit tests, and Espresso for UI tests.

![User 1](https://github.com/kaustubhkp/SportResults/assets/15397741/3ae5e86f-64c0-402e-beee-5cffca32bb5c) | ![User 2](https://github.com/kaustubhkp/SportResults/assets/15397741/07f20f8e-e724-46c7-bff4-79c60625343e)
|:---:|:---:|


## Dependencies and Reasoning

### Jetpack Compose
- **UI Framework:** Jetpack Compose simplifies UI development with a declarative syntax, improving the overall development experience.

### Hilt
- **Dependency Injection:** Hilt is used for dependency injection, making it easier to manage and test dependencies in the application.

### Retrofit
- **Networking:** Retrofit is used to make API calls to retrieve sports results from remote servers.

### JUnit 5
- **Unit Testing:** JUnit 5 is used for writing unit tests to ensure the reliability of individual components.

### Espresso
- **UI Testing:** Espresso is utilized for UI testing to ensure the correct behavior of UI components.

## Important Code Portions to Review

- **JUnit 5 Tests:** Check the unit tests for critical business logic and use cases. The `./gradlew clean test` command generates a unit test report.

  <img width="403" alt="Screenshot 2024-01-29 at 5 34 16 PM" src="https://github.com/kaustubhkp/SportResults/assets/15397741/a325737b-09cc-4881-8b37-ee8bb899863c">

- **Espresso UI Tests:** Review the Espresso UI tests for the correctness of the UI components. The `./gradlew clean connectedAndroidTest` command generates a UI test report.

  <img width="821" alt="Screenshot 2024-01-29 at 6 36 50 PM" src="https://github.com/kaustubhkp/SportResults/assets/15397741/2b4e9b72-46fe-4da9-b00e-ce0bbc4f380b">

## Improvements

- **Dynamic UI Logic:** The current implementation assumes a generic structure for displaying sports results. Improve this area to dynamically adapt to new sports and automatically render UI changes based on the latest date.

- **Flexible Response Model:** Enhance the logic to handle new sports without requiring manual updates to the result response model. Consider creating a utility to read JSON responses directly and dynamically adapt to changes.

## Additional Notes

This project is a continuous work-in-progress. Your feedback and suggestions for improvement are highly appreciated. Thank you for reviewing my work!
