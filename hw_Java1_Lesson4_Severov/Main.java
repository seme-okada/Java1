import java.util.Random;
import java.util.Scanner;

public class Main
{

    /**
     * Tic Tac Toe
     * <p>
     * 1. Инициализровать игровое поле
     * 2. Игрок - Х, Компьютер - О
     * 3. Игрок всегда ходит первый
     * 4. Реализовать ход игрока по координатам [X, Y]
     * 5. Реализовать ход компьютера по координатам [X, Y]
     * 6. Защита от неверных координат [X, Y] введенных игроком
     * 7. Защита от попытки ввести координаты [X, Y] в уже занятую ячейку
     * 8. Игра до победы
     * 9. Проверка победы
     * 10. Победа
     * 11. Проверка на ничью
     */
    public static void main(String[] args)
    {
        playTicTacToe();
    }

    static void playTicTacToe()
    {
        char[][] field = getField5X5();
        drawField(field);

        char playerSign   = 'X';
        char computerSign = 'O';
        char emptySign    = '-';
        char currentPlayerSign = playerSign;
        String currentPlayerName = "Player";

        boolean isWin;
        boolean isNoWin;
        do {
            move(field, currentPlayerSign, playerSign, computerSign, emptySign);
            isWin   = checkWin(field, currentPlayerSign);
            isNoWin = checkNobodyWin(field, playerSign, computerSign);
            if (!isWin) {
                currentPlayerSign = currentPlayerSign == playerSign ? computerSign : playerSign;
                currentPlayerName = currentPlayerSign == playerSign ? "Player" : "Computer";
                drawField(field);
            }
        } while(!isWin && !isNoWin);

        if (isWin)
            System.out.println(String.format("Congrats!!! You are winner Mr. %s", currentPlayerName));
        if (isNoWin)
            System.out.println("Game over. No one won.");

        drawField(field);
    }

    static void move(char[][] aField
                   , char aCurrentPlayerSign
                   , char aPlayerSign
                   , char aCompSign
                   , char aEmptySign)
    {
        if (aCurrentPlayerSign == 'X') {
            movePlayerSign(aField, aCurrentPlayerSign);
        } else {
            moveComputer(aField, aPlayerSign, aCompSign, aEmptySign);
        }
    }

    static boolean checkNobodyWin(char[][] aField, char aPlayerSign, char aCompSign)
    {
        for (char[] row : aField)
            for (char el : row)
                if ( (el != aPlayerSign) && (el != aCompSign) )
                    return false;

        return true;
    }

    static boolean checkHorizontalWin(char[][] aField, int aRow, int aCol, char aCurrentPlayerSing)
    {
        int vCntSigns = 0;
        int vCol      = aCol;

        while (    vCol < aField[0].length
                && aField[aRow][vCol] == aCurrentPlayerSing )
        {
            vCntSigns++;
            vCol++;
            if (vCntSigns == getCntSigns2Win()) return true;
        }

        return false;
    }

    static boolean checkVerticalWin(char[][] aField, int aRow, int aCol, char aCurrentPlayerSing)
    {
        int vCntSigns = 0;
        int vRow      = aRow;

        while (    vRow < aField.length
                && aField[vRow][aCol] == aCurrentPlayerSing )
        {
            vCntSigns++;
            vRow++;
            if (vCntSigns == getCntSigns2Win()) return true;
        }

        return false;
    }

    static boolean checkDiagonalLeft2Right(char[][] aField, int aRow, int aCol, char aCurrentPlayerSing)
    {
        int vCntSigns = 0;
        int vRow      = aRow;
        int vCol      = aCol;

        while (    vRow < aField   .length
                && vCol < aField[0].length
                && aField[vRow][vCol] == aCurrentPlayerSing
        )
        {
            vCntSigns++;
            vRow++;
            vCol++;
            if (vCntSigns == getCntSigns2Win()) return true;
        }

        return false;
    }

