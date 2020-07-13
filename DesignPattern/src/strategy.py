# Strategy pattern

class Strategy:
    def algorithm(self):
        pass


class ConcreteStrategyA(Strategy):
    def algorithm(self):
        print("use strategy A")


class ConcreteStrategyB(Strategy):
    def algorithm(self):
        print("use strategy B")


class Context:
    def setStrategy(self, strategy: Strategy):
        self._strategy = strategy

    def algorithm(self):
        self._strategy.algorithm()


if __name__ == "__main__":
    strategyA = ConcreteStrategyA()
    context = Context()
    context.setStrategy(strategyA)
    context.algorithm()

    print("change algorithm")
    strategyB = ConcreteStrategyB()
    context.setStrategy(strategyB)
    context.algorithm()
