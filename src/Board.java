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
        char firstLetter = s.charAt(0);
        // TODO: You write this!
        // Note: this is NOT a recursive method. You're going to loop through all the cells in the boggle board to see
        //   whether they are capable of starting a sequence that matches the given word. (i.e., is this letter the
        //   first letter of the given word?) If not, skip to the next cell.
        //   If it _could_ be the start of a sequence matching the given word, then you'll call the recursive
        //   checkRemainderOfWord() method to see whether it can find a sequence that matches. (That method will
        //   return a boolean.)
        //   If so, great! If not, try the next cell.

        return false; // might write return true elsewhere, if you find a valid path....
    }

    /**
     * checks whether the remainder of a string, starting with the index can be found in a non-repeating sequence of
     * adjacent letters in the grid, starting in the immediate neighborhood of the given (row, col).
     *  For example, suppose we have the following "grid" of letters and matching "used" grid of booleans
     *           U O U P            F F F F
     *  grid:    O L R S     used:  T T F F
     *           C Z O Q            T F F F
     *           A L T I            F F F F
     *  ... and we are given s= "COLOUR," index = 3, row = 1 and col = 1. This would mean that we are looking to match
     *   the "O" in the remainder of the string "OUR" in the vicinity of the "L" at the center (1,1) of the grid.
     *  And so far, we have already used locations (2,0), (1,0), and (1,1).
     *
     *  Let's consider all eight neighbors of (1,1) for this situation:
     *  • (0,0) - This letter U doesn't match the "O" we're looking for. Skip.
     *  • (0,1) - This letter O matches the "O," and it has not been used. This is a candidate for recursion.
     *  • (0,2) - This letter U doesn't match the "O" we're looking for. Skip.
     *  • (1,0) - This letter O matches the "O" we're looking for, but used[1][0] is true. Skip.
     *  • (1,2) - This letter R doesn't match the "O" we're looking for. Skip.
     *  • (2,0) - This letter C doesn't match (and it's used, anyway.) Skip.
     *  • (2,1) - This letter Z doesn't match the "O" we're looking for. Skip.
     *  • (2,2) - This letter O matches the "O," and it has not been used. This is a candidate for recursion.
     *
     * @param s - the string (all uppercase, in its entirety) that we are looking for
     * @param index - the index in the string where we are starting to look in this recursion
     * @param row - the row where the previous (index-1) letter was found
     * @param col - the col where the previous (index-1) letter was found
     * @return - whether we find this remainder of the string or not.
     */
    private boolean checkRemainderOfWord(String s, int index,int row, int col)
    {
        System.out.println("Checking "+s.substring(index)+" at "+row+" by "+col);
        // TODO: You write this! Make sure you read the notes above.
        // check for base case(s). If you've reached one, remember you are returning a true or false answer.
        // If you have found a matching, unused letter, mark this cell as "used." (There's a second 2-d array for this.)
        //      look in neighborhood recursively for a path with remainder of string. (You'll get back a true/false
        //      answer.)
        // when you get back from the recursion, mark this cell as unused now... we might need to search through here
        // again.
        // Return your answer... was there a path?

        return false;// might write return true elsewhere, if you reach the base case successfully.
    }

}