    static boolean checkDiagonalRight2Left(char[][] aField, int aRow, int aCol, char aCurrentPlayerSing)
    {
        int vCntSigns = 0;
        int vRow      = aRow;
        int vCol      = aCol;

        while (    vRow < aField.length
                && vCol >= 0
                && aField[vRow][vCol] == aCurrentPlayerSing
               )
        {
            vCntSigns++;
            vRow++;
            vCol--;
            if (vCntSigns == getCntSigns2Win()) return true;
        }

        return false;
    }

    static boolean checkWin(char[][] aField, char aCurrentPlayerSign) {
        for (int i = 0; i < aField.length; i++)
        {
            for (int j = 0; j < aField[0].length; j++)
            {
                     if ( checkHorizontalWin     (aField, i, j, aCurrentPlayerSign) ) return true;
                else if ( checkVerticalWin       (aField, i, j, aCurrentPlayerSign) ) return true;
                else if ( checkDiagonalLeft2Right(aField, i, j, aCurrentPlayerSign) ) return true;
                else if ( checkDiagonalRight2Left(aField, i, j, aCurrentPlayerSign) ) return true;
            }
        }

        return false;
    }

    static char rowIdx2RowLetter(int aRowIdx)
    {
        return (char) ('a' + aRowIdx % 26);
    }
    static char colIdx2ColNum(int aColIdx)
    {
        return (char) (aColIdx + 1 + '0');
    }

    static int move2RowIdx(String aMove)
    {
        return aMove.charAt(0) - 'a';
    }

    static int move2ColIdx(String aMove)
    {
        return aMove.charAt(1) - '0' - 1;
    }

    static void moveComputer(char[][] aField, char aPlayerSign, char aComputerSign, char aEmptySign)
    {
        if (!moveComputerBlocking(aField, aPlayerSign, aComputerSign, aEmptySign))
        {
            moveComputerSimple(aField, aComputerSign);
        }
    }

    static void moveComputerSimple(char[][] aField, char aComputerSign)
    {
        int vRow;
        int vCol;
        Random random = new Random();

        do {
            vRow = random.nextInt(aField   .length);
            vCol = random.nextInt(aField[0].length);
        } while (!isCellEmpty(aField, vRow, vCol));

        System.out.println("Computer's move ...");
        System.out.println(String.format("Computer made a move: %c%c"
                                         , rowIdx2RowLetter(vRow)
                                         , colIdx2ColNum   (vCol)
                                         ));
        aField[vRow][vCol] = aComputerSign;
    }

    static int getFirstRow4NextMove(int vRowCur)
    {
        if (vRowCur - 1 >= 0)
        {
            return vRowCur - 1;
        }
        else
        {
            return vRowCur;
        }
    }

    static int getLastRow4NextMove(char[][] aField, int vRowCur)
    {
        if (vRowCur + 1 < aField.length)
        {
            return vRowCur + 1;
        }
        else
        {
            return vRowCur;
        }
    }

    static int getFirstCol4NextMove(int vColCur)
    {
        if (vColCur - 1 >= 0)
        {
            return vColCur - 1;
        }
        else
        {
            return vColCur;
        }
    }

    static int getLastCol4NextMove(char[][] aField, int vColCur)
    {
        if (vColCur + 1 < aField[0].length)
        {
            return vColCur + 1;
        }
        else
        {
            return vColCur;
        }
    }

    static int getEmptyNearbyCellsCount(char[][] aField
                                      , char aEmptySign
                                      , int  aRowFrom
                                      , int  aRowTo
                                      , int  aColFrom
                                      , int  aColTo)
    {
        int cntEmptyCells = 0;
        for (int row = aRowFrom; row <= aRowTo; row++)
            for(int col = aColFrom; col <= aColTo; col++)
                if (aField[row][col] == aEmptySign)
                    cntEmptyCells++;

        return cntEmptyCells;
    }

