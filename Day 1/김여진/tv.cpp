#include <iostream>

using namespace std;

class TV {
    int channel = 0;
    int channelMin = 0;
    int channelMax = 999;
    int volume = 10;
    int volumeMin = 0;
    int volumeMax = 100;
    bool power = false;
    string inputMode[6] = {"SkyLife", "HDMI1", "HDMI2", "USB", "USB-C", "Screen Mirroring"};
    string curInputMode = inputMode[0];

    void powerToggle(void)
    {
        power = !power;
        if (power)
            cout << "Power On\n" << "Channel : " << channel << "\nVolume : " << volume << '\n';
    }

    void increaseChannel(void)
    {  
        if (power)
        {
            if (channel >= channelMin && channel < channelMax)
                channel++;
            else
                channel = channelMin;
            cout << "Channel : " << channel << '\n';
        }
        
    }

    void decreaseChannel(void) 
    {
        if(power)
        {
            if (channel > channelMin && channel <= channelMax)
                channel--;
            else 
                channel = channelMax;
            cout << "Channel : " << channel << '\n';
        }
    }

    void increaseVolume(void) 
    {
        if (power && volume < volumeMax) 
        {
            volume++;
            cout << "Volume : " << volume << '\n';
        }
    }

    void decreaseVolume(void)
    {
        if (power && volume > volumeMin)
        {
            volume--;
            cout << "Volume : " << volume << '\n';
        }
    }

    void changeMode(void)
    {
        int input;
        cout << "Change Mode\n";
        for (int i = 0; i < 6; i++)
        {
            cout << i + 1 << ". " << inputMode[i]  << " ";
        }

        cin >> input;
        input--;
        
        if (power && input >= 0 && input <= 5)
        {
            curInputMode = inputMode[input];
            cout << "Mode changed to " << inputMode[input] << '\n';
        }
        else
            cout << "FATAL: Wrong Input\n";
    }

};