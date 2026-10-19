package game.language;

import game.enums.LanguageEnum;
import game.utils.IFactory;

public class LanguageFactory implements IFactory<ILanguage, LanguageEnum> {

    @Override
    public ILanguage create(LanguageEnum key) {
        return switch (key) {
            case ENGLISH -> new English();
            case PORTUGUESE -> new Portuguese();
            case SPANISH -> new Spanish();
        };
    }
}
