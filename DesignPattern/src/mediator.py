
class Mediator:
    def __init__(self):
        self.colleageA = None
        self.colleageB = None

    def operation(self, msg, colleage):
        pass

    def register(self, colleage):
        pass

    def buildRelation(self, colleageA, colleageB):
        pass


class Colleage:
    def receivemsg(self, msg):
        pass

    def sendmsg(self, msg, colleage):
        pass

    def setMediator(self, mediator: Mediator):
        pass


class ConcreteMediator(Mediator):
    def operation(self, msg, colleage: Colleage):
        if(colleage == self.colleageA):
            print(msg + ":  to colleage A")
            self.colleageA.receivemsg(msg)
        elif(colleage == self.colleageB):
            print(msg + ":  to colleage B")
            self.colleageB.receivemsg(msg)

    def register(self, colleage: Colleage):
        colleage.setMediator(self)

    def buildRelation(self, colleageA, colleageB):
        self.colleageA = colleageA
        self.colleageB = colleageB


class ConcreteColleageA(Colleage):
    def __init__(self):
        self._mediator = None

    def sendmsg(self, msg, colleage):
        self._mediator.operation(msg, colleage)

    def receivemsg(self, msg):
        print("A received :" + msg)

    def setMediator(self, mediator):
        self._mediator = mediator


class ConcreteColleageB(Colleage):
    def __init__(self):
        self._mediator = None

    def sendmsg(self, msg, colleage):
        self._mediator.operation(msg, colleage)

    def receivemsg(self, msg):
        print("B received :" + msg)

    def setMediator(self, mediator):
        self._mediator = mediator


if __name__ == "__main__":
    mediator = ConcreteMediator()
    colleageA = ConcreteColleageA()
    colleageB = ConcreteColleageB()
    mediator.register(colleageA)
    mediator.register(colleageB)
    mediator.buildRelation(colleageA, colleageB)

    colleageA.sendmsg("hello, I am A", colleageB)
    colleageB.sendmsg("hello, I am B", colleageA)
