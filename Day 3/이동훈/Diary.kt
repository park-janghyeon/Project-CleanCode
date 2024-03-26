class Diary {
    val user: String
    val content: String
    val date: String
    var password: String? = null
    val code: String = java.util.UUID.randomUUID().toString()

    constructor(user: String, content: String, date: String) {
        this.user = user
        this.content = content
        this.date = date
    }

    fun setPassword(password: String) {
        this.password = password
    }

    fun search(keyword: String): Boolean {
        return if (content.contains(keyword))
            true
        else
            false
    }
}