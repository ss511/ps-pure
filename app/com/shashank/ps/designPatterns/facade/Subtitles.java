package com.shashank.ps.designPatterns.facade;

public class Subtitles {
    public void ready() {
        System.out.println("Subtitles System is ready.");
    }

    public void startSubtitles(String subtitlesFile) {
        System.out.println("Subtitles System is showing subtitles from file: " + subtitlesFile );
    }
}
