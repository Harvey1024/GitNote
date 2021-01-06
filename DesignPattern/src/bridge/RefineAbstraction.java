/**
 * 继承Abstraction抽象类，重写构造函数
 */
public class RefineAbstraction extends Abstraction {

  public RefineAbstraction(Implementor imp) {
    pImp = imp;
  }

  public void operation() {
    pImp.operationImp();
  }
}
