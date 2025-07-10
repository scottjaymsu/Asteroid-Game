# Asteroid App

An interactive Asteroids game developed in **Java 17** using the **JavaFX** GUI framework. The game features smooth event-driven gameplay and classic arcade mechanics inspired by Atari’s 1979 hit.

<img width="367" height="278" alt="image" src="https://github.com/user-attachments/assets/3d7d569f-dd81-4d55-a2c5-3644ba8adbe5" />

## About the Game

The player pilots a triangular spaceship tasked with destroying drifting asteroids by shooting them while avoiding collisions. 

Game Features:
- Creating the game window  
- Designing and rendering the spaceship  
- Rotating and moving the ship  
- Generating asteroids  
- Detecting collisions between ship and asteroids  
- Handling multiple asteroids simultaneously  
- Keeping the ship within the game window bounds  
- Implementing projectiles for shooting asteroids  
- Adding a scoring system  
- Continuously spawning new asteroids

## Prerequisites

- Java 17 JDK installed  
- Maven installed (bundled wrapper can be used)  
- JavaFX SDK configured (if not using Maven JavaFX plugin)  

## How to Compile and Run

1. Open the terminal or PowerShell.  
2. Navigate to the project’s application folder:

   ```bash
   cd Asteroid-Game\AsteroidApp
   .\mvnw clean compile
   .\mvnw javafx:run
   
## Game Controls

- Arrow keys or WASD to move and rotate the ship
- Spacebar to shoot projectiles
- Avoid collisions with asteroids while destroying them to score points
