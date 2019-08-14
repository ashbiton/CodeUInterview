import java.util.ArrayList;
import java.util.List;

/***
 solution given in the interview itself

 Point is a class that represents an x,y position

 appendToList is a function that gets 3 params:
    1. a string
    2. a number of times to append given string
    3. the list to append the string to

 the time complexity is O(n) where n is the length of the movie string
 ***/
public class InterviewSolution {

    public List<String> sequenceOfBtnPresses(String movie, Character[][] remote) {
        Point current = new Point(0, 0);
        List<String> result = new ArrayList<>();
        List<Character> movieCharacters = movie.getChars();
        for (Character ch : movieCharacters) {
            current = moveToLetter(current, ch, result, remote);
            result.push("enter");
        }
        return result;

    }

    private Point moveToLetter(Point current, Character dest, List<String> result,
                               Character[][] remote) {
        Character currentCh = remote[current.x][current.y];
        int lengthDiff = calcLengthDiff(current, dest, remote);
        if (lengthDiff == 0) {
            return current;
        }
        int rowLength = 5;
        int rows = lengthDiff / rowLength;
        int cols = lengthDiff % rowLength;
        int tempPositionX = current.x;
        if (currentCh < dest) {
            appendToList("down", rows, result);
            tempPositionX += rows;

        } else {
            appendToList("up", rows, result);
            tempPositionX -= rows;
        }

        int tempPositionY = current.y;
        Character tempPositionLetter = remote[tempPositionX][current.y];
        if (tempPositionLetter < dest) {
            appendToList("right", cols, result);
            tempPositionY += cols;

        } else {
            appendToList("left", cols, result);
            tempPositionX -= cols;
        }

        return new Point(tempPositionX, tempPositionY);

    }

    int calcLengthDiff(Point current, Character q, Character[][] remote) {
        Character currentCh = remote[current.x][current.y];
        int lengthDiff = current.x;
        if (currentCh < dest) {
            lengthDiff += (dest - currentCh);
        } else {
            lengthDiff += (currentCh - dest);
        }
        return lengthDiff;

    }

}
