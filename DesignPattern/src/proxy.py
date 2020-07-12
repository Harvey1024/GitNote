# Proxy pattern
from abc import ABCMeta, abstractmethod

class Subject(metaclass=ABCMeta):
    @abstractmethod
    def request(self):
        pass


class RealSubject(Subject):
    def request(self):
        print("request")


class Proxy(Subject):
    def __init__(self):
        self._realSubject = RealSubject()

    def preRequest(self):
        print("pre request")

    def afterRequest(self):
        print("after request")

    def request(self):
        self.preRequest()
        self._realSubject.request()
        self.afterRequest()


if __name__ == "__main__":
    proxy = Proxy()
    proxy.request()
