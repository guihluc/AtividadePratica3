package game.language;

import game.ui.IRenderer;

public class Portuguese implements ILanguage {

    @Override
    public void showStartMessage(IRenderer renderer, String deviceName) {
        renderer.showMessage("=== Colete as moedas ($) - controle: " + deviceName + " ===");
    }

    @Override
    public void showUnknownCommand(IRenderer renderer) {
        renderer.showMessage("Comando desconhecido.");
    }

    @Override
    public void showWall(IRenderer renderer) {
        renderer.showMessage("Parede! Você não pode ir por aí.");
    }

    @Override
    public void showCoinCollected(IRenderer renderer, int score) {
        renderer.showMessage("Moeda coletada! Pontuação: " + score);
    }

    @Override
    public void showAllCoinsCollected(IRenderer renderer) {
        renderer.showMessage("Você coletou todas as moedas!");
    }

    @Override
    public void showFinalScore(IRenderer renderer, int score) {
        renderer.showMessage("Pontuação final: " + score);
    }

    @Override
    public void showGameOver(IRenderer renderer, int score) {
        renderer.showMessage("FIM DE JOGO - Pontuação: " + score);
    }

    @Override
    public String getScoreText(int score) {
        return "Pontuação: " + score;
    }

    @Override
    public String getCommandPrompt() {
        return "Comando (w/a/s/d, q para sair): ";
    }

    @Override
    public String getGameTitle() {
        return "Jogo das Moedas";
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
        return "Cima";
    }

    @Override
    public String getDownLabel() {
        return "Baixo";
    }

    @Override
    public String getLeftLabel() {
        return "Esquerda";
    }

    @Override
    public String getRightLabel() {
        return "Direita";
    }

    @Override
    public String getExitLabel() {
        return "Sair";
    }
}
