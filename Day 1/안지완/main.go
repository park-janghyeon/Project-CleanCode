package main

import (
	"errors"
)

const (
	TV_POWERON  = true
	TV_POWEROFF = false
)

const (
	HDMI1 = iota + 1
	HDMI2
	HDMI3
	PC
	USB
)

type Tv struct {
	isPowered      bool
	currentVolume  int
	currentMode    int
	currentChannel int
}

func (t *Tv) powerUp() {
	t.isPowered = TV_POWERON
}

func (t *Tv) powerDown() {
	t.isPowered = TV_POWEROFF
}

func (t *Tv) volumeUp() (int, error) {
	if !t.isPowered {
		return t.currentVolume, errors.New("TV is not powered up")
	}

	if t.currentVolume >= 100 {
		return 100, errors.New("maximum volume exceeded")
	}
	t.currentVolume += 1
	return t.currentVolume, nil
}

func (t *Tv) volumeDown() (int, error) {
	if !t.isPowered {
		return t.currentVolume, errors.New("TV is not powered up")
	}

	if t.currentVolume <= 0 {
		return 0, errors.New("minimum volume exceeded")
	}
	t.currentVolume -= 1
	return t.currentVolume, nil
}

func (t *Tv) channelUp() (int, error) {
	if !t.isPowered {
		return t.currentChannel, errors.New("TV is not powered up")
	}
	t.currentChannel += 1

	if t.currentChannel > 30 {
		t.currentChannel = 0
	}

	return t.currentChannel, nil
}

func (t *Tv) channelDown() (int, error) {
	if !t.isPowered {
		return t.currentChannel, errors.New("TV is not powered up")
	}

	t.currentChannel -= 1

	if t.currentChannel < 0 {
		t.currentChannel = 30
	}

	return t.currentChannel, nil
}

func (t *Tv) changeMode(mode int) (int, error) {
	if !t.isPowered {
		return t.currentMode, errors.New("TV is not powered up")
	}

	if t.currentMode == USB {
		return t.currentMode, errors.New("TV is on USB mode. Unplug USB to change modes.")
	}

	t.currentMode = mode
	return mode, nil
}
