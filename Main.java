import java.util.Scanner;
class Main {
  public static void main(String[] args) {
    Scanner reader = new Scanner(System.in);
    System.out.println("Welcome to treasure island! Your objective; try to get as much treasure as possible without hitting the mines(basically the one minigame for new super mario bros for the wii where you have to wack the squares and minesweaper combined).\nThe user is not a programmer");
    int score = 0;
    int loose = 3;
    int[][] map = new int[6][6];
    char[][] grid = new char[6][6];
    int range = (3) + 0;
    for(int i = 0; i < map.length; i++)
    {
      for(int j = 0; j < map[0].length; j++)
      {
        grid[i][j] = '?';
        int randomNumber = (int) (Math.random() * range) + 0;
        map[i][j] = randomNumber;
      }
    }
    while(true)
    {
      System.out.println("Score: " + score);
      for(int i = 0; i < map.length; i++)
      {
        for(int j = 0; j < map[0].length; j++)
        {
          System.out.print(grid[i][j] + "\t");
        }
        System.out.println();
      }
      if(win(grid))
      {
        break;
      }
      System.out.print("Enter the row: ");
      int row = reader.nextInt();
      System.out.print("Enter the column: ");
      int column = reader.nextInt();
      row    -= 1;
      column -= 1;
      if(row < 0 || row >= map.length || column < 0 || column >= map[0].length)
      {
        System.out.println("Incorrect row or column");
      }
      else if(map[row][column] != 0)
      {
        if(grid[row][column] == 'X')
        {
          System.out.println("You hve already guessed this location");
        }
        else
        {
          grid[row][column] = 'X';
          score += 50 * map[row][column];
        }
      }
      else
      {
        loose--;
        if(loose == 0)
        {
          System.out.println("The island has collapsed");
          break;
        }
        else
        {
          System.out.println("You have hit a mine. You have " + loose + " chance(s) till the island sinks");
        }
      }
    }
    if(win(grid))
    {
      System.out.println("Congrats!! You win with a score of " + score);
    }
    else
    {
      System.out.println("Your final score was: " + score);
      for(int i = 0; i < map.length; i++)
      {
        for(int j = 0; j < map[0].length; j++)
        {
          System.out.print(map[i][j] + "\t");
        }
        System.out.println();
      }
    }
  }
  public static boolean win(char[][] grid)
  {
    for(int i = 0; i < grid.length; i++)
    {
      for(int j = 0; j < grid[0].length; j++)
      {
        if(grid[i][j] != 'X')
        {
          return false;
        }
      }
    }
    return true;
  }
}
