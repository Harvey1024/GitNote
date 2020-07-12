public interface State{
    public void doAction(Content content);
}

public class StartState implements State{
    public StartState(Content content) {
    }

    public void doAction(Content content) {
        System.out.println("in start state");
        content.setState(this);
    }
    public String toString(){
        return "start state";
    }
}

public class StopState implements State{
    public StopState(Content content) {
    }
    public void doAction(Content content) {
        System.out.println("in stop state");
        content.setState(this);
    }
    public String toString(){
        return "stop state";
    }
}

public class Content{
    private State state;
    public Content(){
        state = null;
    }
    public void setState(State state){
        this.state = state;
    }
    public State getState(){
        return state;
    }
}

public class Main {
    public static void main(String[] args){
        Content content = new Content();

        State startState = new StartState(content);
        State stopState = new StopState(content);

        startState.doAction(content);
        System.out.println(content.getState().toString());

        stopState.doAction(content);
        System.out.println(content.getState().toString());
    }
}