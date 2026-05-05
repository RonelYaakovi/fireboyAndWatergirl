package org.example;

public class Level1 extends BaseLevel {

    public Level1(Window window) {
        // קורא לבנאי של מחלקת האב (BaseLevel) ומעביר את החלון ואת הנתיב לתמונת הרקע של השלב
        // * שים לב: תצטרך לשים פה את הנתיב לתמונה של מפת שלב 1 שלך! *
        super(window, "C:\\Users\\RONEL\\IdeaProjects\\fireboyAndWatergirl\\src\\images\\level1_map.png");
    }

    @Override
    protected void buildMap() {
        System.out.println("Building Level 1 Map...");
    }

    @Override
    protected void updateLevel() {
    }
}