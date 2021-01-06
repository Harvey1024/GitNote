public class Content {
  private State state;

  public Content() {
    state = null;
  }

  public void setState(State state) {
    this.state = state;
  }

  public State getState() {
    return state;
  }
}