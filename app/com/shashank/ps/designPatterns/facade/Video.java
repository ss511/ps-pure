package com.shashank.ps.designPatterns.facade;

public class Video {
    public void ready() {
        System.out.println("Video System is ready.");
    }

    public void startVideo(String videoFile) {
        System.out.println("Video System is playing file: " + videoFile );
    }
}
