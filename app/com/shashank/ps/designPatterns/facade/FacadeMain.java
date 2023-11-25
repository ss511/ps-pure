package com.shashank.ps.designPatterns.facade;

public class FacadeMain {
    public static void main(String[] args) {
        MediaPlayerFacade mediaPlayerFacade = new MediaPlayerFacade();
        mediaPlayerFacade.runMovie("the_dark_knight.mp3", "the_dark_knight_1080.mp4", "the_dark_knight.srt");
    }
}
