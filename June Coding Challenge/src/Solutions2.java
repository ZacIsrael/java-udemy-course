import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class Solutions2 {

    public static void main(String[] args) {
//
//        System.out.println(validIPAddress("172.16.254.1"));
//        System.out.println(validIPAddress("2001:0db8:85a3:0000:0000:8A2E:0370:7334"));
//        System.out.println(validIPAddress("2001:0db8:85a3:0:0:8A2E:0370:7334"));
//        System.out.println(validIPAddress("256.256.256.256"));
//        solve(new char[][]{
//                {'X', 'O', 'X', 'X'},
//                {'X', 'O', 'O', 'X'},
//                {'X', 'X', 'O', 'X'},
//                {'X', 'O', 'X', 'X'}});
//
//        solve(new char[][]{
//                {'O', 'O', 'O'},
//                {'O', 'X', 'O'},
//                {'O', 'O', 'O'}});

        System.out.println(getPermutation(3,3));
       // createPermutations(3);

    }

    public static String getPermutation(int n, int k) {
        int[] fact = new int[n+1];
        fact[0] = 1;
        for (int i = 1; i <= n; i++) {
            fact[i] = fact[i-1] * i;
        }
        List<Integer> nums = IntStream.range(1, n+1).mapToObj(x->x).collect(Collectors.toList());

        StringBuilder sb = new StringBuilder("");
        k--;
        for (int i = 0; i <= n; i++) {
            int ind = k/ fact[n-i];
            sb.append(nums.get(ind));
            nums.remove(ind);
            k-= ind * fact[n-1];
        }
        return sb.toString();
    }
    /*
    StringBuilder sb = new StringBuilder("");
        for (int i = 1; i <= n; i++) {
            sb.append(i);
        }

        List<String> list = new ArrayList<>();
        createPermutations("", sb.toString(), list);
        return list.get(k-1);


     */

    public static void createPermutations(String pre, String s, List<String> list){
        if(s.isEmpty()){
            list.add(pre);
        } else{
            for (int i = 0; i < s.length(); i++) {
                createPermutations(pre+s.charAt(i), s.substring(0,i) + s.substring(i+1), list);
            }
        }
    }

    public static String longestDupSubstring(String S) {

        return null;
    }

    public static void solve(char[][] board) {


        if(board[0].length == 0 || board.length == 0) return;

        for (int i = 0; i <board.length; i++) {
            if(board[i][0] == 'O') depthFirstSearch(board, i, 0);
            if(board[i][board[0].length-1] == 'O') depthFirstSearch(board, i, board[0].length-1);
        }
        for (int i = 0; i < board[0].length; i++) {
            if(board[0][1] == 'O') depthFirstSearch(board, 0, i);
            if(board[board.length-1][i] == 'O') depthFirstSearch(board, board.length-1, i);
        }

        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                if(board[i][j] == 'O'){
                    board[i][j] = 'X';
                } else if(board[i][j] == '*'){
                    board[i][j] = '0';
                }
            }
        }
    }

    public static void depthFirstSearch(char[][] board, int i, int j){


        if(i > board.length -1 || i < 0 || j > board[0].length || j < 0) return;
        if(board[i][j] == 'O') board[i][j] = '*';
        if(i > 0 && board[i-1][j] == 'O'){
            depthFirstSearch(board, i-1, j);
        }
        if(i < board.length-1 && board[i+1][j] == 'O'){
            depthFirstSearch(board, i+1, j);
        }

        if(j > 0 && board[i][j-1] == 'O'){
            depthFirstSearch(board, i, j-1);
        }

        if(j < board[0].length-1 && board[i][j+1] == 'O'){
            depthFirstSearch(board, i, j+1);
        }

        return;
    }


