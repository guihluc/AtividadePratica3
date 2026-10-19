package game.language;

import game.ui.IRenderer;

/**
 * O CONTRATO DO IDIOMA.
 *
 * Quem precisa de uma mensagem nao recebe o texto pronto: chama um metodo
 * deste contrato, e o idioma concreto conhece a frase. Dados variaveis
 * (score, nome do dispositivo) chegam como parametro.
 *
 * Os metodos show* entregam a frase ao renderer. Os metodos get* devolvem
 * textos de interface (rotulos, titulos, prompt) que o proprio renderer ou
 * a entrada desenha, sem passar por showMessage.
 */
public interface ILanguage {

    void showStartMessage(IRenderer renderer, String deviceName);

    void showUnknownCommand(IRenderer renderer);

    void showWall(IRenderer renderer);

    void showCoinCollected(IRenderer renderer, int score);

    void showAllCoinsCollected(IRenderer renderer);

    void showFinalScore(IRenderer renderer, int score);

    void showGameOver(IRenderer renderer, int score);

    String getScoreText(int score);

    String getCommandPrompt();

    String getGameTitle();

    String getControlsTitle();

    String getJoystickTitle();

    String getUpLabel();

    String getDownLabel();

    String getLeftLabel();

    String getRightLabel();

    String getExitLabel();
}
