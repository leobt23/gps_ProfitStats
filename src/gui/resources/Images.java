package gui.resources;

import javafx.scene.image.Image;
import gui.left_panel.PanelElements;

import java.io.InputStream;
import java.util.HashMap;
import java.util.Map;

public class Images {
    private static final Map<String, Image> images = new HashMap<>();

    public static Image getImage(String name) {
        return images.get(name);
    }

    private static InputStream getResourceFile(String name){
        return Images.class.getResourceAsStream(name);
    }

    static {
        images.put(PanelElements.USER_PROFILE, new Image(getResourceFile(ImagesPaths.USER_ICON)));
        //TODO: Adicionar o resto
        images.put(PanelElements.BET_REGISTRY, new Image(getResourceFile(ImagesPaths.USER_ICON)));
        images.put(PanelElements.BETS_HISTORY, new Image(getResourceFile(ImagesPaths.USER_ICON)));
        images.put(PanelElements.NOTIFICATIONS, new Image(getResourceFile(ImagesPaths.USER_ICON)));
        images.put(PanelElements.STATISTICS, new Image(getResourceFile(ImagesPaths.USER_ICON)));
    }
}
