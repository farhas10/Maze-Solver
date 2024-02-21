/**
 *  * Project Description:
 * 
 * Name: Farzad Hasan
 * Period: 1
 * Project: Maze Solver
 * Date: 2/13/2024
 * 
 * Creates new mazes. Please refer to the spec for instructions on how to generate mazes.
 */
public class MazeGenerator
{
    /**
     * Randomly generates a perfect maze of {@param size}.
     *
     * @param size the size of the maze to generate
     * @return the generated maze
     */
    public Maze generate(int size)
    {
        throw new UnsupportedOperationException("Implement me!");
        
        Maze maze = new Maze(size);
        
        Stack
        return maze;
        
    }

    /**
     * Creates and draws a sample maze. Try generating mazes with different sizes!
     *
     * @param args unused
     */
    public static void main(String[] args)
    {
        StdRandom.setSeed(34);
        int size = 10; // Setting above 200 is not recommended!
        MazeGenerator generator = new MazeGenerator();
        Maze maze = generator.generate(size);
        maze.draw();
    }
}