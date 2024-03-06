class TV {
  bool isTvOn = false;
  int currentChannel = 0;
  int currentVolume = 0;
  List<String> inputModes = ['HDMI 1', 'HDMI 2', 'Computer'];
  int currentInputModeIndex = 0;

  void tvOff() {
    isTvOn = false;
  }

  void tvOn() {
    isTvOn = true;
  }

  void changeChannel(bool increase) {
    if (isTvOn) {
      if (increase) {
        currentChannel = (currentChannel + 1) % 1000;
        if (currentChannel == 0) {
          currentChannel = 0;
        }
      } else {
        currentChannel = (currentChannel - 1) % 1000;
        if (currentChannel == 999) {
          currentChannel = 999;
        }
      }
    }
  }

  void adjustVolume(bool increase) {
    if (isTvOn) {
      if (increase) {
        currentVolume = (currentVolume + 1) % 31;
        if (currentVolume == 0) {
          currentVolume = 30;
        }
      } else {
         currentVolume = (currentVolume - 1) % 31;
         if (currentVolume == 30) {
          currentVolume = 0;
        }
        }
      }
    }
    void setInputMode(int modeIndex) {
    if (isTvOn && modeIndex >= 0 && modeIndex < inputModes.length) {
      currentInputModeIndex = modeIndex;
    }
  }

  String getCurrentInputMode() {
    return inputModes[currentInputModeIndex];
  }
}