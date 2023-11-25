package com.shashank.ps.designPatterns.facade;

public class Audio {

    public void ready() {
        System.out.println("Audio System is ready.");
    }

    public void startAudio(String audioFile) {
        System.out.println("Audio System is playing file: " + audioFile );
    }
}
