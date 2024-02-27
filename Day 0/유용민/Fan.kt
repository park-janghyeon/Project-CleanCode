class Fan {
    private enum class FAN_STATUS {
        FAN_ERROR,
        FAN_RUNNING,
        FAN_STOPPED
    }

    private var fanLevel = 0
    private var fanRotateMode = false
    private var fanStatus = FAN_STATUS.FAN_STOPPED

    fun changeRotate(isEnabled: Boolean) {
        if (fanStatus == FAN_STATUS.FAN_ERROR) {
            throw Exception("FAN_ERROR")
        }

        if (fanStatus == FAN_STATUS.FAN_RUNNING) {
            fanRotateMode = isEnabled
        }
    }

    fun levelDown() {
        if (fanStatus == FAN_STATUS.FAN_ERROR) {
            throw Exception("FAN_ERROR")
        }

        if (fanStatus == FAN_STATUS.FAN_RUNNING) {
            if (fanLevel > 1) {
                fanLevel--
            } else {
                fanLevel = 0
                fanRotateMode = false
                fanStatus = FAN_STATUS.FAN_ERROR
                throw Exception("FAN_ERROR")
            }
        }
    }

    fun levelUp() {
        if (fanStatus == FAN_STATUS.FAN_ERROR) {
            throw Exception("FAN_ERROR")
        }

        if (fanStatus == FAN_STATUS.FAN_RUNNING) {
            if (fanLevel < 5) {
                fanLevel++
            } else {
                fanLevel = 0
                fanRotateMode = false
                fanStatus = FAN_STATUS.FAN_ERROR
                throw Exception("FAN_ERROR")
            }
        }
    }

    fun powerOff() {
        if (fanStatus == FAN_STATUS.FAN_ERROR) {
            throw Exception("FAN_ERROR")
        }

        if (fanStatus == FAN_STATUS.FAN_RUNNING) {
            fanLevel = 0
            fanStatus = FAN_STATUS.FAN_STOPPED
        }
    }

    fun powerOn() {
        if (fanStatus == FAN_STATUS.FAN_ERROR) {
            throw Exception("FAN_ERROR")
        }

        if (fanStatus == FAN_STATUS.FAN_STOPPED) {
            fanLevel = 1
            fanStatus = FAN_STATUS.FAN_RUNNING
        }
    }
}