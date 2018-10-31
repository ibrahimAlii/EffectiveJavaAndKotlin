package Item02.kotlin

class Dialog private constructor(
        val title: String,
        val text: String?,
        val onAccept: (() -> Unit)?
) {
    class Builder(val title: String) {
        var text: String? = null
        var onAccept: (() -> Unit)? = null
        fun setText(text: String?): Builder {
            this.text = text
            return this
        }
        fun setOnAccept(onAccept: (() -> Unit)?): Builder {
            this.onAccept = onAccept
            return this
        }
        fun build() = Dialog(title, text, onAccept)
    }
}
// Usage
val dialog1 = Dialog.Builder("Some title")
        .setText("Great dialog")
        .setOnAccept { toast("I was clicked") }
        .build()
val dialog2 = Dialog.Builder("Another dialog")
        .setText("I have no buttons")
        .build()
val dialog3 = Dialog.Builder("Dialog with just a title").build()