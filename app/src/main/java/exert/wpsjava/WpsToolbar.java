package exert.wpsjava;

import java.awt.*;
import java.awt.event.*;
import java.util.*;
import javax.swing.*;
import org.slf4j.*;

public class WpsToolbar extends JPanel {
    private static Logger logger = LoggerFactory.getLogger(WpsToolbar.class);

    private HashMap<String, JButton> buttons;

    public WpsToolbar() {
        buttons = new HashMap<>();
        setLayout(new FlowLayout());
        // newButton("初始化");
        // newButton("添加文档");
    }

    public JButton newButton(String text) {
        JButton button = new JButton(text);
        button.setEnabled(true);
        add(button);
        buttons.put(text, button);
        logger.info("工具栏 新建按钮 %s", text);
        return button;
    }

    public void addButtonListener(String text, ActionListener listener) {
        if (buttons.containsKey(text)){
            buttons.get(text).addActionListener(listener);
        }
    }

    public void addButton(String text, ActionListener listener) {
        newButton(text);
        addButtonListener(text, listener);
    }
}
