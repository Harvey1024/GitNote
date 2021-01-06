
public class Main {
    public static void main(String[] args) {
        Content content = new Content();

        State startState = new StartState(content);
        State stopState = new StopState(content);

        // 将自己赋给state，从而实现了content的状态发送变化，修改状态，则改变行为。
        startState.doAction(content);
        System.out.println(content.getState().toString());

        stopState.doAction(content);
        System.out.println(content.getState().toString());
    }
}