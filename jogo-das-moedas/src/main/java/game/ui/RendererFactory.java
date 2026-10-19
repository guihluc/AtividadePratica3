package game.ui;

import game.enums.RendererEnum;
import game.language.ILanguage;
import game.utils.IFactory;

public class RendererFactory implements IFactory<IRenderer, RendererEnum> {

    private final ILanguage language;

    public RendererFactory(ILanguage language) {
        this.language = language;
    }

    @Override
    public IRenderer create(RendererEnum key) {
        return switch (key) {
            case TERMINAL -> new TerminalRenderer(language);
            case GUI -> new GUIRenderer(language);
        };
    }
}