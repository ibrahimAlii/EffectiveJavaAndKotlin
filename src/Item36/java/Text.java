package Item36.java;

import java.util.Set;

public class Text {
    public enum Style {BOLD, ITALIC, UNDERLINE, STRIKETHROUGH}

    //Any Set could be passed in, but EnumSet is clearly best
    public void applyStyles(Set<Style> styles){}
}

/// Usage
      //  text.applyStyles(EnumSet.of(Style.BOLD, Style.ITALIC));
