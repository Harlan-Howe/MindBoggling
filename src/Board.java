public class Board
{
    private final char[][] grid;
    private final boolean[][] used;
    private final int size;
    private final char[] vowels = {'A','E','I','O','U'};
    private final char[] consonants = {'B','C','D','F','G','H','J','K','L','M','N','P','Q','R','S','T','V','W','X','Y','Z'};


    public Board()
    {
        this(4);
    }

    public Board(int size)
    {
        this.size = size;
        grid = new char[size][size];
        used = new boolean[size][size];
        randomize();
    }

    /**
     * pick new letters for the board, with a given distribution of vowels and consonants.
     */
    public void randomize()
    {
        for (int i=0; i< size; i++)
            for(int j=0; j<size; j++)
                if (Math.random()<0.25)  // this is the percentage of vowels we expect to see on the board.
                    grid[i][j] = vowels[(int)(Math.random()*5)];
                else
                    grid[i][j] = consonants[(int)(Math.random()*21)];
    }

    public String toString()
    {
        String result = "";

        for (char[] row : grid)
        {
            for (char cell : row)
            {
                result+=" "+ cell + " ";
            }
            result+="\n";
        }
        return result;
    }

    /**
     * resets all the used values to "false" to indicate that we are starting a new search.
     */
    private void clearAllUsed()
    {
        for (int i=0; i<size; i++)
            for (int j=0; j<size; j++)
                used[i][j] = false;
    }

    /**
     * determines whether the given string can be found as a non-repeating sequence of adjacent letters in the board grid.
     * @param s - the (all uppercase) string we are looking for
     * @return - whether the string is found (true/false)
     */
    public boolean checkWord(String s)
    {
        // clear all "used" to false...
        clearAllUsed();
        // TODO: You write this!
        // Note: this is not a recursive method. You're going to loop through all the cells in the boggle board to see
        //   whether they are capable of starting a sequence that matches the given word. If not, skip to the next
        //   cell. If it _could_ be the start of a sequence matching the given word, then you'll call the recursive
        //   checkRemainderOfWord() method to see whether it can find a sequence that matches. If so, great! If not,
        //   try the next cell.

        return false; // might write return true elsewhere, if you find a valid path....
    }



    /**
     * checks whether the remainder of a string, starting with the index can be found in a non-repeating sequence of
     * adjacent letters in the grid, starting in the immediate neighborhood of the given (row, col).
     * @param s - the string (all uppercase, in its entirety) that we are looking for
     * @param index - the index in the string where we are starting to look in this recursion
     * @param row - the row where the previous (index-1) letter was found
     * @param col - the col where the previous (index-1) letter was found
     * @return - whether we find the string or not.
     */
    private boolean checkRemainderOfWord(String s, int index,int row, int col)
    {
        System.out.println("Checking "+s.substring(index)+" at "+row+" by "+col);
        // TODO: You write this!
        // check for base case(s).
        // mark this cell as used.
        // look in neighborhood for a path with remainder of string. (You'll get back a true/false answer.)
        // mark this cell as unused now... we might need to search through here again.
        // return your answer... was there a path?

        return false;// might write return true elsewhere, if you reach the base case successfully.
    }

}
