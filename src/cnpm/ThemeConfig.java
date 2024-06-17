package cnpm;

import javax.swing.*;

import com.formdev.flatlaf.FlatLaf;
import com.formdev.flatlaf.FlatLightLaf;

import java.awt.*;

public class ThemeConfig {

    // Phương thức để cấu hình theme
    public static void applyTheme() {
    	try {
			UIManager.setLookAndFeel(new FlatLightLaf());
		} catch (UnsupportedLookAndFeelException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    	
    	
    	
    	
        // Button colors
        UIManager.put("Button.background", Color.decode("#006699"));
        UIManager.put("Button.focusedBackground", Color.decode("#006699"));
        UIManager.put("Button.foreground", Color.decode("#ffffff"));
        UIManager.put("Button.arc", 10);

        // Component arc
        UIManager.put("Component.arc", 10);
        UIManager.put("TextComponent.arc", 10);

        // Table colors
        UIManager.put("Table.background", Color.decode("#ffffff"));
        UIManager.put("Table.showVerticalLines", true);
        UIManager.put("Table.showHorizontalLines", true);
    	
    	
    	
    	
    }
}

