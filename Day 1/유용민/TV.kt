const val TV_CHANNEL_MAX = 999
const val TV_VOLUME_MAX = 10

class TV {
    private enum class TV_INPUT_MODE {
        HDMI_1,
        HDMI_2,
        MIRACAST,
        USB
    }

    private enum class TV_STATE {
        POWER_ON,
        POWER_OFF,
        ERROR
    }

    private var tvChannel = 0
    private var tvMode = TV_INPUT_MODE.HDMI_1
    private var tvState = TV_STATE.POWER_OFF
    private var tvVolume = 0

    fun changeMode() {
        if(tvMode != TV_INPUT_MODE.USB){
            tvMode++
        }else{
            tvMode = TV_INPUT_MODE.HDMI_1
        }
    }

    fun channelChange(val target) {
        if(0 <= target && target <= TV_CHANNEL_MAX) {
            tvChannel = target
        }
    }

    fun channelDown() {
        if(tvChannel > 0) {
            tvChannel--
        } else {
            tvChannel = TV_CHANNEL_MAX
        }
    }

    fun channelUp() {
        if(tvChannel < TV_CHANNEL_MAX) {
            tvChannel++
        } else {
            tvChannel = 0
        }
    }

    fun powerOff() {
        if(tvState == TV_STATE.POWER_ON) {
            tvState = TV_STATE.POWER_OFF
        }
    }

    fun powerOn() {
        if(tvState == TV_STATE.POWER_OFF) {
            tvState = TV_STATE.POWER_ON
        }
    }

    fun volumeDown() {
        if(tvVolume > 0) {
            tvVolume--
        }
    }

    fun volumeUp() {
        if(tvVolume < TV_VOLUME_MAX) {
            tvVolume++
        }
    }
}
