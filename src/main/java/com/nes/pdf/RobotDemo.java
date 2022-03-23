package com.nes.pdf;

import java.awt.*;
import java.awt.datatransfer.Clipboard;
import java.awt.datatransfer.StringSelection;
import java.awt.event.InputEvent;
import java.awt.event.KeyEvent;

public class RobotDemo {

    public static void main(String[] args) throws Exception {
        //模拟打开钉钉
        Robot robot = new Robot();

        robot.delay(200);
        //移动鼠标，找到钉钉
        robot.mouseMove(22, 680);

        robot.delay(20);
        //选择 按下左键
        robot.mousePress(InputEvent.BUTTON1_MASK);
        robot.mouseRelease(InputEvent.BUTTON1_MASK);

        //移动鼠标，找到搜索框
        robot.mouseMove(750, 85);

        robot.delay(20);
        //按下左键
        robot.mousePress(InputEvent.BUTTON1_MASK);
        robot.mouseRelease(InputEvent.BUTTON1_MASK);
        robot.delay(20);

        //按下 ctrl+A ,选中历史输入字符
        robot.keyPress(KeyEvent.VK_CONTROL);
        robot.keyPress(KeyEvent.VK_A);
        robot.keyRelease(KeyEvent.VK_A);
        robot.keyRelease(KeyEvent.VK_CONTROL);

        //按回车
        robot.delay(20);
        robot.keyPress(KeyEvent.VK_DELETE);
        robot.keyRelease(KeyEvent.VK_DELETE);

        //创建粘贴板
        robot.delay(50);
        Toolkit toolkit = Toolkit.getDefaultToolkit();
        Clipboard clipboard = toolkit.getSystemClipboard();
        clipboard.setContents(new StringSelection("刘颖"), null);

        //按复制 ctrl+v
        //robot.delay(10);
        robot.keyPress(KeyEvent.VK_CONTROL);
        robot.keyPress(KeyEvent.VK_V);
        robot.keyRelease(KeyEvent.VK_V);
        robot.delay(10);
        robot.keyRelease(KeyEvent.VK_CONTROL);

        //按回车
        robot.delay(200);
        System.out.println("xx");
        robot.keyPress(KeyEvent.VK_ENTER);
        robot.keyRelease(KeyEvent.VK_ENTER);

        //输入文字，进行聊天
        for(int i=1;i<=10;i++){
            clipboard.setContents(new StringSelection("我在模拟robot发信息，这是第 "+i+" 条"),null);

            robot.keyPress(KeyEvent.VK_CONTROL);
            robot.keyPress(KeyEvent.VK_V);
            robot.keyRelease(KeyEvent.VK_V);
            robot.delay(10);
            robot.keyRelease(KeyEvent.VK_CONTROL);

            //按回车
            robot.delay(500);
            robot.keyPress(KeyEvent.VK_ENTER);
            robot.keyRelease(KeyEvent.VK_ENTER);

        }

    }

}