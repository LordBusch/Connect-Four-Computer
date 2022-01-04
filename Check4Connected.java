public class Check4Connected extends GameField{

    public static int checkedLine = 0;
    public static int checkedSplit = 0;
    int MaxCheckersInRow[] = new int[9];

    Check4Connected() {
        Check();
    }

    public void Check() {
        for (int i = 0; i < 9; i++) {
            MaxCheckersInRow[i] = 1;
        }
        System.out.println(checkedLine + "  " + checkedSplit);
        GameField.activeColor = GameField.boardArray[checkedLine][checkedSplit];
        System.out.println(GameField.activeColor);

            
            //check west
            for (int x = 0; x < MaxCheckersInRow[1]; x++) {
                if (GameField.boardArray[checkedLine][checkedSplit - MaxCheckersInRow[1]] == GameField.activeColor) MaxCheckersInRow[1]++;
                if (MaxCheckersInRow[1] >= 4) { GameField.GameActive = false; System.out.println("WON"); }
            }
            System.out.println(MaxCheckersInRow[1] + " West");
            //check northwest
            for (int x = 0; x < MaxCheckersInRow[2]; x++) {
                if (GameField.boardArray[checkedLine - MaxCheckersInRow[2]][checkedSplit - MaxCheckersInRow[2]] == GameField.activeColor) MaxCheckersInRow[2]++;
                if (MaxCheckersInRow[2] >= 4) { GameField.GameActive = false; System.out.println("WON"); }
            }
            System.out.println(MaxCheckersInRow[2] + " NorthWest");
            
            //check northeast
            for (int x = 0; x < MaxCheckersInRow[3]; x++) {
                if (GameField.boardArray[checkedLine - MaxCheckersInRow[2]][checkedSplit + MaxCheckersInRow[3]] == GameField.activeColor) MaxCheckersInRow[3]++;
                if (MaxCheckersInRow[3] >= 4) { GameField.GameActive = false; System.out.println("WON"); }
            }
            System.out.println(MaxCheckersInRow[3] + " NorthEast");

            //check east
            for (int x = 0; x < MaxCheckersInRow[4]; x++) {
                if (GameField.boardArray[checkedLine][checkedSplit + MaxCheckersInRow[4]] == GameField.activeColor) MaxCheckersInRow[4]++;
                if (MaxCheckersInRow[4] >= 4) { GameField.GameActive = false; System.out.println("WON"); }
            }
            System.out.println(MaxCheckersInRow[4] + " East");
            
            //check southeast
            for (int x = 0; x < MaxCheckersInRow[5]; x++) {
                if (GameField.boardArray[checkedLine + MaxCheckersInRow[5]][checkedSplit + MaxCheckersInRow[5]] == GameField.activeColor) MaxCheckersInRow[5]++;
                if (MaxCheckersInRow[5] >= 4) { GameField.GameActive = false; System.out.println("WON"); }
            }
            System.out.println(MaxCheckersInRow[5] + " SouthEast");
            
            //check south
            for (int x = 0; x < MaxCheckersInRow[6]; x++) {
                if (GameField.boardArray[checkedLine + MaxCheckersInRow[6]][checkedSplit] == GameField.activeColor) MaxCheckersInRow[6]++;
                if (MaxCheckersInRow[6] >= 4) { GameField.GameActive = false; System.out.println("WON"); }
            }
            System.out.println(MaxCheckersInRow[6] + " South");
            

            //check southwest
            for (int x = 0; x < MaxCheckersInRow[7]; x++) {
                if (GameField.boardArray[checkedLine + MaxCheckersInRow[7]][checkedSplit - MaxCheckersInRow[7]] == GameField.activeColor) MaxCheckersInRow[7]++;
                if (MaxCheckersInRow[7] >= 4) { GameField.GameActive = false; System.out.println("WON"); }
            }
            System.out.println(MaxCheckersInRow[7] + " Southwest");
            
            //check, if the checker was placed in a line of 4
            if (MaxCheckersInRow[1] + MaxCheckersInRow[4] >= 5) { GameField.GameActive = false; System.out.println("WON"); }
            if (MaxCheckersInRow[2] + MaxCheckersInRow[5] >= 5) { GameField.GameActive = false; System.out.println("WON"); }
            if (MaxCheckersInRow[3] + MaxCheckersInRow[7] >= 5) { GameField.GameActive = false; System.out.println("WON"); }
    }
    
}