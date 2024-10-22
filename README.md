# Maze Solver

![Java](https://img.shields.io/badge/Java-11%2B-blue)
![License](https://img.shields.io/badge/license-MIT-green)
![Contributions](https://img.shields.io/badge/contributions-welcome-brightgreen)

**Maze Solver** is a Java-based project that can generate random mazes and solve them using different algorithms such as Depth-First Search (DFS) and Breadth-First Search (BFS). The project demonstrates the usage of stacks and queues to navigate through a maze efficiently.

## Table of Contents

- [Features](#features)
- [Project Structure](#project-structure)
- [License](#license)

---

## Features

- **Maze Generation**: Randomly generates a maze using a backtracking algorithm.
- **Maze Solving**: Solves the maze using two classical algorithms:
  - Depth-First Search (DFS)
  - Breadth-First Search (BFS)
- **Visualization**: The project can visually represent the maze and the solving process (likely using `stdlib.jar`).
- **Customizable Maze Dimensions**: Allows the creation of mazes with custom dimensions.

## Project Structure

MazeSolver/
├── .classpath              # Eclipse project classpath file
├── .gitignore              # Git ignore file to exclude unnecessary files
├── .project                # Eclipse project settings file
├── stdlib.jar              # External library jar file (likely for graphics or utility methods)
├── src/                    # Source folder containing Java code
│   ├── Cell.java           # Class representing a single cell in the maze
│   ├── Direction.java      # Enum or class for directions (North, South, East, West)
│   ├── Maze.java           # Core logic for generating and managing the maze
│   ├── MazeGenerator.java  # Class that generates random mazes
│   ├── MazeSolver.java     # Class that implements the maze-solving algorithm
│   ├── Path.java           # Class that stores or manipulates the path through the maze
│   ├── Queue.java          # Queue implementation, likely for breadth-first search (BFS)
│   ├── Stack.java          # Stack implementation, likely for depth-first search (DFS)

## License

This project is licensed under the MIT License.
