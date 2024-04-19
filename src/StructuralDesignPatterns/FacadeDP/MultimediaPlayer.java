package StructuralDesignPatterns.FacadeDP;

public class MultimediaPlayer {
    private AudioPlayer audioPlayer;
    private VideoPlayer videoPlayer;

    MultimediaPlayer(){
        audioPlayer = new AudioPlayer();
        videoPlayer = new VideoPlayer();
    }

    public void playAudio(){
        audioPlayer.playAudio();
    }
    public void pauseAudio(){
        audioPlayer.pauseAudio();
    }
    public void stopAudio(){
        audioPlayer.stopAudio();
    }
    public void playVideo(){
        videoPlayer.playVideo();
    }
    public void pauseVideo(){
        videoPlayer.pauseVideo();
    }
    public void stopVideo(){
        videoPlayer.stopVideo();
    }
}
