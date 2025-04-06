/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package util;

import java.awt.Color;
import java.awt.Component;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Insets;
import java.awt.RenderingHints;
import javax.swing.border.Border;

/**
 *
 * @author kiman
 */
public class DropShadowBorder implements Border{
    private int shadowSize = 10;
    private Color shadowColor = new Color(0, 0, 0, 100); // Màu đen với độ trong suốt

    public DropShadowBorder(int shadowSize, Color shadowColor) {
        this.shadowSize = shadowSize;
        this.shadowColor = shadowColor;
    }

    @Override
    public void paintBorder(Component c, Graphics g, int x, int y, int width, int height) {
        Graphics2D g2 = (Graphics2D) g.create();
        g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);

        // Vẽ bóng
        for (int i = 0; i < shadowSize; i++) {
            g2.setColor(new Color(shadowColor.getRed(), shadowColor.getGreen(), shadowColor.getBlue(), (100 - i * 10)));
            g2.drawRoundRect(x + i, y + i, width - i * 2 - 1, height - i * 2 - 1, 20, 20);
        }

        g2.dispose();
    }

    @Override
    public Insets getBorderInsets(Component c) {
        return new Insets(shadowSize, shadowSize, shadowSize, shadowSize);
    }

    @Override
    public boolean isBorderOpaque() {
        return false;
    }
}
