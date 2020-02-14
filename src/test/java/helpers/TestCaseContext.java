package helpers;

import domain.ClickUpFolder;
import domain.ClickUpSpace;

public class TestCaseContext {
    private static final ThreadLocal<TestCaseContext> THREAD_LOCAL = new ThreadLocal<>();
    private ClickUpFolder clickUpFolder = new ClickUpFolder();
    private ClickUpSpace clickUpSpace = new ClickUpSpace();

    public static void init() {
    }

    public void setClickupFolder(ClickUpFolder clickUpFolder) {
        this.clickUpFolder = clickUpFolder;
    }
    public void setClickupSpace(ClickUpSpace clickupSpace) {
        this.clickUpSpace = clickupSpace;
    }
    public static TestCaseContext get() {
        return THREAD_LOCAL.get();
    }
}
