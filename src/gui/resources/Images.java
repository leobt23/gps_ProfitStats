package gui.resources;

import gui.left_panel.PanelElements;
import javafx.scene.image.Image;

import java.io.InputStream;
import java.util.HashMap;
import java.util.Map;

import static gui.resources.Constants.*;

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
        images.put(PanelElements.BET_REGISTRY, new Image(getResourceFile(ImagesPaths.BET_REGISTRY_ICON)));
        images.put(PanelElements.BETS_HISTORY, new Image(getResourceFile(ImagesPaths.BETS_HISTORY_ICON)));
        images.put(PanelElements.NOTIFICATIONS, new Image(getResourceFile(ImagesPaths.NOTIFICATIONS_ICON)));
        images.put(PanelElements.STATISTICS, new Image(getResourceFile(ImagesPaths.STATISTICS_ICON)));
        images.put(TRASH_BIN_ICON,new Image(getResourceFile(ImagesPaths.TRASH_ICON)));
        images.put(EDIT_ICON,new Image(getResourceFile(ImagesPaths.EDIT_ICON)));
        images.put(MARK_ICON,new Image(getResourceFile(ImagesPaths.MARK_ICON)));
        images.put(CROSS_ICON,new Image(getResourceFile(ImagesPaths.CROSS_ICON)));
        images.put(STATISTICS_BACKGROUND, new Image(getResourceFile(ImagesPaths.STATISTICS_BACKGROUND)));
    }
}
