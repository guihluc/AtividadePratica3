package game;

import java.io.IOException;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.List;

import game.enums.InputsEnum;
import game.enums.LanguageEnum;
import game.enums.RendererEnum;
import game.inputs.IInputs;
import game.inputs.InputsFactory;
import game.language.ILanguage;
import game.language.LanguageFactory;
import game.ui.IRenderer;
import game.ui.RendererFactory;
import game.utils.LevelLoader;
import game.world.Grid;
import game.world.Progress;
import game.world.gobjects.Coin;
import game.world.gobjects.Player;

/**
 * Este e o unico lugar do sistema que decide QUAIS pecas concretas serao usadas.
 *
 * Compare com a versao 1: la, a escolha do dispositivo estava espalhada por
 * dentro da classe de regras. Aqui ela cabe em duas linhas, e a classe Level,
 * o Player, o Grid e as Coins nunca mudam - Level so enxerga IInputs e
 * IRenderer.
 *
 * Entrada e saida sao escolhidas independentemente por enums e factories
 * proprios, sem exigir mudancas em Level, Player, Coin ou Grid.
 */
public class MainGame {

    public static void main(String[] args) throws IOException {
        LaunchOptions options = loadInput(args);

        List<Grid> grids = new LevelLoader().loadAll(Path.of("levels.txt"));

        if (options.levelNumber() < 1 || options.levelNumber() > grids.size())
            throw new IllegalArgumentException(
                "Level must be between 1 and " + grids.size() + ".");

        ILanguage language = new LanguageFactory().create(options.languageMode());
        IInputs input = new InputsFactory(language).create(options.inputMode());
        IRenderer renderer = new RendererFactory(language).create(options.rendererMode());

        Progress progress = new Progress();

        for (int index = options.levelNumber() - 1; index < grids.size(); index++) {
            Grid grid = grids.get(index);
            Player player = new Player(grid.getPlayerX(), grid.getPlayerY());

            List<Coin> coins = new ArrayList<>();
            for (int[] position : grid.getCoinPositions())
                coins.add(new Coin(position[0], position[1], 10));

            Level level = new Level(grid, player, progress, coins, input, renderer, language);
            if (!level.run()) {
                language.showFinalScore(renderer, progress.getScore());
                return;
            }
        }
        language.showGameOver(renderer, progress.getScore());
    }

    private static LaunchOptions loadInput(String[] args) {
        InputsEnum inputMode = null;
        RendererEnum rendererMode = null;
        LanguageEnum languageMode = null;
        int levelNumber = 1;

        for (int index = 0; index < args.length; index++) {
            switch (args[index]) {
                case "-i" -> {
                    if (++index >= args.length)
                        throw new IllegalArgumentException("Missing value for -i.");
                    inputMode = InputsEnum.from(args[index]);
                }
                case "-r" -> {
                    if (++index >= args.length)
                        throw new IllegalArgumentException("Missing value for -r.");
                    rendererMode = RendererEnum.from(args[index]);
                }
                case "-l" -> {
                    if (++index >= args.length)
                        throw new IllegalArgumentException("Missing value for -l.");
                    levelNumber = Integer.parseInt(args[index]);
                }
                case "-lang" -> {
                    if (++index >= args.length)
                        throw new IllegalArgumentException("Missing value for -lang.");
                    languageMode = LanguageEnum.from(args[index]);
                }
                default -> throw new IllegalArgumentException(
                    "Unknown option: " + args[index] + ". Use -i, -r, -l, or -lang.");
            }
        }

        return new LaunchOptions(
            inputMode == null ? InputsEnum.from() : inputMode,
            rendererMode == null ? RendererEnum.from() : rendererMode,
            languageMode == null ? LanguageEnum.from() : languageMode,
            levelNumber
        );
    }

    private record LaunchOptions(
        InputsEnum inputMode,
        RendererEnum rendererMode,
        LanguageEnum languageMode,
        int levelNumber
    ) {}
}
