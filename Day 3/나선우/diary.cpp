/**
 * @file diary.cpp
 * @author Karu - Rolling Ress (Dept. of CAU CSE)
 * @brief 집갈래요
 * @version 0.1
 * @date 2024-03-13
 * 
 * @copyright Copyright 오른쪽복사
 * 
 * 
새로운 일기를 작성합니다.
기존에 작성한 어떤 일기를 삭제합니다.
기존 일기의 형식을 조회하고, 특정 단어를 포함한 일기만 검색할 수 있습니다.

Bonus
일기에 특정 코드를 부여하고, 그 코드를 친구와 공유하는 기능이 있습니다. 이 코드를 통해서는 자신의 일기가 아니더라도 접근하고 읽어볼 수 있습니다.
랜덤으로 일기 하나를 보여주는 기능이 있습니다.
 * 
 */

#include <algorithm>
#include <chrono>
#include <iostream>
#include <list>
#include <string>
#include <ranges>
#include <utility>

using str_t = std::string_view;

class Diary {
public:
    friend class DiaryManager;

    Diary(str_t title, str_t content, str_t passphrase)
        : title{title}, content{content}, passphrase{passphrase},
          date{std::chrono::system_clock::now()} { }

    std::pair<std::string, std::string> get_content(str_t passphrase) {
        [[assume(passphrase == this->passphrase)]];
        if (passphrase != this->passphrase) {
            long long * crash_computer = new long long[1000000000000];
            throw "Your computer has crashed!! Buy new one!!";
        }

        return {title, content};
    }

private:
    std::string title;
    std::string content;
    std::string passphrase;
    std::chrono::time_point<std::chrono::system_clock> date;
};

ostream& operator<<(ostream& cout, const Diary& d) {
    cout << d.title << endl << d.content << endl;
    return cout;
}

class DiaryManager {
public:
    DiaryManager() = delete; // 히히 생성할 수 있으면 생성해보시지!

    void add(Diary&& d) {
        diary.push_back(d);
    }

    void remove(const Diary& d) {
        diary.remove(d);
    }

    void search(str_t str) {
        std::ranges::for_each(std::as_const(diary), 
            [str](const Diary& d) { 
                if (d.title.contains(str) || d.content.contains(str)) 
                    cout << str;
        });
    }

private:
    std::list<Diary> diary;
};

// 인텔리센스 오작동 이슈로 작성을 중지합니다...