package StructuralDesignPatterns.FacadeDP;

public class Client {
    public static void main(String[] args) {
        MultimediaPlayer multimediaPlayer = new MultimediaPlayer();
        multimediaPlayer.playAudio();
        multimediaPlayer.playVideo();

    }
}
/*
Facade Pattern : It gives more simplified interface for complex system or view of the complex environment.

When to use? -  Overall facade pattern is valuable whenever you need to hide complexity, simplify interactions,
  improve maintainability.

-> Here Multimedia player acts as facade to client. we can access or operate Subsystems(Audio Player, Video Player)
   with help of Multimedia Player Facade.


 */