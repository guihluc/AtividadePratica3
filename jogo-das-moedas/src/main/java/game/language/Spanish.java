package game.language;

import game.ui.IRenderer;

public class Spanish implements ILanguage {

    @Override
    public void showStartMessage(IRenderer renderer, String deviceName) {
        renderer.showMessage("=== Recoge las monedas ($) - control: " + deviceName + " ===");
    }

    @Override
    public void showUnknownCommand(IRenderer renderer) {
        renderer.showMessage("Comando desconocido.");
    }

    @Override
    public void showWall(IRenderer renderer) {
        renderer.showMessage("¡Pared! No puedes ir por ahí.");
    }

    @Override
    public void showCoinCollected(IRenderer renderer, int score) {
        renderer.showMessage("¡Moneda recogida! Puntuación: " + score);
    }

    @Override
    public void showAllCoinsCollected(IRenderer renderer) {
        renderer.showMessage("¡Recogiste todas las monedas!");
    }

    @Override
    public void showFinalScore(IRenderer renderer, int score) {
        renderer.showMessage("Puntuación final: " + score);
    }

    @Override
    public void showGameOver(IRenderer renderer, int score) {
        renderer.showMessage("FIN DEL JUEGO - Puntuación: " + score);
    }

    @Override
    public String getScoreText(int score) {
        return "Puntuación: " + score;
    }

    @Override
    public String getCommandPrompt() {
        return "Comando (w/a/s/d, q para salir): ";
    }

    @Override
    public String getGameTitle() {
        return "Juego de las Monedas";
    }

    @Override
    public String getControlsTitle() {
        return "Controles";
    }

    @Override
    public String getJoystickTitle() {
        return "Joystick Virtual";
    }

    @Override
    public String getUpLabel() {
        return "Arriba";
    }

    @Override
    public String getDownLabel() {
        return "Abajo";
    }

    @Override
    public String getLeftLabel() {
        return "Izquierda";
    }

    @Override
    public String getRightLabel() {
        return "Derecha";
    }

    @Override
    public String getExitLabel() {
        return "Salir";
    }
}
