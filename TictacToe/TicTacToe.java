package Things;

import java.util.*;

public class TicTacToe {

    static ArrayList<Integer> playerPosition = new ArrayList<Integer>();
    static ArrayList<Integer> cpuPosition = new ArrayList<Integer>();

    public static void main(String[] args) {
        char[][] gameBoard = {{' ', '|', ' ', '|', ' ', '|', ' ', '|', ' '},
                {'-', '+', '-', '+', '-', '+', '-', '+', '-'},
                {' ', '|', ' ', '|', ' ', '|', ' ', '|', ' '},
                {'-', '+', '-', '+', '-', '+', '-', '+', '-'},
                {' ', '|', ' ', '|', ' ', '|', ' ', '|', ' '},
                {'-', '+', '-', '+', '-', '+', '-', '+', '-'},
                {' ', '|', ' ', '|', ' ', '|', ' ', '|', ' '},
                {'-', '+', '-', '+', '-', '+', '-', '+', '-'},
                {' ', '|', ' ', '|', ' ', '|', ' ', '|', ' '}};
        printGameBoard(gameBoard);
        while (true) {
            Scanner sc = new Scanner(System.in);
            System.out.println("Enter your placement: ");
            int playerpos = sc.nextInt();

            while (playerPosition.contains(playerpos) || cpuPosition.contains(playerPosition)) {
                System.out.println("Position taken!Enter a new place: ");
                playerpos = sc.nextInt();
            }

            System.out.println(playerpos);
            placements(gameBoard,playerpos, "player");
            String result = checkWinner();
            if (result.length() > 0) {
                System.out.println(result);
                break;
            }

            Random rand = new Random();
            int cpuPos = rand.nextInt(23) + 1;

            while (playerPosition.contains(cpuPos) || cpuPosition.contains(cpuPos)) {
                cpuPos = rand.nextInt(23) + 1;
            }
            placements(gameBoard, cpuPos, "cpu");

            printGameBoard(gameBoard);

            result = checkWinner();
            if (result.length() > 0) {
                System.out.println(result);
                break;
            }
        }
    }

    public static void printGameBoard(char[][] gameBoard) {
        for (char[] row : gameBoard) {
            for (char c : row) {
                System.out.print(c);
            }
            System.out.println();
        }
    }

    public static void placements(char[][] gameBoard, int pos, String user) {
        char symbol = ' ';


        if (user.equals("player")) {
            symbol = 'X';
            playerPosition.add(pos);
        }else if (user.equals("cpu")) {
            symbol = 'O';
            cpuPosition.add(pos);
        }



        switch (pos) {
            case 1:
                gameBoard[0][0] = symbol;
                break;
            case 2:
                gameBoard[0][2] = symbol;
                break;
            case 3:
                gameBoard[0][4] = symbol;
                break;
            case 4:
                gameBoard[0][6] = symbol;
                break;
            case 5:
                gameBoard[0][8] = symbol;
                break;
            case 6:
                gameBoard[2][0] = symbol;
                break;
            case 7:
                gameBoard[2][4] = symbol;
                break;
            case 8:
                gameBoard[2][6] = symbol;
                break;
            case 9:
                gameBoard[2][8] = symbol;
                break;
            case 10:
                gameBoard[4][0] = symbol;
                break;
            case 11:
                gameBoard[4][2] = symbol;
                break;
            case 12:
                gameBoard[4][6] = symbol;
                break;
            case 13:
                gameBoard[4][8] = symbol;
                break;
            case 14:
                gameBoard[6][0] = symbol;
                break;
            case 15:
                gameBoard[6][2] = symbol;
                break;
            case 16:
                gameBoard[6][4] = symbol;
                break;
            case 17:
                gameBoard[6][6] = symbol;
                break;
            case 18:
                gameBoard[6][8] = symbol;
                break;
            case 19:
                gameBoard[8][0] = symbol;
                break;
            case 20:
                gameBoard[8][2] = symbol;
                break;
            case 21:
                gameBoard[8][4] = symbol;
                break;
            case 22:
                gameBoard[8][6] = symbol;
                break;
            case 23:
                gameBoard[8][8] = symbol;
                break;
            default:
                break;
        }
    }
    public static String checkWinner() {
        List topRow = Arrays.asList(1,2,3,4,5);
        List midRow1 = Arrays.asList(6,7,8,9,10);
        List midRow2 = Arrays.asList(11,12,13,14,15);
        List midRow3 = Arrays.asList(16,17,18,19,20);
        List botRow = Arrays.asList(21,22,23,24,23);
        List cross1 = Arrays.asList(1,7,13,19,23);
        List cross2 = Arrays.asList(5,9,13,17,21);

        List<List> winningCons = new ArrayList<List>();
        winningCons.add(topRow);
        winningCons.add(midRow1);
        winningCons.add(midRow2);
        winningCons.add(midRow3);
        winningCons.add(botRow);
        winningCons.add(cross1);
        winningCons.add(cross2);

        for (List l : winningCons) {
            if (playerPosition.containsAll(l)) {
                return "Congratulation! u won....";
            }else if (cpuPosition.containsAll(l)) {
                return "u lose!";
            }else if (playerPosition.size() + cpuPosition.size() == 25) {
                return "Draw";
            }
        }
        return "";

    }
}

