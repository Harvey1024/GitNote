/**
 * 抽象类，定义方法及构造函数
 */
public class Abstraction {
  public static Implementor pImp;

  public Abstraction(Implementor imp) {
    pImp = imp;
  }

  public Abstraction() {
  }

  public void operation() {
  }
}
