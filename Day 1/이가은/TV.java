package org.example;

class TV {
  int channel;
  int volume;
  boolean power;
  int mode;

  String[] modeList = {"HDMI1","HDMI2","HDMI3","HDMI4"};

  TV() {
    channel = 0;
    volume = 10;
    power = false;
    mode = 0;
  }

  void channelUp() {
    if (!power)
      return;

    if (channel == 999)
      channel = 0;
    else
      channel++;
  }

  void channelDown() {
    if (!power)
      return;

    if (channel == 0)
      channel = 999;
    else
      channel--;
  }

  void volumeUp() {
    if (!power)
      return;

    if (volume < 100)
      volume++;
  }

  void volumeDown() {
    if (!power)
      return;

    if (volume > 0)
      volume--;
  }

  void setPower() {
    power = !power;
  }

  void setMode() {
    if (!power)
      return;

    if (mode < modeList.length - 1)
      mode++;
    else
      mode = 0;
  }
}