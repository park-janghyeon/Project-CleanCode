// Importing neccessary packages
using System;
using System.Collections.Generic;

/*
   여타 다른 언어와 다르게 C#은 프로퍼티, 함수 이름을
   대문자로 시작(PascalCasing)하는 것이 관례입니다.

   이에 맞추어 코드를 작성합니다.

   **** 인텔리센스 이슈.. 오랜만에 손코딩하는 이 기분
 */

namespace GDSC_Day1
{
    // Input sources
    enum Source
    {
        HDMI1,
        HDMI2,
        RGB,
        DVI,
        Thunderbold,
        USB_C,
    }

    class TV
    {
        // fields
        private uint    channel;
        private uint    volume;
        private bool    power;
        private Source  input;

        public const uint MaxChannel = 100;
        public const uint MinChannel = 0;
        public const uint MaxVolume = 100;
        public const uint MinVolume = 0;

        // implementing GETTER properties
        public uint     Channel => channel;
        public uint     Volume  => volume;
        public bool     Power   => power;
        public Source   Input   => input;

        public void IncreseChannel() {
            if (channel < MaxChannel)
                channel++;
        }

        public void DecreaseChannel() {
            if (channel > MinChannel)
                channel--;
        }

        public void IncreaseVolume() {
            if (volume < MaxVolume)
                volume++;
        }

        public void DecreaseVolume() {
            if (volume > MinVolume)
                volume--;
        }

        // value가 null이 아니면 value 대입, null이면 !Power 대입
        // (ft. null-coalescing operator)
        public bool TogglePower(bool? value = null)
            => Power = value ?? !Power;

        // 입력장치에 신호가 있는지 판별하는 함수....인데
        // 몰라 누가 알아서 하겠지
        public virtual bool IsSourceAvailable(Source source)
            => true;

        // returns: true if succeeded to switch source,
        //          false otherwise.
        public bool SwitchInputSource(Source source)
        {
            if (IsSourceAvailable(source))
            {
                input = source;
                return true;
            }
            return false;
        }
    }
}