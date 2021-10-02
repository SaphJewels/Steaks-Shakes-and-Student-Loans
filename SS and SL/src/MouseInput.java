import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

public class MouseInput implements MouseListener {
		
		public void mouseClicked(MouseEvent e) {
			
			Shakes sh = new Shakes();
			
			Quaking.xVal = e.getX();
			Quaking.yVal = e.getY();
			
			if (Quaking.xVal <= 10 && Quaking.yVal <= 10) {
				Game.reset();
			}
			
			if (Quaking.xVal >= 600 && Quaking.xVal <= 700 && Quaking.yVal >= 25 && Quaking.yVal <= 125) {
				Quaking.stage++;
				if (Quaking.stage >= 3) {
					Quaking.stage = 1;
				}
			}
			
			if (Quaking.xVal >= 450 && Quaking.xVal <= 550 && Quaking.yVal >= 25 && Quaking.yVal <= 125) {
				Quaking.newOrder = true;
			}
			
			if(Quaking.stage == 0) {
				
			}
			
			//burger stage
			else if(Quaking.stage == 1) {
				Game.quake.checkClick(Quaking.xVal, Quaking.yVal);
				
				if(Quaking.xVal >= Quaking.leftBX && Quaking.xVal<=Quaking.leftBX+Quaking.boxWIDTHL) {
					if(Quaking.yVal >= Quaking.bunBY && Quaking.yVal <= Quaking.bunBY+Quaking.boxHEIGHTL) {
						Shakes.burgerBoolArr[0] = true;
					}
					else if(Quaking.yVal >= Quaking.pattyBY && Quaking.yVal <= Quaking.pattyBY+Quaking.boxHEIGHTL) {
						Shakes.burgerBoolArr[1] = true;
					}
					else if(Quaking.yVal >= Quaking.cheeseBY && Quaking.yVal <= Quaking.cheeseBY+Quaking.boxHEIGHTL) {
						Shakes.burgerBoolArr[2] = true;
					}
				}
				else if(Quaking.xVal >= Quaking.rightBX && Quaking.xVal <= Quaking.rightBX+Quaking.boxWIDTHR) {
					if(Quaking.yVal >= Quaking.lettuceBY && Quaking.yVal <= Quaking.lettuceBY+Quaking.boxHEIGHTR) {
						if(Shakes.burgerBoolArr[0] && Shakes.burgerBoolArr[1] && Shakes.burgerBoolArr[2]) {
							Shakes.burgerBoolArr[3] = true;
						}
					}
					else if(Quaking.yVal >= Quaking.tomatoBY && Quaking.yVal <= Quaking.tomatoBY+Quaking.boxHEIGHTR) {
						if(Shakes.burgerBoolArr[0] && Shakes.burgerBoolArr[1] && Shakes.burgerBoolArr[2]) {
							Shakes.burgerBoolArr[4] = true;
						}
					}
					else if(Quaking.yVal >= Quaking.onionBY && Quaking.yVal <= Quaking.onionBY+Quaking.boxHEIGHTR) {
						if(Shakes.burgerBoolArr[0] && Shakes.burgerBoolArr[1] && Shakes.burgerBoolArr[2]) {
							Shakes.burgerBoolArr[5] = true;
						}
					}
					else if(Quaking.yVal >= Quaking.baconBY && Quaking.yVal <= Quaking.baconBY+Quaking.boxHEIGHTR) {
						if(Shakes.burgerBoolArr[0] && Shakes.burgerBoolArr[1] && Shakes.burgerBoolArr[2]) {
							Shakes.burgerBoolArr[6] = true;
						}
					}
				}
				
				Game.quake.update();
			}
			
			//shake stage
			else if (Quaking.stage == 2) {
				//Whipped cream
				if (Quaking.yVal >= 315 && Quaking.yVal <= 455 && Quaking.xVal >= 225 && Quaking.xVal <= 450) {
					Shakes.shake[3] = true;
				}
				
				//Cherry
				else if (Quaking.yVal >= 175 && Quaking.yVal <= 250 && Quaking.xVal >= 225 && Quaking.xVal <= 300 && Shakes.shake[3]) {
					Shakes.shake[4] = true;
				}
				
				if(Shakes.shake[3] && Shakes.shake[4] && (Shakes.shake[0]||Shakes.shake[1]||Shakes.shake[2])) {
					int counter = 5;
					for (int j = 0; j < 2; j++) {
						for (int i = 175; i <= 375; i += 100) {
							if (Quaking.yVal >= i && Quaking.yVal <= i+100 && Quaking.xVal >= j * 125 + 325 && Quaking.xVal <= j * 125 + 400 ) {
								Shakes.shake[counter] = true;
							}
							counter++;
						}
					}
				}
				
				if (Quaking.xVal >= 300 && Quaking.xVal <= 400 && Quaking.yVal >= 25 && Quaking.yVal <= 125) {
					boolean maybe = Game.checking();
					if (maybe) {
						double tempCash = Game.cashCheck();
						for(int i=0; i<11;i++) {
							sh.shake[i]=false;
							sh.shakeOrder[i]=false;
							if(i<7) {
								sh.burgerBoolArr[i]=false;
								Quaking.burgerOrder[i]=false;
							}
						}
						Quaking.shakeColor=0;
						Quaking.money += tempCash;
						if(Quaking.money>=Quaking.studloan) {
							Quaking.stage=3;
						}
					}
					else {

					}
				}
				
			}
			else if(Quaking.stage == 4) {
				if(Quaking.yVal>=250 && Quaking.yVal <= 350 && Quaking.xVal >= 320 && Quaking.xVal <= 420) {
					Game.reset();
					Quaking.money=1.0;
					Quaking.stage=0;
				}
			}
			
			Game.quake.update();
			
		}
			
			
		

		@Override
		public void mouseEntered(MouseEvent e) {
			// TODO Auto-generated method stub
			
		}

		@Override
		public void mouseExited(MouseEvent e) {
			// TODO Auto-generated method stub
			
		}

		@Override
		public void mousePressed(MouseEvent e) {
			// TODO Auto-generated method stub
			
		}

		@Override
		public void mouseReleased(MouseEvent e) {
			// TODO Auto-generated method stub
			Quaking.clicked = false;
		}
		
	}