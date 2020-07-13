# Observer pattern

class Subject:
    def __init__(self):
        self.observerList = []

    def attach(self, observer):
        self.observerList.append(observer)

    def detach(self, observer):
        for obj in self.observerList:
            if(obj == observer):
                self.observerList.remove(observer)

    def getState(self):
        pass

    def setState(self):
        pass

    def notify(self):
        for observer in self.observerList:
            observer.update(self)


class ConcreteSubject(Subject):
    def __init__(self):
        super().__init__()
        self._state = None

    def getState(self):
        return self._state

    def setState(self, state):
        self._state = state
        self.notify()


class Observer:
    def update(self, subject: Subject):
        pass


class ConcreteObserver(Observer):
    def __init__(self):
        self.observerState = None
        self.name: str = ""

    def update(self, subject: Subject):
        self.observerState = subject.getState()
        print("%s: update: state: %s" % (self.name, self.observerState))


if __name__ == "__main__":
    subject1 = ConcreteSubject()
    observer1 = ConcreteObserver()
    subject1.attach(observer1)
    observer1.name = "observer1"
    subject1.setState(False)

    print("add new observer")
    observer2 = ConcreteObserver()
    subject1.attach(observer2)
    observer2.name = "observer2"
    subject1.setState(True)

    print("del observer2")
    subject1.detach(observer2)
    subject1.setState(3)
