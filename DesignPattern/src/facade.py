from abc import ABCMeta, abstractmethod

class Facade:
  def __init__(self):
    self.m_SystemB = SystemB()
    self.m_SystemA = SystemA()
  def wrapOpration(self):
    self.m_SystemA.operationA()
    self.m_SystemB.operationB()

class SystemA:
  def operationA(self):
    print("A")

class SystemB:
  def operationB(self):
    print("B")

if __name__ == "__main__":
  fa = Facade()
  fa.wrapOpration()