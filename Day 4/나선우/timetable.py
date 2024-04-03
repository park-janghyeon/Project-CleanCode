# 솦프 살려주세요..... 나JAVA봐라

from dataclasses import dataclass
import time

# 파이썬 신문법... 다들 많이 써보세요
@dataclass(frozen=True)
class lecture:
    name: str
    professor: str
    room: int
    start: time
    end: time
    
class timetable:
    def __init__(self):
        self.lectures: list[lecture] = []
    
    def add(self, lec: lecture) -> bool:
        for i in self.lectures:
            if lec.start <= i.start and i.start <= lec.end or \
                lec.start <= i.end and i.end <= lec.end:
                    return False
        # 이 else는 if가 아니라 for에 걸리는 else 문입니다
        else: 
            self.lectures.append(lec)
            return True
    
    def remove(self, lec: lecture):
        self.lectures.remove(lec)