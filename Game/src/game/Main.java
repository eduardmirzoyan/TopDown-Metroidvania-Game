package game;

import processing.core.PApplet;

public class Main {

//	public static void main(String[] args) {
//
//		
//
//		Game game = new Game();
//		PApplet.runSketch(new String[] { "" }, game);
//		PSurfaceAWT surf = (PSurfaceAWT) game.getSurface();
//		PSurfaceAWT.SmoothCanvas canvas = (PSurfaceAWT.SmoothCanvas) surf.getNative();
//		JFrame window = (JFrame) canvas.getFrame();
//
//		//The bar thing's size is 6 by 29
//		window.setSize(1606, 929);
//		window.setMinimumSize(new Dimension(1600, 900));
//		window.setMaximumSize(new Dimension(1600, 900));
//		window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
//		window.setResizable(true);
//		window.setTitle("Dungeon");
//		try {
//			window.setIconImage(ImageIO.read(new File("images\\mine.png")));
//		} catch (IOException e) {
//
//			e.printStackTrace();
//		}
//
//		window.setVisible(true);
//	}
	
	public static void main(String[] args) {
		PApplet.main("game.MenuScreen");
	}

}