    static int[][] putEmptyCells2Array(char[][] aField
                                     , char aEmptySign
                                     , int  aRowFrom
                                     , int  aRowTo
                                     , int  aColFrom
                                     , int  aColTo
                                     , int  aCnt)
    {
        int     vRow4Coordinate = 0;
        int[][] vArrNearbyCells = new int[aCnt][2];
        for (int row = aRowFrom; row <= aRowTo; row++)
            for(int col = aColFrom; col <= aColTo; col++)
            {
                if (aField[row][col] == aEmptySign)
                {
                    vArrNearbyCells[vRow4Coordinate][0] = row;
                    vArrNearbyCells[vRow4Coordinate][1] = col;
                    vRow4Coordinate++;
                }
            }

        return vArrNearbyCells;
    }

    static int[][] expandArray(int[][] aArrSource
                             , int aStartIdx
                             , int aNewLength)
    {
        int[][] vArrResult = new int[aNewLength][2];

        if (aArrSource.length > 0)
        {
            for (int row = aStartIdx; row < aArrSource.length; row++)
            {
                vArrResult[row][0] = aArrSource[row - aStartIdx][0];
                vArrResult[row][1] = aArrSource[row - aStartIdx][1];
            }

        }
        return vArrResult;
    }

    static int[][] addFindingCells2PossMoves(int[][] aArrSource, int[][] aArrReceiver)
    {
        int[][] vArrPossibleMovesTmp = expandArray(aArrReceiver, 0, aArrReceiver.length);
        aArrReceiver = expandArray(vArrPossibleMovesTmp, 0, aArrReceiver.length + aArrSource.length);

        // Добавление в общий массив найденных координат
        int rowStartFrom = vArrPossibleMovesTmp.length;
        for (int row = rowStartFrom; row < aArrReceiver.length; row++)
        {
            aArrReceiver[row][0] = aArrSource[row - rowStartFrom][0];
            aArrReceiver[row][1] = aArrSource[row - rowStartFrom][1];
        }

        return aArrReceiver;
    }

    static int[][] findPossibleMoves(char[][] aField
                                   , char     aPlayerSign
                                   , char     aEmptySign)
    {
        int[][] vArrPossibleMoves = new int[0][2];
        for (int i = 0; i < aField.length; i++)
            for (int j = 0; j < aField[0].length; j++)
            {
                if (aField[i][j] == aPlayerSign)
                {
                    int vRowFirst = getFirstRow4NextMove(i);
                    int vRowLast  = getLastRow4NextMove (aField, i);
                    int vColFirst = getFirstCol4NextMove(j);
                    int vColLast  = getLastCol4NextMove (aField, j);

                    int cntEmptyCells = getEmptyNearbyCellsCount(aField
                                                               , aEmptySign
                                                               , vRowFirst
                                                               , vRowLast
                                                               , vColFirst
                                                               , vColLast);

                    int[][] vArrNearbyCells = putEmptyCells2Array(aField
                                                                , aEmptySign
                                                                , vRowFirst
                                                                , vRowLast
                                                                , vColFirst
                                                                , vColLast
                                                                , cntEmptyCells);

                    vArrPossibleMoves = addFindingCells2PossMoves(vArrNearbyCells
                                                                , vArrPossibleMoves);
                }
            }
        return vArrPossibleMoves;
    }

    static boolean moveComputerBlocking(char[][] aField, char aPlayerSign, char aCompSign, char aEmptySign)
    {
        int[][] vArrPossibleMoves = findPossibleMoves(aField, aPlayerSign, aEmptySign);

        if (vArrPossibleMoves.length == 0) return false;

        int vRow;
        int vCol;
        Random random = new Random();
        int vMoveNum = random.nextInt(vArrPossibleMoves.length);
        vRow = vArrPossibleMoves[vMoveNum][0];
        vCol = vArrPossibleMoves[vMoveNum][1];

        System.out.println("Computer's move ...");
        System.out.println(String.format("Computer made a move: %c%c"
                                       , rowIdx2RowLetter(vRow)
                                       , colIdx2ColNum   (vCol)
                                         ));
        aField[vRow][vCol] = aCompSign;

        return true;
    }

