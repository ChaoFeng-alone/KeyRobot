package writer;

import win.MainWin;

import java.awt.*;
import java.awt.event.KeyEvent;
import java.util.HashMap;
import java.util.Map;

public class Writer {
    static Robot robot;

    public static Map<Character, Integer> map = new HashMap<>();

    static {
        try {
            robot = new Robot();
        } catch (AWTException e) {
            e.printStackTrace();
        }
        int tmp = 0x41;
        for (char i = 'a'; i <= 'z'; ++i, ++tmp) {
            map.put(i, tmp);
        }

        tmp = KeyEvent.VK_0;
        for (char i = '0'; i <= '9'; i++, tmp++) {
            map.put(i, tmp);
        }

        map.put(' ', KeyEvent.VK_SPACE);
        map.put(',', KeyEvent.VK_COMMA);
        map.put('.', KeyEvent.VK_PERIOD);
        map.put('/', KeyEvent.VK_SLASH);
        map.put('\'', KeyEvent.VK_QUOTE);
        map.put(';', KeyEvent.VK_SEMICOLON);
        map.put('=', KeyEvent.VK_EQUALS);
        map.put('[', KeyEvent.VK_OPEN_BRACKET);
        map.put('\\', KeyEvent.VK_BACK_SLASH);
        map.put(']', KeyEvent.VK_CLOSE_BRACKET);
        map.put('-', KeyEvent.VK_MINUS);
    }

    public static void writeEnter() {
        robot.keyPress(KeyEvent.VK_ENTER);
        robot.keyRelease(KeyEvent.VK_ENTER);
        robot.delay(100);
    }

    public static void writeString(MainWin win, String input) {
        for (int i = 0; i < input.length(); i++) {
            if (input.charAt(i) >= 'a' && input.charAt(i) <= 'z') {
                writeLowerChar(map.get(input.charAt(i)));
                win.outputAppend(input.charAt(i));
            } else if (input.charAt(i) >= 'A' && input.charAt(i) <= 'Z') {
                writeUpperChar(map.get(Character.toLowerCase(input.charAt(i))));
                win.outputAppend(input.charAt(i));
            } else if (input.charAt(i) >= '0' && input.charAt(i) <= '9') {
                keyPress(map.get(input.charAt(i)));
                win.outputAppend(input.charAt(i));
            } else if (teshu(input.charAt(i)))
                win.outputAppend(input.charAt(i));
            else {
                if (map.get(input.charAt(i)) != null) {
                    keyPress(map.get(input.charAt(i)));
                    win.outputAppend(input.charAt(i));
                }
            }
        }
    }

    public static void writeLowerChar(int c) {
        robot.keyPress(c);
        robot.keyRelease(c);
        robot.delay(100);
    }

    public static void writeUpperChar(int c) {
        robot.keyPress(KeyEvent.VK_CAPS_LOCK);
        robot.keyRelease(KeyEvent.VK_CAPS_LOCK);
        robot.delay(100);
        robot.keyPress(c);
        robot.keyRelease(c);
        robot.delay(100);
        robot.keyPress(KeyEvent.VK_CAPS_LOCK);
        robot.keyRelease(KeyEvent.VK_CAPS_LOCK);
        robot.delay(100);
    }

    private static void keyPress(int i) {
        robot.keyPress(i);
        robot.keyRelease(i);
        robot.delay(100);
    }

    private static void keyPressWithShift(int i) {
        robot.keyPress(KeyEvent.VK_SHIFT);
        robot.keyPress(i);
        robot.keyRelease(i);
        robot.keyRelease(KeyEvent.VK_SHIFT);
        robot.delay(100);
    }

    private static boolean teshu(char tmp) {
        if (tmp == '?') {
            keyPressWithShift(map.get('/'));
            return true;
        } else if (tmp == ':') {
            keyPressWithShift(map.get(';'));
            return true;
        } else if (tmp == '"') {
            keyPressWithShift(map.get('\''));
            return true;
        } else if (tmp == '!') {
            keyPressWithShift(map.get('1'));
            return true;
        } else if (tmp == '@') {
            keyPressWithShift(map.get('2'));
            return true;
        } else if (tmp == '#') {
            keyPressWithShift(map.get('3'));
            return true;
        } else if (tmp == '$') {
            keyPressWithShift(map.get('4'));
            return true;
        } else if (tmp == '%') {
            keyPressWithShift(map.get('5'));
            return true;
        } else if (tmp == '^') {
            keyPressWithShift(map.get('6'));
            return true;
        } else if (tmp == '&') {
            keyPressWithShift(map.get('7'));
            return true;
        } else if (tmp == '*') {
            keyPressWithShift(map.get('8'));
            return true;
        } else if (tmp == '(') {
            keyPressWithShift(map.get('9'));
            return true;
        } else if (tmp == ')') {
            keyPressWithShift(map.get('0'));
            return true;
        } else if (tmp == '_') {
            keyPressWithShift(map.get('-'));
            return true;
        } else if (tmp == '+') {
            keyPressWithShift(map.get('='));
            return true;
        } else if (tmp == '{') {
            keyPressWithShift(map.get('['));
            return true;
        } else if (tmp == '}') {
            keyPressWithShift(map.get(']'));
            return true;
        } else if (tmp == '<') {
            keyPressWithShift(map.get(','));
            return true;
        } else if (tmp == '>') {
            keyPressWithShift(map.get('.'));
            return true;
        } else if (tmp == '|') {
            keyPressWithShift(map.get('\\'));
            return true;
        }
        return false;
    }
}
