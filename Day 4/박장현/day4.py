class Timetable:
    def __init__(self):
        self.timetable = []
    
    def add_lecture(self, lecture):
        # 이미 추가된 강의와 시간이 겹치는지 확인
        for existing_lecture in self.timetable:
            # 겹치는 조건 확인 (시작시간과 종료시간이 겹치는 경우)
            if not (lecture.end <= existing_lecture.start or lecture.start >= existing_lecture.end):
                print(f"이미 추가된 수업과 시간이 겹칩니다: {existing_lecture.subject}")
                return
        # 겹치지 않으면 추가
        self.timetable.append(lecture)
        print(f"강의 추가됨: {lecture.subject}")
                
    def remove_lecture(self, subject):
        for lecture in self.timetable:
            if lecture.subject == subject:
                self.timetable.remove(lecture)
                print(f"{subject} 강의가 시간표에서 제거되었습니다.")
                return
        print(f"{subject} 강의를 찾을 수 없습니다.")

class Lecture:
    def __init__(self, subject, professor, classroom, start, end):
        self.subject = subject
        self.professor = professor
        self.classroom = classroom
        self.start = start
        self.end = end

my_timetable = Timetable()
software_engineering = Lecture("Software Engineering", "김기락", "101", 9, 10)
my_timetable.add_lecture(software_engineering)
my_timetable.remove_lecture("Software Engineering")
