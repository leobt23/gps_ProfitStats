package logic;

import logic.data.Data;
import java.beans.PropertyChangeSupport;

public class Model {
    private Data data;
    private PropertyChangeSupport propertyChangeSupport;

    public Model() {
        data = new Data();
        propertyChangeSupport = new PropertyChangeSupport(data);
    }
}
