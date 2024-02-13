/**
 * Solves mazes. Please refer to the specification for instructions on how to solve mazes.
 */
public class MazeSolver
{
    /**
     * Provides a solution for a given maze, if possible. A solution is a path from the start cell
     * to the finish cell (inclusive). If there is no solution to the maze then returns the static
     * instance {@link Path#NO_PATH}. If the maze is perfect then there must be only one solution.
     *
     * @param maze the maze to solve
     * @return a solution for the maze or {@link Path#NO_PATH} if there is no solution
     */
    public Path solve(Maze maze)
    {
        throw new UnsupportedOperationException("Implement me!");
    }

    /**
     * Creates, solves, and draws a sample maze. Try solving mazes with different sizes!
     *
     * @param args unused
     */
    public static void main(String[] args)
    {
        // First, generate a new maze.
        int size = 10; // Setting above 200 is not recommended!
        MazeGenerator generator = new MazeGenerator();
        Maze maze = generator.generate(size);
        maze.freeze();

        // Next, solve it!
        MazeSolver solver = new MazeSolver();
        maze.resetVisited();
        Path solutionPath = solver.solve(maze);
        maze.setSolution(solutionPath);

        // This is so we can see which cells were explored and in what order.
        maze.setDrawVisited(true);

        maze.draw();
    }
}