//    public static void solve(char[][] board) {
//        int len = board.length;
//        for (int row = 0; row < len; row++) {
//            int colLen = board[row].length;
//            for (int column = 0; column < colLen; column++) {
//                System.out.println("At index [" + row + "]["
//                        + column + "] the value is " + board[row][column]);
//
//                if (row == 0 || row == len - 1) {
//                    break;
//                }
//                if (column == 0 || column == colLen - 1) {
//                    continue;
//                }
//                if (board[row][column] == 'O') {
//                    board[row][column] = 'X';
//                    System.out.println("At index [" + row + "]["
//                            + column + "] the value is now " + board[row][column] + " after the swap.");
//                }
//            }
//            System.out.println("\n");
//        }
//    }

    public static String validIPAddress(String IP) {
        if (isIP4(IP)) {
            return "IPv4";
        } else if (isIP6(IP)) {
            return "IPv6";
        } else {
            return "Neither";
        }
    }


    public static boolean isIP4(String IP) {

        String isNum = "";
        int curr = 0;
        int len = IP.length();

        for (int i = 0; i < len; i++) {
            if (i == len - 1) {
                isNum += IP.charAt(i);
                curr = i;
                break;
            } else if ((IP.charAt(i) + "").equals(".")) {
                curr = i;
                break;
            } else if (isNum.length() >= 4) {
                return false;
            }
            isNum += IP.charAt(i);

        }


        if ((isNum.charAt(0) + "").equals("0")) {
            return false;
        }
        int val = Integer.parseInt(isNum);
        if (curr == len - 1 && val < 255) {
            return true;
        } else if (val < 255) {
            return isIP4(IP.substring(curr + 1));
        } else {
            return false;
        }
    }

    public static boolean isIP6(String IP) {
        if (IP.contains(".")) {
            return false;
        }

        String num = "";
        int index = 0;
        int len = IP.length();
        HashSet<Character> allowedChars = new HashSet<>();
        allowedChars.add('A');
        allowedChars.add('B');
        allowedChars.add('C');
        allowedChars.add('D');
        allowedChars.add('E');
        allowedChars.add('F');

        for (int i = 0; i < len; i++) {
            if (i == len - 1) {
                num += IP.charAt(i);
                index = i;
                break;
            } else if ((IP.charAt(i) + "").equals(":")) {
                index = i;
                break;
            }
            num += IP.charAt(i);
        }
        if (index == len - 1 && num.length() <= 4) {
            return true;
        } else if (num.length() > 4 || num.isEmpty()) {
            return false;
        } else {
            return isIP6(IP.substring(index + 1));
        }
    }


//    public static String validIPAddress(String IP) {
//
//        final String IPV4 = "IPv4";
//        final String IPV6 = "IPv6";
//        final String NEITHER = "Neither";
//
//        if (IP.contains(".")) {
//
//            String[] segements = IP.split("\\.", -1);
//            if (segements.length != 4) {
//                return NEITHER;
//            }
//            for (String segment : segements) {
//                int len = segment.length();
//                if (len == 0 || len> 3) {
//                    return NEITHER;
//                }
//                for (int i = 0; i < Math.min(3, len); i++) {
//                    char c = segment.charAt(i);
//                    if (!Character.isDigit(c)) {
//                        return NEITHER;
//                    }
//                }
//                if (Integer.parseInt(segment) > 255 ||
//                        len != String.valueOf(Integer.parseInt(segment)).length()) {
//                    return NEITHER;
//                }
//            }
//            return IPV4;
//        } else {
//            String[] segements = IP.split(":", -1);
//            if (segements.length != 8) {
//                return NEITHER;
//            }
//            HashSet<Character> allowedChars = new HashSet<>();
//            allowedChars.add('A');
//            allowedChars.add('B');
//            allowedChars.add('C');
//            allowedChars.add('D');
//            allowedChars.add('E');
//            allowedChars.add('F');
//            for (String segment : segements) {
//                int len = segment.length();
//                if (segment.isEmpty() || len> 4) {
//                    return NEITHER;
//                }
//                for (int i = 0; i < Math.min(4, len); i++) {
//                    char c = segment.charAt(i);
//                    if (!Character.isDigit(c) && !allowedChars.contains(Character.toUpperCase(c))) {
//                        return NEITHER;
//                    }
//                }
//            }
//            return IPV6;
//        }
//
//    }
}
