# Flyweight Patterns


class Flyweight:
    def __init__(self):
        self._intrinsicState = ''

    def GetState(self):
        return self._intrinsicState

    def operation(self):
        pass


class ConcreteFlyweight(Flyweight):
    # instances = []
    def __init__(self, state):
        self._intrinsicState = state
        # self.__class__.instances.append(self)

    def operation(self):
        print("ConcreteFlyweight: %s" % self.GetState())


class FlyweightFactory:
    def __init__(self):
        self.flys = []

    def getFlyweight(self, key: str):
        for obj in self.flys:
            if(obj._intrinsicState == key):
                print("already created by users...")
                return obj
        print("creat new concreteFlyweight: %s" % key)
        fn = ConcreteFlyweight(key)
        self.flys.append(fn)
        return fn


if __name__ == "__main__":
    fc = FlyweightFactory()
    fw1 = fc.getFlyweight("hello")
    fw2 = fc.getFlyweight("world")
    fw3 = fc.getFlyweight("hello")
