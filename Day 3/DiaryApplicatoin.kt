class DiaryApplicatoin {
    val diaryList = mutableListOf<Diary>()

    fun write(user: String, content: String, date: String) {
        diaryList.add(Diary(user, content, date))
    }

    fun search(keyword: String): List<Diary> {
        return diaryList.filter { it.search(keyword) }
    }

    fun delete(user: String, date: String) {
        diaryList.removeIf { it.user == user && it.date == date }
    }

    fun setPassword(user: String, date: String, password: String) {
        diaryList.find { it.user == user && it.date == date }?.setPassword(password)
    }

    fun shareCode(user: String, date: String): String {
        return diaryList.find { it.user == user && it.date == date }?.code ?: "일치하는 일기가 없습니다."
    }

    fun readByCode(code: String, password: String?): String {
        val diary = diaryList.find { it.code == code } ?: return "일치하는 일기가 없습니다."
        return if (diary.password == password) diary.content else "비밀번호가 일치하지 않습니다."
    }
}