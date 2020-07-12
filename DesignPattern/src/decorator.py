from abc import ABCMeta, abstractmethod

class Component(metaclass=ABCMeta):
  @abstractmethod
  def Operation(self):
    pass

class ConcreteComponent(Component):
  def Operation(self):
    print("concretecomponent:operation")    

class Decorator(metaclass=ABCMeta):
  @abstractmethod
  def Operation(self):
    pass

  @abstractmethod
  def AddBehavior(self):
    pass

class ConcreteDecorator(Decorator):
  def __init__(self, com:Component):
    self._com = com

  def AddBehavior(self):
    print("new behavior")
  
  def Operation(self):
    self.AddBehavior()
    self._com.Operation()

if __name__ == "__main__":
  con = ConcreteComponent()
  dec = ConcreteDecorator(con)
  dec.Operation()
  print("con")
  con.Operation()

