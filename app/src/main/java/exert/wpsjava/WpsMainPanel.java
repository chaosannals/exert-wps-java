package exert.wpsjava;

import java.awt.*;
import javax.swing.*;
import org.slf4j.*;


public class WpsMainPanel extends JPanel {
    private static Logger logger = LoggerFactory.getLogger(WpsMainPanel.class);
    private WpsToolbar wpsToolbar;
    private WpsCanvas wpsCanvas;

    public WpsMainPanel() {
        logger.info("初始化 WPF 主面板");
        setLayout(new BorderLayout());
        wpsToolbar = new WpsToolbar();
        wpsCanvas = new WpsCanvas();
        add(wpsCanvas, BorderLayout.CENTER);
        add(wpsToolbar, BorderLayout.NORTH);
        wpsToolbar.addButton("初始化", (e) -> wpsCanvas.init());
        wpsToolbar.addButton("添加表单", (e) -> wpsCanvas.addWorkbook());
    }
}
