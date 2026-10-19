package game.language;

import game.ui.IRenderer;

public class English implements ILanguage {

    @Override
    public void showStartMessage(IRenderer renderer, String deviceName) {
        renderer.showMessage("=== Collect the coins ($) - control: " + deviceName + " ===");
    }

    @Override
    public void showUnknownCommand(IRenderer renderer) {
        renderer.showMessage("Unknown command.");
    }

    @Override
    public void showWall(IRenderer renderer) {
        renderer.showMessage("Wall! You cannot go there.");
    }

    @Override
    public void showCoinCollected(IRenderer renderer, int score) {
        renderer.showMessage("Coin collected! Score: " + score);
    }

    @Override
    public void showAllCoinsCollected(IRenderer renderer) {
        renderer.showMessage("You collected all coins!");
    }

    @Override
    public void showFinalScore(IRenderer renderer, int score) {
        renderer.showMessage("Final score: " + score);
    }

    @Override
    public void showGameOver(IRenderer renderer, int score) {
        renderer.showMessage("GAME OVER - Score: " + score);
    }

    @Override
    public String getScoreText(int score) {
        return "Score: " + score;
    }

    @Override
    public String getCommandPrompt() {
        return "Command (w/a/s/d, q to quit): ";
    }

    @Override
    public String getGameTitle() {
        return "Coin Game";
    }

    @Override
    public String getControlsTitle() {
        return "Controls";
    }

    @Override
    public String getJoystickTitle() {
        return "Virtual Joystick";
    }

    @Override
    public String getUpLabel() {
        return "Up";
    }

    @Override
    public String getDownLabel() {
        return "Down";
    }

    @Override
    public String getLeftLabel() {
        return "Left";
    }

    @Override
    public String getRightLabel() {
        return "Right";
    }

    @Override
    public String getExitLabel() {
        return "Quit";
    }
}
