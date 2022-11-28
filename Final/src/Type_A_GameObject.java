import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.LinkedList;
import javax.swing.Icon;
import javax.swing.ImageIcon;

public class Type_A_GameObject extends GameObject implements KeyListener {

  public Type_A_GameObject(int x, int y) {
    super(x, y);
    setDirection(Direction.NONE);
    
    imageList = new LinkedList<Icon>();
    imageList.add(new ImageIcon("images/Type_A_Up.png"));
    imageList.add(new ImageIcon("images/Type_A_Down.png"));
    imageList.add(new ImageIcon("images/Type_A_Left.png"));
    imageList.add(new ImageIcon("images/Type_A_Right.png"));

    isActive = true;
    
  }

  public void move(Canvas c) {
    Icon icon = getCurrentImage();

    int  iconHeight   = icon.getIconHeight();
    //int  iconWidth    = icon.getIconWidth();
    int  canvasHeight = (int)c.getSize().getHeight();
    //int  canvasWidth  = (int)c.getSize().getWidth();
    
    //MOVE BLUE GAME OBJECT
    switch (getDirection()) {
      case Direction.UP:
        setY(getY() - getVelocity());
        if (getY() < 0) {
          setY(0);
        }
        break;
      case Direction.DOWN:
        setY(getY() + getVelocity());
        if (getY() + iconHeight > canvasHeight) {
          setY((int)(canvasHeight - iconHeight));
        }
        break;
      case Direction.LEFT:
        break;
      case Direction.RIGHT:
        break;
	  default:
		  break;
    }

  }

  //SPECIFY THE IMAGE TO DISPLAY
  //   USED FOR ANIMATION
  public void setImage() {
	    switch (getDirection()) {
	      case Direction.NONE:
	        break;
	      case Direction.UP:
	        currentImage = 0;
	        break;
	      case Direction.DOWN:
	        currentImage = 1;
	        break;
	      case Direction.LEFT:
	        break;
	      case Direction.RIGHT:
	        break;
	    }
	  }

  public void keyTyped(KeyEvent e) {
  }

  public void keyReleased(KeyEvent e) {
    if (e.getKeyCode() != KeyEvent.VK_TAB) {
      setDirection(Direction.NONE);
    }
  }

  public void keyPressed(KeyEvent e) {
    if(isActive) {
      if (e.getKeyCode() == KeyEvent.VK_UP) {
        setDirection(Direction.UP);
      }
      if (e.getKeyCode() == KeyEvent.VK_DOWN) {
        setDirection(Direction.DOWN);
      }
      if (e.getKeyCode() == KeyEvent.VK_RIGHT) {
        setDirection(Direction.LEFT);
      }
      if (e.getKeyCode() == KeyEvent.VK_LEFT) {
        setDirection(Direction.RIGHT);
      }
    }
  }

}
