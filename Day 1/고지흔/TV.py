class TV:
    def __init__(self, volume=0, channel=0, is_on=False):
        self.is_on = is_on
        self.volume = volume
        self.channel = channel
        self.mode_list = ["HDMI1", "HDMI2", "TV", "PC"]
        self.mode = self.mode_list[0]
    def volume_up(self):
        if self.volume < 100:
            self.volume += 1
        print("volume_up", self.volume)
    def volume_down(self):
        if self.volume > 0:
            self.volume -= 1
        print("volume_down", self.volume)
    def channel_up(self):
        self.channel += 1
        if self.channel > 999:
            self.channel = 0
        print("channel_up", self.channel)
    def channel_down(self):
        self.channel -= 1
        if self.channel < 0:
            self.channel = 999
        print("channel_down", self.channel)
    def change_mode(self):
        self.mode = self.mode_list[(self.mode_list.index(self.mode) + 1) % len(self.mode_list)]
        print("change_mode", self.mode)
    def on(self):
        self.is_on = not self.is_on
        print("is_on", self.is_on)
    def __str__(self):
        return f"TV is {'is_on' if self.is_on else 'off'}, volume: {self.volume}, channel: {self.channel}, mode: {self.mode}"
    
tv = TV()
print(tv)
tv.volume_up()
tv.volume_up()
tv.volume_up()
tv.volume_up()
tv.volume_up()
tv.volume_down()
tv.volume_down()
tv.volume_down()
tv.volume_down()
tv.volume_down()
tv.channel_up()
tv.channel_up()
tv.channel_up()
tv.channel_up()
tv.channel_up()
tv.channel_down()
tv.channel_down()
tv.channel_down()
tv.channel_down()
tv.channel_down()
tv.change_mode()
tv.change_mode()
tv.change_mode()
tv.change_mode()
tv.change_mode()
tv.change_mode()
tv.on()
tv.on()
tv.on()
tv.on()
tv.on()
tv.on()
print(tv)
