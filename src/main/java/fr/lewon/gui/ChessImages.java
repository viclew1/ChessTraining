package fr.lewon.gui;

import java.awt.image.BufferedImage;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import javax.imageio.ImageIO;

public enum ChessImages {
	
	INSTANCE;
	
	private Map<String, BufferedImage> loadedAssets = new HashMap<>();
	
	public BufferedImage loadImage(String resourceName) throws IOException {
		if (loadedAssets.containsKey(resourceName)) {
			return loadedAssets.get(resourceName);
		}
		BufferedImage img = ImageIO.read(getClass().getResourceAsStream("/" + resourceName));
		loadedAssets.put(resourceName, img);
		return img;
	}

}
