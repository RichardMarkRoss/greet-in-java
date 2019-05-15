package net.greet.enums;

public enum Languages {
    english("Hello, "),
    afrikaans("Goeie dag, "),
    xhosa("Molo, "),
    american("sup bro, ");

    String action;

    Languages(String action)
    {
        this.action = action;
    }

    public String getAction()
    {
        return this.action;
    }

}

