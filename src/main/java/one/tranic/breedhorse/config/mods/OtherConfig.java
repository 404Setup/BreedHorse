package one.tranic.breedhorse.config.mods;

public class OtherConfig {
    private boolean mixedProperties = false;

    public OtherConfig() {
        this(false);
    }

    public OtherConfig(boolean mixedProperties) {
        this.mixedProperties = mixedProperties;
    }

    public boolean isMixedProperties() {
        return mixedProperties;
    }

    public void setMixedProperties(boolean mixedProperties) {
        this.mixedProperties = mixedProperties;
    }
}
