/**
 *  * Project Description:
 * 
 * Name: Farzad Hasan
 * Period: 1
 * Project: Maze Solver
 * Date: 2/20/2024
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
    	//Creates new maze object of size, size.
        Maze maze = new Maze(size);
        
        //Creates a new stack of type cell.
        Stack<Cell> newStack = new Stack<Cell>();
        
        //Adds first cell to the stack.
        newStack.push(new Cell(0, 0));
        
        //Parses stack to get the coordinates of each cell.
        while (!newStack.isEmpty()) {
        	Cell currentCell = newStack.pop();
            int xCoord = currentCell.getX();
            int yCoord = currentCell.getY();
            
            //Visits each cell at the right X and Y coordinates.
            maze.visit(xCoord, yCoord);
            
            
        }
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
