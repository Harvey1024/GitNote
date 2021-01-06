public class StopState implements State {
  public StopState(Content content) {
  }

  public void doAction(Content content) {
    System.out.println("in stop state");
    content.setState(this);
  }

  public String toString() {
    return "stop state";
  }
}