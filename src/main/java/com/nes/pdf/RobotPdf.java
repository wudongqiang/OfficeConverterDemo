package com.nes.pdf;

import java.awt.*;
import java.awt.event.InputEvent;
import java.awt.event.KeyEvent;
import java.io.File;
import java.io.IOException;

public class RobotPdf {

    public static void main(String[] args) throws Exception {
        desktopOpen();
    }

    private static void desktopOpen()  throws Exception {
        Robot robot = new Robot();

        new Thread(() -> {
            //打开自定文件
            Desktop desktop = Desktop.getDesktop();
            desktop.isSupported(Desktop.Action.OPEN);
            try {
                desktop.open(new File("/home/wdq/下载/2022年重庆市博士后科学基金项目申报书1-正文.docx"));
            } catch (IOException e) {
                e.printStackTrace();
            }
        }).start();

        robot.delay(5000);

        //按下alt+f 打开菜单
        robot.keyPress(KeyEvent.VK_ALT);
        robot.keyPress(KeyEvent.VK_F);
        robot.keyRelease(KeyEvent.VK_F);
        robot.keyRelease(KeyEvent.VK_ALT);

        robot.delay(200);
        //按下f, 打开输出pdf对话框
        robot.keyPress(KeyEvent.VK_F);
        robot.keyRelease(KeyEvent.VK_F);

        //按下alt+o 进行pdf转换
        robot.delay(200);
        robot.keyPress(KeyEvent.VK_ALT);
        robot.keyPress(KeyEvent.VK_O);
        robot.keyRelease(KeyEvent.VK_O);
        robot.keyRelease(KeyEvent.VK_F);
        //按下enter
        robot.delay(2200);
        robot.keyPress(KeyEvent.VK_ENTER);
        robot.keyRelease(KeyEvent.VK_ENTER);

        //按下alt+f4
        robot.delay(2000);
        robot.keyPress(KeyEvent.VK_ALT);
        robot.keyPress(KeyEvent.VK_F4);
        robot.keyRelease(KeyEvent.VK_ALT);
        robot.keyRelease(KeyEvent.VK_F4);
    }

    /**
     * 打开wps 转换pdf， 通过鼠标移动操作
     */
    private void d() throws AWTException {
        Robot robot = new Robot();
        robot.delay(1000);
        //鼠标移动到左下角
        robot.mouseMove(20, 1020);

        //鼠标左击
        robot.mousePress(InputEvent.BUTTON1_MASK);
        robot.delay(10);
        robot.mouseRelease(InputEvent.BUTTON1_MASK);

        robot.delay(1000);

        //鼠标移动到输入框
        robot.mouseMove(850, 75);
        //选中输入框
        robot.mousePress(InputEvent.BUTTON1_MASK);
        robot.mouseRelease(InputEvent.BUTTON1_MASK);

        robot.delay(200);

        //输入wps
        robot.keyPress(KeyEvent.VK_W);
        robot.delay(10);
        robot.keyRelease(KeyEvent.VK_W);
        robot.keyPress(KeyEvent.VK_P);
        robot.delay(10);
        robot.keyRelease(KeyEvent.VK_P);
        robot.keyPress(KeyEvent.VK_S);
        robot.delay(10);
        robot.keyRelease(KeyEvent.VK_S);

        robot.delay(20);
        robot.keyPress(KeyEvent.VK_ENTER);
        robot.keyRelease(KeyEvent.VK_ENTER);

        robot.delay(10);
        robot.mouseMove(850, 250);

        //双击左键
        //选中输入框
        robot.delay(1000);
        robot.mousePress(InputEvent.BUTTON1_MASK);
        robot.mouseRelease(InputEvent.BUTTON1_MASK);
        robot.delay(5);
        robot.mousePress(InputEvent.BUTTON1_MASK);
        robot.mouseRelease(InputEvent.BUTTON1_MASK);

        //移到文件操作
        robot.delay(1000);
        robot.mouseMove(100, 80);

        robot.delay(200);
        robot.mousePress(InputEvent.BUTTON1_MASK);
        robot.mouseRelease(InputEvent.BUTTON1_MASK);
        //按下F
        robot.delay(1000);
        robot.keyPress(KeyEvent.VK_F);
        robot.keyRelease(KeyEvent.VK_F);

        //按下alt+o
        robot.delay(200);
        robot.keyPress(KeyEvent.VK_ALT);
        robot.keyPress(KeyEvent.VK_O);
        robot.keyRelease(KeyEvent.VK_O);
        robot.keyRelease(KeyEvent.VK_F);
        //按下enter
        robot.delay(2200);
        robot.keyPress(KeyEvent.VK_ENTER);
        robot.keyRelease(KeyEvent.VK_ENTER);
        //按下alt+f4
        robot.delay(1000);
        robot.keyPress(KeyEvent.VK_ALT);
        robot.keyPress(KeyEvent.VK_F4);
        robot.keyRelease(KeyEvent.VK_ALT);
        robot.keyRelease(KeyEvent.VK_F4);
    }
}
