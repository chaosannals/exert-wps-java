package exert.wpsjava;

import java.awt.*;
import javax.swing.*;
import com.wps.api.tree.et.*;
import com.sun.jna.*;
import com.wps.runtime.utils.*;
import com4j.Variant;

class WpsCanvas extends Canvas {
    private static final int DEFAULT_LCID = 2052;

    private Application app;

    public WpsCanvas() {
        app = null;
    }

    public void paint(Graphics g) {
        super.paint(g);
    }

    /**
     * 初始化
     */
    public void init() {
        if (app != null) return;
        Pointer p = Native.getComponentPointer(this);
        long winId = Pointer.nativeValue(p);
        WpsArgs args = WpsArgs.ARGS_MAP.get(WpsArgs.App.ET);
        args.setWinid(winId);
        args.setWidth(getWidth());
        args.setHeight(getHeight());
        app = ClassFactory.createApplication();
        app.put_Visible(DEFAULT_LCID, true);
    }

    public void addWorkbook() {
        app.get_Workbooks().Add(Variant.getMissing(), DEFAULT_LCID);
    }

    public String browseFile(String title, int type) {
        FileDialog dialog = new FileDialog((JFrame) null, title, type);
        dialog.setVisible(true);
        if (dialog.getDirectory() == null || dialog.getFile() == null)
            throw new RuntimeException("选择的文件不能为空!");
        return dialog.getDirectory() + dialog.getFile();
    }
}