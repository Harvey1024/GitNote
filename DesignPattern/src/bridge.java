public class Main{
  public static void main(String[] args)
  {
    Implementor pImp = new ConcreteImplementorA();
    Abstraction pa = new RefineAbstraction(pImp);
    pa.operation();
    Abstraction pb = new RefineAbstraction(new ConcreteImplementorB());
    pb.operation();
  }
}

public class Abstraction{
	public Implementor pImp;
	public Abstraction(Implementor imp){
	    this.pImp = imp;
	}
	public void operation(){}
}

public class RefineAbstraction extends Abstraction{
  public RefineAbstraction(Implementor imp){
  	this.pImp = imp;
  }
  public void operation(){
      this.pImp.operationImp();
  }
}

public abstract Implementor{
    public void operationImp();
}

public class ConcreteImplementorA extends Implementor{
    public void operationImp(){
        System.out.println("A");
    }
}

public class ConcreteImplementorB extends Implementor{
    public void operationImp(){
        System.out.println("B");
    }
}