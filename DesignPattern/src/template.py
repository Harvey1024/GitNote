
class HouseTemp:
    def __init__(self):
        self.hosename = ''

    def buildHouse(self):
        self.buildWindows()
        self.buildWalls()
        self.buildPillars()
        self.buildFoundation()

    def buildWindows(self):
        print('windows')

    def buildWalls(self):
        print('walls')

    def buildPillars(self):
        print('Pillars')

    def buildFoundation(self):
        print('Foundation')


class WoodenHouse(HouseTemp):
    def __init__(self):
        super().__init__()
        self.hosename = 'WoodenHouse'

    def buildWalls(self):
        print(self.hosename + ': walls')

    def buildPillars(self):
        print(self.hosename + ': Pillars')


class GlassHouse(HouseTemp):
    def __init__(self):
        super().__init__()
        self.hosename = 'GlassHouse'

    def buildWalls(self):
        print(self.hosename + ': walls')

    def buildPillars(self):
        print(self.hosename + ': pillars')


if __name__ == "__main__":
    woodenHouse = WoodenHouse()
    woodenHouse.buildHouse()

    glassHouse = GlassHouse()
    glassHouse.buildHouse()
