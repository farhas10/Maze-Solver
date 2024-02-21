/**
 *  * Project Description:
 * In this project we will develop a LinkedList or ArrayList Queue
 * and stack system to solve and generate a series of perfect mazes.
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
	
	Direction[] neighborDirections = new Direction[4];
    int counter = 0;
    
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
            //Adds to the existing array the location and direction.
            getDirection(maze, xCoord, yCoord);
            
            if (counter > 0) {
            	
            	//Randomly will remove a wall from the cell.
            	int random = (int)(Math.random() * counter);
                maze.removeWall(xCoord, yCoord, neighborDirections[random]);
                newStack.push(currentCell);

                int newX = xCoord;
                int newY = yCoord;
                
                //Depending on the direction the X and Y will either increase or decrease.
                if (neighborDirections[random] == Direction.LEFT) {
                	newX --; 
                }
                
                if (neighborDirections[random] == Direction.RIGHT) {
                	newX++;
                }
                if (neighborDirections[random] == Direction.UP) {
                	newY++;
                }
                if (neighborDirections[random] == Direction.DOWN) {
                	newY--;
                }
                
                newStack.push(new Cell (newX, newY));
                counter = 0;
                neighborDirections = new Direction[4];
                
            }
            
            //Randomizing the start and end points.
            int xInit = (int)(Math.random() * size);
            int yInit = (int)(Math.random() * size);
            int xFinal = (int)(Math.random() * size);
            int yFinal = (int)(Math.random() * size);
            
            //Made to handle edge case where the start and end are the same.
            while (xInit == yInit && xFinal == yFinal) {
            	xInit = (int)(Math.random() * size);
            	yInit = (int)(Math.random() * size);
            	xFinal = (int)(Math.random() * size);
            	yFinal = (int)(Math.random() * size);
            }
           
                
           
            //Setting the final end and start points for the maze.
            maze.setStart(xInit, yInit);
            maze.setEnd(xFinal, yFinal);

            
        }
        return maze;
        
    }
    
    
    //Helper method to determine the direction of the cell. 
    private void getDirection(Maze maze, int xCoord, int yCoord) {
    	
    	//Checks location of the Cell and determines new direction. 
    	if (xCoord > 0)
        {
            if (!maze.isVisited(xCoord - 1, yCoord)){
                neighborDirections[counter] = Direction.LEFT;
                counter++;
            }
            
        }
    	if (yCoord > 0){
            if (!maze.isVisited(xCoord, yCoord - 1)){
                neighborDirections[counter] = Direction.DOWN;
                counter++;
            }
        }
    	
    	if (xCoord < maze.size() - 1){
            if (!maze.isVisited(xCoord + 1, yCoord)){
                neighborDirections[counter] = Direction.RIGHT;
                counter++;
            }
        }
    	
    	if (yCoord < maze.size() - 1){
            if (!maze.isVisited(xCoord, yCoord + 1)){
                neighborDirections[counter] = Direction.UP;
                counter++;
            }
        }
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
