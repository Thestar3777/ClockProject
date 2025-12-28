# Digital Clock Desktop App

A modern desktop application built with **JavaFX** that displays a digital clock.

Unlike traditional console apps, this project uses a graphical user interface (GUI) defined in FXML (`hello-view.fxml`) to separate the design from the logic. It leverages the JavaFX `Stage` and `Scene` architecture to render a responsive window.
## Demo

https://github.com/user-attachments/assets/018f8e54-d810-4dec-a292-781bcb012f6d

## Key Features

* **Real-Time Display:** Shows the current time (HH:mm:ss) and date (dd-MM-yyyy).
* **Custom UI:**
    * Uses a custom background image.
    * Displays text in the "Algerian" font for a stylized look.
* **Multi-Threaded Architecture:**
    * **ClockUpdater Thread:** Handles the GUI updates on the Swing Event Dispatch Thread.
    * **TimePrinter Thread:** Logs the current time to the console simultaneously (for debugging or logging).## Built With

* **Language:** Java
* **Framework:** JavaFX
* **UI Design:** FXML (Scene Builder)
* **IDE:** IntelliJ IDEA
## Prerequisites

* **Java Development Kit (JDK):** Version 17 or higher is recommended.
* **JavaFX SDK:**
  * **If using Maven/Gradle (Recommended):** The dependencies will be downloaded automatically when you load the project.
  * **If running manually:** You must download the [JavaFX SDK](https://gluonhq.com/products/javafx/) and add it to your module path.

## How to Run

1. **Open the Project:** Open the folder in **IntelliJ IDEA**.
2. **Load Maven/Gradle:** If prompted, click "Load Maven Project" (JavaFX apps usually use a build tool).
3. **Run:** Open `HelloApplication.java` and click the green **Run** arrow next to the `main` method.
