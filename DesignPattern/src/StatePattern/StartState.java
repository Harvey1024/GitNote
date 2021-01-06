public class StartState implements State {
  public StartState(Content content) {
  }

  public void doAction(Content content) {
    System.out.println("in start state");
    content.setState(this);
  }

  public String toString() {
    return "start state";
  }
}