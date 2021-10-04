package com.example.harvey.composesample

data class Message(
    val profile: Int,
    val name: String,
    val text: String
)


fun getMessages() = listOf(
    Message(R.drawable.ic_launcher_foreground, "harvey", "Hi"),
    Message(R.drawable.ic_launcher_background, "yevrah", "Hi~"),
    Message(
        R.drawable.ic_launcher_foreground, "harvey", "How are u?\n" +
                "How you? How are you? How are you? How are you? How u?\n" +
                "How are you? How are you?"
    ),
    Message(R.drawable.ic_launcher_background, "yevrah", "I'm fine"),
    Message(R.drawable.ic_launcher_foreground, "harvey", "Hi"),
    Message(R.drawable.ic_launcher_background, "yevrah", "Hi~"),
    Message(
        R.drawable.ic_launcher_foreground,
        "harvey",
        "How are you? How are you? How are you? How are you? How are you? How are you?u?\n" +
                "How How are you? How are you?\n"
    ),
    Message(R.drawable.ic_launcher_background, "yevrah", "I'm fine"),
    Message(R.drawable.ic_launcher_foreground, "harvey", "Hi"),
    Message(R.drawable.ic_launcher_background, "yevrah", "Hi~"),
    Message(
        R.drawable.ic_launcher_foreground,
        "harvey",
        "How are you? How are you? How are you? How are you? How are you? How are you?\nHow are you? How are you?\n "
    ),
    Message(R.drawable.ic_launcher_background, "yevrah", "I'm fine")
)