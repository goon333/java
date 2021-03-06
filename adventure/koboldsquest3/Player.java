/***
Copyright (c) 2015, Johan Ceuppens (goon)
All rights reserved.

Redistribution and use in source and binary forms, with or without modification, are permitted provided that the following conditions are met:

1. Redistributions of source code must retain the above copyright notice, this list of conditions and the following disclaimer.

2. Redistributions in binary form must reproduce the above copyright notice, this list of conditions and the following disclaimer in the documentation and/or other materials provided with the distribution.

3. Neither the name of the copyright holder nor the names of its contributors may be used to endorse or promote products derived from this software without specific prior written permission.

THIS SOFTWARE IS PROVIDED BY THE COPYRIGHT HOLDERS AND CONTRIBUTORS "AS IS" AND ANY EXPRESS OR IMPLIED WARRANTIES, INCLUDING, BUT NOT LIMITED TO, THE IMPLIED WARRANTIES OF MERCHANTABILITY AND FITNESS FOR A PARTICULAR PURPOSE ARE DISCLAIMED. IN NO EVENT SHALL THE COPYRIGHT HOLDER OR CONTRIBUTORS BE LIABLE FOR ANY DIRECT, INDIRECT, INCIDENTAL, SPECIAL, EXEMPLARY, OR CONSEQUENTIAL DAMAGES (INCLUDING, BUT NOT LIMITED TO, PROCUREMENT OF SUBSTITUTE GOODS OR SERVICES; LOSS OF USE, DATA, OR PROFITS; OR BUSINESS INTERRUPTION) HOWEVER CAUSED AND ON ANY THEORY OF LIABILITY, WHETHER IN CONTRACT, STRICT LIABILITY, OR TORT (INCLUDING NEGLIGENCE OR OTHERWISE) ARISING IN ANY WAY OUT OF THE USE OF THIS SOFTWARE, EVEN IF ADVISED OF THE POSSIBILITY OF SUCH DAMAGE.

***/

package koboldsquest3;

import java.awt.*;
import java.awt.event.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.io.IOException;
import javax.imageio.ImageIO;

public class Player 
{

	private int x,y;
	private BufferedImage standimg0 = null; 
	private BufferedImage walkimg0 = null; 
	private BufferedImage walkimg00 = null;
       	private int walking;	
       	private int talking;	

	public void init()
	{
		try {
				standimg0 = ImageIO.read(new File("./koboldsquest3/" + "player-stand-1-50x50.bmp"));
				walkimg0 = ImageIO.read(new File("./koboldsquest3/" + "player01-50x50.bmp"));
				walkimg00 = ImageIO.read(new File("./koboldsquest3/" + "player02-50x50.bmp"));
			} catch (IOException e) {
			}
	}

	public Player()
	{
		x = 100;
		y = 100;
		init();	
	}

	public void visitCanvas(Canvas canvas, int keycode) {
		switch(keycode) {
			case KeyEvent.VK_LEFT:
			case KeyEvent.VK_RIGHT:
			case KeyEvent.VK_UP:
			case KeyEvent.VK_DOWN:
				walking = 1;
				return;
			case KeyEvent.VK_T:
				talking = 1;
				return;
			default:
				break;
		}
		walking = 0;
		talking = 0;
	}

	public int getx() {
		return x;
	}

	public int gety() {
		return y;
	}

	public BufferedImage getimg() {
		if (walking == 0)
			return standimg0;

		walking += 1;

		if (walking <= 10) 
			return walkimg0;
		else if (walking <= 20)
			return standimg0;
		else if (walking <= 29)
			walking = 1;
			return walkimg00;
	}

	public void setwalking(int x) {
		walking = x;
	}
}
