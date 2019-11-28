package com.epam.console_menu;

public enum ButtonMessage {

    FIRST("Button 1 pressed"),
    SECOND("Button 2 pressed"),
    THIRD("Button 3 pressed"),
    FOURTH("Button 4 pressed"),
    FIFTH("Button 5 pressed");

    private String message;

    private ButtonMessage(String msg) {
        message = msg;
    }

    public String getMessage() {
        return message;
    }
}
