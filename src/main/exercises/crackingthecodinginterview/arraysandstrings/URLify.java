package exercises.crackingthecodinginterview.arraysandstrings;

import java.util.ArrayDeque;
import java.util.Queue;

public class URLify {

    public static void urlifyNoQ(char[] url, int length) {
        int numSpaces = 0;
        for(int i = 0; i < length; i++) {
            if(url[i] == ' ') {
                numSpaces++;
            }
        }
        int resEnd = length + 2*numSpaces - 1;
        for(int i = length - 1; i >= 0; i--) {
            if (url[i] == ' ') {
                resEnd = insertSpaceCode(url, resEnd);
            } else {
                url[resEnd] = url[i];
            }
            resEnd --;
        }
    }

    private static int insertSpaceCode(char[] word, int index) {
        word[index--] = '0';
        word[index--] = '2';
        word[index] = '%';
        return index;
    }

    public static void urlifyQ(char[] url, int length) {
        Queue<Character> q = new ArrayDeque<>();
        int i = 0;
        while(i < length) {
            char c = url[i];
            enqueueLetter(q, c);
            url[i] = q.remove();
            i++;
        }
        while(!q.isEmpty()) {
            url[i] = q.remove();
            i++;
        }
    }

    private static void enqueueLetter(Queue<Character> q, char letter) {
        if(letter == ' ') {
            q.add('%');
            q.add('2');
            q.add('0');
        } else {
            q.add(letter);
        }
    }
}
