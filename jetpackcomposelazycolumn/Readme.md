# JetpackComposeLazycolumn

## Overview

This repository demonstrates how to implement navigation in Jetpack Compose and pass objects between screens using JSON serialization and deserialization. The project showcases a simple TV shows list screen and a detail screen, illustrating how to pass complex data safely and effectively.

## Features

- **Jetpack Compose**: Utilizes modern, declarative UI development with Jetpack Compose.
- **Navigation**: Implements navigation between a list screen and a detail screen.
- **JSON Serialization**: Uses Gson to serialize and deserialize objects to pass between screens.

## Getting Started

### Prerequisites

- Android Studio Bumblebee | 2021.1.1 Patch 3 or newer.
- Basic knowledge of Kotlin and Jetpack Compose.

### Installation

1. **Clone the repository:**

   ```sh
   git clone https://github.com/TeniG/JetpackComposeDemoApp.git
   ```

2. **Open the project in Android Studio:**

   Navigate to the `jetpackcomposelazycolumn` directory and open it with Android Studio.

3. **Sync the project:**

   Ensure all Gradle dependencies are downloaded and the project is synced successfully.

## Usage

### Running the App

1. **Connect an Android device** or start an Android emulator.
2. **Run the application** from Android Studio by clicking the "Run" button or using `Shift + F10`.

### Project Structure

- **Data Model**: Contains the `TVShow` data class.
- **List Screen**: Displays a list of TV shows and handles navigation to the detail screen.
- **Detail Screen**: Receives and displays details of the selected TV show.
- **Navigation**: Sets up the navigation graph with routes for the list and detail screens.
- **Main Activity**: Hosts the Compose content and sets up the navigation host.

## Contributing

Contributions are welcome! Please fork this repository and submit a pull request for any enhancements or bug fixes.

## License

This project is licensed under the MIT License. See the [LICENSE](../LICENSE) file for details.

## Contact

If you have any questions, feel free to reach out via the issues section or contact me directly.

Happy coding!
