# Chain of responsibility
# Chain of responsibility
class RequestType:
    def __init__(self):
        self.COLLECT_TAX = None
        self.DEFEND_CASTLE = None
        SELF.TORTURE_PRISONER = None
    def valueOf(self, name: str):
        return self
    def values(self):
        pass

class Request:
    def __init__(self):
        pass


class RequestHander:
    def __init__(self):
        self.Logger = None
        self.next = None

    def handleRequest(self, req: Request):
        pass

    def printHandling(self, req: Request):
        pass
