# command pattern

from abc import ABCMeta, abstractmethod


class Receiver:
    def action(self):
        print("receiver action")


class Command(metaclass=ABCMeta):
    @abstractmethod
    def excute(self):
        pass


class ConcreteCommand(Command):
    def __init__(self, reciver: Receiver):
        self._receiver = reciver

    def excute(self):
        print("concreteCommand excute")
        self._receiver.action()


class Invoker:
    def __init__(self, command: Command):
        self._command = command

    def call(self):
        print("invoker calling")
        self._command.excute()


if __name__ == "__main__":
    reciver = Receiver()
    concreteCommand = ConcreteCommand(reciver)
    invoker = Invoker(concreteCommand)
    invoker.call()
