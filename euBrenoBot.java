package euBrenoBot;
import java.awt.Color;
import robocode.*;

public class euBrenoBot extends AdvancedRobot {
    public void run() {
	setColors(Color.magenta,Color.green,Color.pink,Color.green,Color.green);
        while (true) {
             ahead(100); // Move-se para frente
            turnGunRight(360); // Gira a arma em torno de 360 graus
            back(100); // Move-se para trás
            turnGunRight(360); // Gira a arma em torno de 360 graus
        }
    }

public void onScannedRobot(ScannedRobotEvent e) {
        // Quando um robô é detectado, ajuste a mira suavemente para o inimigo
        double angleToTurn = getHeading() - getGunHeading() + e.getBearing();
        if (angleToTurn > 180) {
            angleToTurn -= 360;
        } else if (angleToTurn < -180) {
            angleToTurn += 360;
        }
        turnGunRight(angleToTurn);
        fire(3); // Atire com potência máxima
    }
	
	 public void onHitByBullet(HitByBulletEvent e){ //Evitar balas: vira 45º e anda 50px
	setTurnLeft(45);
	setAhead(50);
	execute();
	}
	
  public void onHitRobot(HitRobotEvent e){//Caso encontrar um robô, atirar com 3* a força
		setTurnRight(e.getBearing());
		setFire(3);
		execute();
	}

}
