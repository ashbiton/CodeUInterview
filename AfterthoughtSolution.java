import java.util.ArrayList;
import java.util.List;

/** solution written after the interview * */
public class AfterthoughtSolution {
    /**starting point function*/
  public List<Button> sequenceOfBtnPresses(String searchStr, Character[][] remote) {
    Point currentPosition = new Point(0, 0);
    List<Button> result = new ArrayList<>();
    char[] searchStrCharacters = searchStr.toCharArray();
    for (Character ch : searchStrCharacters) {
      currentPosition = moveToLetter(currentPosition, ch, result, remote);
      result.add(Button.ENTER);
    }
    return result;
  }

  /** calculate the moves required to go from a specific position to a destination letter
        and return the position of the destination letter */
  private Point moveToLetter(
      Point currentPosition, char destination, List result, Character[][] remote) {
    Character currentLetter = remote[currentPosition.getX()][currentPosition.getY()];
    // if the we have the same letter as the current one than we stay at the same position
    if (currentLetter.equals(destination)) {
      return currentPosition;
    }
    Point destPosition = findLetterPosition(remote, destination);
    int rowsDiff = destPosition.getX() - currentPosition.getX();
    int colsDiff = destPosition.getY() - currentPosition.getY();
    appendDirectionToList(result, rowsDiff, Button.UP, Button.DOWN);
    appendDirectionToList(result, colsDiff, Button.LEFT, Button.RIGHT);
    return destPosition;
  }

  private Point findLetterPosition(Character[][] letters, char searchedLetter) {
    // number of letters between the first letter and the letter we search for its position
    int lettersDiff = searchedLetter - letters[0][0];
    int cols = letters[0].length;
    int letterPositionX = lettersDiff / cols;
    int letterPositionY = lettersDiff % cols;
    return new Point(letterPositionX, letterPositionY);
  }

  private void appendDirectionToList(
      List result, int timesToAppend, Button negativeValDirection, Button positiveValDirection) {
    if (timesToAppend == 0) {
      return;
    }
    Button directionToAppend = positiveValDirection;
    if (timesToAppend < 0) {
      directionToAppend = negativeValDirection;
      timesToAppend = Math.abs(timesToAppend);
    }
    for (int i = 0; i < timesToAppend; i++) {
      result.add(directionToAppend);
    }
  }

  private enum Button {
    UP,
    DOWN,
    LEFT,
    RIGHT,
    ENTER
  }

  private class Point {
    private int x;
    private int y;

    public Point(int x, int y) {
      this.x = x;
      this.y = y;
    }

    public int getX() {
      return x;
    }

    public int getY() {
      return y;
    }
  }
}
