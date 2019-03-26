package Item36.kotlin

class Text {
    enum class Style {
        BOLD, ITALIC, UNDERLINE, STRIKETHROUGH
    }

    //Any Set could be passed in, but EnumSet is clearly best
    fun applyStyles(styles: Set<Style>) {}
}

/// Usage
//    text.applyStyles(EnumSet.of(Style.BOLD, Style.ITALIC));