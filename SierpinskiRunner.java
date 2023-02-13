import static java.awt.event.KeyEvent.VK_B;
import static java.awt.event.KeyEvent.VK_SPACE;

public class SierpinskiRunner
{
    public static void main(String[] args)
    {
        openingCredits();
        Sierpinski.sierpinski(1);
        waitToAdvance();
        Sierpinski.sierpinski(3);
        waitToAdvance();
        Sierpinski.sierpinski(6);
        waitToAdvance();
    }

    private static void waitToAdvance()
    {
        while (!StdDraw.isKeyPressed(VK_SPACE))
        {
            StdDraw.pause(10);
        }
        resetCanvas();
        // Give the system time to catch up
        StdDraw.pause(1000);
    }

    private static void resetCanvas()
    {
        StdDraw.disableDoubleBuffering();
        StdDraw.setCanvasSize();
        StdDraw.pause(250);
    }

    private static void openingCredits()
    {
        StdDraw.text(0.5, 0.5, "Running Sierpinski...");
        StdDraw.pause(500);
        StdDraw.clear();
        StdDraw.text(0.5, 0.5, "Press \"B\" to begin.");
        StdDraw.text(0.5, 0.4, "Press SPACE to advance to next problem.");
        while (!StdDraw.isKeyPressed(VK_B))
        {
            StdDraw.pause(10);
        }
        StdDraw.clear();
    }
}
