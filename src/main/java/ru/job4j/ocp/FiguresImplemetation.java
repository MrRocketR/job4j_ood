package ru.job4j.ocp;

import java.util.List;

public class FiguresImplemetation {

    private interface Drawable {
        String draw();
    }

    private static class Rectangle implements Drawable {
        @Override
        public String draw() {
            return "...";
        }
    }

    public static void main(String[] args) {
        List<Drawable> rectangles = List.of(new Rectangle());
        rectangles.forEach(Drawable::draw);
    }
}
