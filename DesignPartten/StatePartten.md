# 状态模式
1. 意图：
允许一个对象在其内部状态改变时改变它的行为，对象看起来似乎修改了它的类。
2. 适用性：
    - 对象的行为取决于他的状态，并在运行时根据状态改变行为，
    - 操作中含有**庞大的多分支**的条件语句，且这些分支依赖于该对象的状态。
3. 实现要点：
定义状态接口，具体状态类中实现该状态对应的行为，上下文对象中聚合当前的状态。

例如：

![1594133397904.png](img\1594133397904.png)

```java
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
```

封装了转换规则，增加状态只需要增加newState()类，不需要修改State, Content类  
对象content状态改变后时，改变他的行为(content.getState().toString()), 对象content看起来像是修改了类。

- state状态：  
定义了根据不同状态进行不同处理的接口，该接口是那些处理内容依赖的方法集合。
- 具体的状态：  
实现state接口
- context:
持有当前状态的具体实例的实例，还定义了供外部使用者使用的状态模式的接口。