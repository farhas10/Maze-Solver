/**
 * Project Description:
 * In this project we will develop a LinkedList or ArrayList Queue
 * and stack system to solve and generate a series of perfect mazes.
 * Name: Farzad Hasan
 * Period: 1
 * Project: Maze Solver
 * Date: 2/26/2024
 * 
 * Solves mazes. Please refer to the specification for instructions on how to solve mazes.
 */
public class MazeSolver
{
	
	//Helper class as outlined by FAQ to store possible solution paths.
	public class cellQueue{
		private Path p;
		private Cell c;
		
		public cellQueue(Path path, Cell cell) {
			c = cell;
			p = new Path();
			
			for (Cell cNext : path) {
				p.addLast(cNext);
			}
			
			p.addLast(cell);
		}
		
		public Cell getCell() {
			return c;
		}
		
		public Path getPath() {
			return p;
		}
	}

	
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
        int size = maze.size();
        
        
        
        Queue<cellQueue> newQueue = new Queue<cellQueue>();
        
        newQueue.enqueue(new cellQueue(Path.NO_PATH, maze.getStart()));
        
        while (!newQueue.isEmpty()) {
        	cellQueue c = newQueue.dequeue();
        	Cell current = c.getCell();
        	int x = current.getX(), y = current.getY();
        	maze.visit(x, y);
        	Path result = c.getPath();
        	
        	if (current.equals(maze.getEnd())) {
        		return result;
        	}
        	
        	
        	
        	
        }
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
