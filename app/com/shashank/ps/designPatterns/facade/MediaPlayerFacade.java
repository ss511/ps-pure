package com.shashank.ps.designPatterns.facade;

public class MediaPlayerFacade {
    private Audio audio;
    private Video video;
    private Subtitles subtitles;

    public MediaPlayerFacade() {
        this.audio = new Audio();
        this.video = new Video();
        this.subtitles = new Subtitles();
    }

    public void runMovie(String audioFile, String videoFile, String subtitlesFile) {
        this.video.ready();
        this.video.startVideo(videoFile);

        this.audio.ready();
        this.audio.startAudio(audioFile);

        this.subtitles.ready();
        this.subtitles.startSubtitles(audioFile);

        System.out.println("Movie is now playing");
    }
}
