class simPID():
    """simulated PID
    """

    def __init__(self, minPos=-100, maxPos=100, incr=0.1, defaultRef=0.0):
        self.refPos = defaultRef
        self.curPos = self.refPos
        self.maxMovement = incr
        self.MIN = minPos
        self.MAX = maxPos

    def setRef(self, val):
        self.refPos = min(max(self.MIN, val), self.MAX)

    def getRef(self):
        return self.refPos

    def getCur(self):
        return self.curPos

    def execute(self):
        if self.curPos < self.refPos:
            self.curPos += min(self.maxMovement, self.refPos - self.curPos)
        else:
            self.curPos -= min(self.maxMovement, self.curPos - self.refPos)

        #print "simPID(): {0}/{1}".format(self.curPos, self.refPos)


class lifter():
    """simulated lifter
    """

    def __init__(self):
        self.rot = simPID(-135, 135, 0.1)
        self.rotGoal = self.rot.getCur()

        self.riser = simPID(0, 83*100, 0.25)
        self.riserGoal = self.riser.getCur()

    def setGoal(self, rise, rot):
        self.riserGoal = rise
        self.rotGoal = rot

    def atGoal(self):
        if self.riser.getCur() != self.riserGoal:
            return False

        cur = self.rot.getCur()
        if cur == self.rotGoal:
            return True

        # Now check for rotator at allowable limit closest to goal
        constraints = self.getConstraints(self.riserGoal)
        if self.rotGoal < constraints[0] and cur == constraints[0]:
            return True

        if self.rotGoal > constraints[1] and cur == constraints[1]:
            return True

        if self.rotGoal > constraints[2] and cur == constraints[2]:
            return True

        if self.rotGoal < constraints[3] and cur == constraints[3]:
            return True

        return False

    def getConstraints(self, dist):
        minAngle = -3
        maxAngle = 15
        minKeepOut = -180
        maxKeepOut = -180

        if dist < 5:
            minAngle = 0
            maxAngle = 0.5

        return (minAngle, maxAngle, minKeepOut, maxKeepOut)

    def execute(self):
        newRise = self.riser.getCur()

        if newRise < self.riserGoal:
            newRise += min(self.riserGoal - newRise, 1.5)
        elif newRise > self.riserGoal:
            newRise -= min(newRise - self.riserGoal, 1.5)

        constraints = self.getConstraints(newRise)
        canMove = (self.rot.getCur() >= constraints[0]) and \
                  (self.rot.getCur() <= constraints[1])
        if canMove:
            self.riser.setRef(newRise)

        newRot = min(max(constraints[0], self.rotGoal), constraints[1])
        self.rot.setRef(newRot)

        self.rot.execute()
        self.riser.execute()

        print "lifter(): {0}/{1} @ {2}/{3}".format(self.riser.getCur(), self.riser.getRef(), self.rot.getCur(), self.rot.getRef())

if __name__ == "__main__":
    print "main()!"

    lift = lifter()

    lift.setGoal(rise=2.7, rot=5)
    while not lift.atGoal():
        lift.execute()

    lift.setGoal(rise=6, rot=5)
    while not lift.atGoal():
        lift.execute()

    lift.setGoal(rise=0, rot=-10)
    while not lift.atGoal():
        lift.execute()
