/***
Copyright (c) 2015, Johan Ceuppens (goon)
All rights reserved.

Redistribution and use in source and binary forms, with or without modification, are permitted provided that the following conditions are met:

1. Redistributions of source code must retain the above copyright notice, this list of conditions and the following disclaimer.

2. Redistributions in binary form must reproduce the above copyright notice, this list of conditions and the following disclaimer in the documentation and/or other materials provided with the distribution.

3. Neither the name of the copyright holder nor the names of its contributors may be used to endorse or promote products derived from this software without specific prior written permission.

THIS SOFTWARE IS PROVIDED BY THE COPYRIGHT HOLDERS AND CONTRIBUTORS "AS IS" AND ANY EXPRESS OR IMPLIED WARRANTIES, INCLUDING, BUT NOT LIMITED TO, THE IMPLIED WARRANTIES OF MERCHANTABILITY AND FITNESS FOR A PARTICULAR PURPOSE ARE DISCLAIMED. IN NO EVENT SHALL THE COPYRIGHT HOLDER OR CONTRIBUTORS BE LIABLE FOR ANY DIRECT, INDIRECT, INCIDENTAL, SPECIAL, EXEMPLARY, OR CONSEQUENTIAL DAMAGES (INCLUDING, BUT NOT LIMITED TO, PROCUREMENT OF SUBSTITUTE GOODS OR SERVICES; LOSS OF USE, DATA, OR PROFITS; OR BUSINESS INTERRUPTION) HOWEVER CAUSED AND ON ANY THEORY OF LIABILITY, WHETHER IN CONTRACT, STRICT LIABILITY, OR TORT (INCLUDING NEGLIGENCE OR OTHERWISE) ARISING IN ANY WAY OUT OF THE USE OF THIS SOFTWARE, EVEN IF ADVISED OF THE POSSIBILITY OF SUCH DAMAGE.

***/

package adventure;

import java.awt.*;
import java.awt.event.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.io.IOException;
import javax.imageio.ImageIO;

public class Main extends Frame implements ActionListener
{
	BufferedImage img = null;

	class MainCanvas extends Canvas
	{

		private Room room = new Room("bg-adventure.bmp");

		public void paint(Graphics g) {
			g.drawImage(room.getbg(), room.getx(), room.gety(), null);
		
		}

		public void Accept(Room r, int keycode) {
			r.visitCanvas(this, keycode);
		}

		public MainCanvas() { 
			addKeyListener(new KeyAdapter () {
			public void keyPressed (KeyEvent e) {
				if (e.getKeyCode() == KeyEvent.VK_LEFT) {
					Accept(room, e.getKeyCode());
				} else
				if (e.getKeyCode() == KeyEvent.VK_RIGHT) {
					Accept(room, e.getKeyCode());
				} else
				if (e.getKeyCode() == KeyEvent.VK_UP) {
					Accept(room, e.getKeyCode());
				} else
				if (e.getKeyCode() == KeyEvent.VK_DOWN) {
					Accept(room, e.getKeyCode());
				}
				repaint();
			}
			public void keyReleased (KeyEvent e) {
				if (e.getKeyCode() == KeyEvent.VK_ESCAPE) {
					System.exit(0);
				}
			}
		});	
		}
	}
	private MainCanvas canvas;	

	public Main() {
			setTitle("Adventure");
			try {
				img = ImageIO.read(new File("./adventure/bg-adventure.bmp"));
			} catch (IOException e) {
			}
			canvas = new MainCanvas();
			add("Center", canvas);
			
	}	

	public void actionPerformed(ActionEvent e)
	{
		setVisible(false);
		dispose();
		System.exit(0);
	}

	public static void main(String[] args)
	{
		Frame f = new Main();
		f.setTitle("Adventure");
		f.setSize(320, 200);
		f.setVisible(true);
		f.addWindowListener(new WindowAdapter () {
			public void windowClosing(WindowEvent e) {
				System.exit(0);
			}
		});
	}



}