    static void movePlayerSign(char[][] field, char playerSign)
    {
        String  vMove;
        int     vRow;
        int     vCol;
        boolean vIsEmptyCell;

        do {
            boolean isCorrectCoordinates;
            do {
                Scanner scanner = new Scanner(System.in);
                System.out.println("Make your move...");
                System.out.println("Format: <row letter><column number> (example: \"a1\")");
                vMove = scanner.nextLine();
                vRow  = move2RowIdx(vMove);
                vCol  = move2ColIdx(vMove);

                isCorrectCoordinates = checkCoordinates(field, vRow, vCol);
                notifyIncorrectCoordinates(isCorrectCoordinates, field);
            } while (!isCorrectCoordinates);

            vIsEmptyCell = isCellEmpty(field, vRow, vCol);
            notifyOccupiedCell(vIsEmptyCell, vRow, vCol);
        } while (!isCellEmpty(field, vRow, vCol));

        field[vRow][vCol] = playerSign;
    }

    static boolean isCellEmpty(char[][] field, int x, int y) {
        return field[x][y] == '-';
    }

    static void notifyOccupiedCell(boolean isOccupied, int aRow, int aCol)
    {
        if (!isOccupied)
        {
            System.out.println(String.format("The entered move is incorrect. Cell \"%c%c\" is already occupied"
                                             , rowIdx2RowLetter(aRow)
                                             , colIdx2ColNum(aCol)
                                             ));
        }
    }

    static void notifyIncorrectCoordinates(boolean isCorrect, char[][] aField)
    {
        char vMinRowLet = 'a';
        char vMaxRowLet = rowIdx2RowLetter(aField.length - 1);
        char vMinColNum = '1';
        char vMaxColNum = colIdx2ColNum(aField[0].length - 1);
        if (!isCorrect)
        {
            System.out.printf("The entered move is incorrect. Available moves in range [%c - %c][%c - %c]"
                              , vMinRowLet, vMaxRowLet, vMinColNum, vMaxColNum);
            System.out.println();
        }
    }

    static boolean checkCoordinates(char[][] aField, int aRow, int aCol)
    {
        return (aRow >= 0 && aRow < aField   .length)
            && (aCol >= 0 && aCol < aField[0].length);
    }

    static void fillRowHeaders(char[][] aFieldDisplay)
    {
        for (int rowNum = 1; rowNum < aFieldDisplay.length; rowNum++)
            aFieldDisplay[rowNum][0] = (char) ('a' + (rowNum - 1) % 26);
    }

    static void fillColHeaders(char[][] aFieldDisplay)
    {
        for (int colNum = 1; colNum < aFieldDisplay[0].length; colNum++)
            aFieldDisplay[0][colNum] = (char) (colNum + '0');
    }

    static void fillMainField(char[][] aFieldDisplay, char[][] aField)
    {
        for (int i = 1; i < aFieldDisplay.length; i++)
            for (int j = 1; j < aFieldDisplay[i].length; j++)
            {
                aFieldDisplay[i][j] = aField[i - 1][j - 1];
            }
    }

    static char[][] getDisplayField(char[][] aField)
    {
        char[][] vFieldDisplay = new char[aField.length + 1][aField[0].length + 1];

        vFieldDisplay[0][0] = ' ';
        fillRowHeaders(vFieldDisplay);
        fillColHeaders(vFieldDisplay);
        fillMainField (vFieldDisplay, aField);

        return vFieldDisplay;
    }

    static void drawField(char[][] field)
    {
        for (char[] rowNum : getDisplayField(field))
        {
            for (char colNum : rowNum)
            {
                System.out.print(" " + colNum + " ");
            }
            System.out.println();
        }
    }

    static char[][] getField()
    {
        return new char[][] {
                                {'-', '-', '-'},
                                {'-', '-', '-'},
                                {'-', '-', '-'}
                             };
    }

    static char[][] getField5X5()
    {
        return new char[][] {
                                {'-', '-', '-', '-', '-'},
                                {'-', '-', '-', '-', '-'},
                                {'-', '-', '-', '-', '-'},
                                {'-', '-', '-', '-', '-'},
                                {'-', '-', '-', '-', '-'}
                            };
    }

    static int getCntSigns2Win()
    {
        return 4;
    }
}