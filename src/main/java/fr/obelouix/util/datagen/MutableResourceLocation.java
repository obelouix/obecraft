package fr.obelouix.util.datagen;

import fr.obelouix.obecraft.Obecraft;
import net.minecraft.util.ResourceLocation;

public class MutableResourceLocation {
    private String path;

    public MutableResourceLocation(ResourceLocation resourceLocation) {
        this(resourceLocation.getPath());
    }

    public MutableResourceLocation(String path) {
        this.path = path;
    }

    public MutableResourceLocation prependPath(String s) {
        this.path = s + this.path;
        return this;
    }

    public MutableResourceLocation appendPath(String s) {
        this.path = this.path + s;
        return this;
    }

    public String getPath() {
        return path;
    }

    @Override
    public String toString() {
        return String.format("%s:%s", Obecraft.MODID, path);
    }
}
