/**
 * 桥接模式 Bridge: 将抽象部分和实现部分分离，使他们都可以独立变化。 
 * 适用性：<br>
 * 不希望在抽象和实现部分之间有一个固定的绑定关系 
 * 类的抽象和实现都可以通过生成自雷的方法加以扩充 
 * 对抽象的实现部分的修改应不会对客户产生影响
 * 对客户完全隐藏抽象的实现 
 * 有许多类要生成 在多个对象件共享实现，同时对客户隐藏这种实现机制 实现要点：
 * 分别定义抽象的接口和实现的接口，抽象接口中聚合一个实现接口的引用，该引用就是连接接口和实现的桥梁。
 */
public class BridgeMain {
    public static void main(String[] args) {
        Implementor pImp = new ConcreteImplementorA();
        Abstraction pa = new RefineAbstraction(pImp);
        pa.operation();
        // 增加Implementor子类，不需要修改Abstraction类
        // Abstraction和抽象类绑定，抽象类起到桥接的作用
        // 客户 Abstraction不需要关心抽象类的实现，只需要知道接口和功能。
        Abstraction pb = new RefineAbstraction(new ConcreteImplementorB());
        pb.operation();
    }
}
