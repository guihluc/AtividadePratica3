package game.inputs;

import game.enums.InputsEnum;
import game.language.ILanguage;
import game.utils.IFactory;

public class InputsFactory implements IFactory<IInputs, InputsEnum> {

    private final ILanguage language;

    public InputsFactory(ILanguage language) {
        this.language = language;
    }

    @Override
    public IInputs create(InputsEnum mode) {
        return switch (mode) {
            case KEYBOARD -> new KeyboardInput();
            case BUTTONS -> new ButtonInputs(language);
            case JOYSTICK -> new VirtualJoystickInput(language);
        };
    }
}