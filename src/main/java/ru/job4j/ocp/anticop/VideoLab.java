package ru.job4j.ocp.anticop;

import java.io.File;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class VideoLab extends Dictionary {
    @Override
    public List<File> get(String word) {
        return new LinkedList<>();
    }
}
