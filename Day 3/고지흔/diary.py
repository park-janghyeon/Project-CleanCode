import random

class Diary_app:
    def __init__(self):
        self.diary = {}
        self.dir_set = set()
    def add_diary(self, diary):
        if diary.get_password() in self.dir_set:
            self.diary[diary.get_password()] = diary
            self.dir_set.add(diary.get_password())
        else:
            return False
    def get_diary(self, password):
        diary = self.diary.get(password, False)
        if diary:
            return diary
        else:
            return False
    def random_print(self):
        random_dir = random.choice(list(self.diary.values()))
        print(random_dir)

class Diary:
    def __init__(self, date, content, password):
        self.date = date
        self.content = content
        self.password = password
    def get_date(self):
        return self.date
    def get_content(self):
        return self.content
    def get_password(self):
        return self.password
    def set_password(self, password):
        self.password = password
    def __str__(self):
        return f'{self.date} {self.content}'
