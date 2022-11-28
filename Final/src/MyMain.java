public class MyMain {

	public static void main(String[] args) {

		// TASK 1: CREATE A CANVAS FOR ANIMATION
		Canvas canvas = new Canvas();
		canvas.requestFocus();
		
		//TASK 2:  ADD A USER GAME OBJECT
		Type_A_GameObject a = new Type_A_GameObject(200, 200);
		Type_B_GameObject b = new Type_B_GameObject(400, 200);
		Type_C_GameObject c = new Type_C_GameObject(200, 400);
		Type_D_GameObject d = new Type_D_GameObject(400, 400);

		a.setVelocity(15);
		b.setVelocity(15);
		c.setVelocity(15);
		d.setVelocity(15);

		canvas.addKeyListener(a);
		canvas.addKeyListener(b);
		canvas.addKeyListener(c);
		canvas.addKeyListener(d);

		canvas.addGameObject(a);
		canvas.addGameObject(b);
		canvas.addGameObject(c);
		canvas.addGameObject(d);

	}

}

