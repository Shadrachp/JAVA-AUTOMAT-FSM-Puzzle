import Model.Object;
import javafx.animation.AnimationTimer;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Label;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;

public class Controller {

    /********************GUI*******************/
    @FXML private AnchorPane anchorPane;
    @FXML private ImageView man, woman, lion, cow, grain, spaceship;
    @FXML private ImageView images[];
    @FXML private Label gameLabel, numMoveLabel;


    /***************************************/

    private int numMoves = 0;
    private boolean isOnMars, isValid;
    private Object m, w, l, c, g;
    private Object[] spaceshipObjs = new Object[2];
    private String[] types = {"man", "woman", "lion", "cow", "grain"};
    private StatesController statesController;

    public void injectController(StatesController statesController) {
        this.statesController = statesController;
    }

    public boolean isValid() {
        if(isOnMars) {
            if((m.getLocation() == 0 || w.getLocation() == 0) && l.getLocation() == 0)
            {
                System.out.println("humans & lion on earth");
                return false;
            }

            if((m.getLocation()== 0  || w.getLocation() == 0) && c.getLocation() == 0)
            {
                System.out.println("humans & cow on earth");
                return false;
            }
            if(l.getLocation() == 0 && c.getLocation() == 0)
            {
                System.out.println("cow & lion on earth");
                return false;
            }
            if(g.getLocation() == 0 && c.getLocation() == 0)
            {
                System.out.println("grain & cow on earth");
                return false;
            }
        }
        else {
            if((m.getLocation() == 1 || w.getLocation() == 1) && l.getLocation() == 1)
            {
                System.out.println("humans & lion on mars");
                return false;
            }
            if((m.getLocation() == 1 || w.getLocation() == 1) && c.getLocation() == 1)
            {
                System.out.println("humans & cow on mars");
                return false;
            }
            if(l.getLocation() == 1 && c.getLocation() == 1)
            {
                System.out.println("cow & lion on mars");
                return false;
            }
            if(g.getLocation() == 1 && c.getLocation() == 1)
            {
                System.out.println("grain & cow on mars");
                return false;
            }
        }
        return true;
    }

    public void flyToEarth() {
        AnimationTimer timer = new AnimationTimer() {
            @Override
            public void handle(long now) {
                if(spaceship.getX() == 0 && spaceship.getY() == 0) {
                    this.stop();
                }
                else {
                    spaceship.setX(spaceship.getX() - 3);
                    spaceship.setY(spaceship.getY() - 3);
                }
            }
        };
        timer.start();
    }

    public void flyToMars() {
        AnimationTimer timer = new AnimationTimer() {
            @Override
            public void handle(long now) {
                if (isOnMars) {
                    if (spaceship.getX() == 273 && spaceship.getY() == 273) {
                        this.stop();
                    }
                    else {
                        spaceship.setX(spaceship.getX() + 3);
                        spaceship.setY(spaceship.getY() + 3);
                    }
                }
            }
        };
        timer.start();
    }


    public void displayObjects() {
        if(isOnMars) {
            for(int i=0; i<spaceshipObjs.length; i++) {
                if(spaceshipObjs[i] != null) {
                    spaceshipObjs[i].setLocation(1);

                    if(spaceshipObjs[i].getType().equals("man")) {
                        setImage(man, 450, 410, true);
                    }

                    if(spaceshipObjs[i].getType().equals("woman")) {
                        setImage(woman, 660, 422, true);
                    }

                    if(spaceshipObjs[i].getType().equals("lion")) {
                        setImage(lion, 524, 320, true);
                    }

                    if(spaceshipObjs[i].getType().equals("cow")) {
                        setImage(cow, 600, 322, true);
                    }

                    if(spaceshipObjs[i].getType().equals("grain")) {
                        setImage(grain, 551, 422, true);
                    }
                }
            }
        }
        else {
            for(int i=0; i<spaceshipObjs.length; i++) {
                if(spaceshipObjs[i] != null) {
                    spaceshipObjs[i].setLocation(0);

                    if(spaceshipObjs[i].getType().equals("man")) {
                        setImage(man, 0, 0, true);
                    }

                    if(spaceshipObjs[i].getType().equals("woman")) {
                        setImage(woman, 0, 0, true);
                    }

                    if(spaceshipObjs[i].getType().equals("lion")) {
                        setImage(lion, 0, 0, true);
                    }

                    if(spaceshipObjs[i].getType().equals("cow")) {
                        setImage(cow, 0, 0, true);
                    }

                    if(spaceshipObjs[i].getType().equals("grain")) {
                        setImage(grain, 0, 0, true);
                    }
                }
            }
        }
    }

    public void setImage(ImageView imageView, int x, int y, boolean visible) {
        imageView.setX(x);
        imageView.setY(y);
        imageView.setVisible(visible);
    }

    public void checkMove(Object o, ImageView imageView) {
        if(spaceshipObjs[0] == null) {
            spaceshipObjs[0] = o;
            imageView.setVisible(false);
        }
        else if(spaceshipObjs[1] == null) {
            spaceshipObjs[1] = o;
            imageView.setVisible(false);
        }
        else {
            System.out.println("FULL");
        }

    }

    public void setNumMoveLabel(int numMoves) {
        numMoveLabel.setText("Number of moves: " + numMoves);
        if(numMoves == 0)
            numMoveLabel.setText("Number of moves: ");
    }

    public void checkWin() {
        if(g.getLocation() == 1 && c.getLocation() == 1 && l.getLocation() == 1
                && m.getLocation() == 1 && w.getLocation() == 1) {
            gameLabel.setText("YOU WIN!!!");
            //end game
        }
    }

    public String moveToString() {
        StringBuffer buf = new StringBuffer();

        buf.append(m.getLocation());
        buf.append(w.getLocation());
        buf.append(l.getLocation());
        buf.append(c.getLocation());
        buf.append(g.getLocation());

        return buf.toString();
    }

    /***************************************************************/

    @FXML
    void initialize() {
        isOnMars = false;

        m = new Object("man", 0);
        w = new Object("woman", 0);
        l = new Object("lion", 0);
        c = new Object("cow", 0);
        g = new Object("grain", 0);

        images = new ImageView[]{man, woman, cow, lion, grain, spaceship};
    }

    @FXML
    void fly(MouseEvent event) {
//        checkWin();   WHY U LATE
        gameLabel.setVisible(false);
        numMoves++;
        setNumMoveLabel(numMoves);
        System.out.println("transporting");

        if(isOnMars) {
            isOnMars = false;
            flyToEarth();
        }
        else {
            isOnMars = true;
            flyToMars();
        }

        displayObjects();

        if(isValid()) {
            System.out.println("valid");
            isValid = true;
            spaceshipObjs[0] = null;
            spaceshipObjs[1] = null;
        }
        else {
            System.out.println("invalid");
            isValid = false;
            gameLabel.setVisible(true);

            //just to fill up the spaceship
            spaceshipObjs[0] = c;
            spaceshipObjs[1] = c;
        }

        System.out.println(moveToString());
        statesController.updateStates(moveToString(), isValid);
    }

    @FXML
    void hint() {

    }

    @FXML
    void solution() {

    }

    @FXML
    void reset() {
        c.setLocation(0);
        g.setLocation(0);
        l.setLocation(0);
        m.setLocation(0);
        w.setLocation(0);

        spaceshipObjs[0] = null;
        spaceshipObjs[1] = null;

        for(int i = 0; i < images.length; i++) {
            setImage(images[i], 0,0,true);
        }

        gameLabel.setVisible(false);
        isOnMars = false;
        numMoves = 0;
        setNumMoveLabel(numMoves);
        statesController.resetStates();
    }

    @FXML
    void instructions() {
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle("Instructions");
        alert.setHeaderText("How to Play the Game");
        alert.setContentText("You, the scientist, want to transport 5 things to start a new life on Mars: \n" +
                            "2 humans, 1 lion, 1 cow and 1 bag of grain\n\n" +
                            "The spaceship was so tiny it could only carry yourself and 2 other items.. \n\n" +
                            "Whenever the scientist is not around:\n\n" +
                            "human would kill the lion\n" +
                            "human would eat the cow\n" +
                            "lion will eat the cow\n" +
                            "cow will eat the grain\n\n" +
                            "Only you know how to fly the spaceship.\n" +
                            "How will you transport all the five items to Mars?!");
        alert.showAndWait();
    }

    @FXML void carryCow(MouseEvent event) { checkMove(c, cow); }
    @FXML void carryGrain(MouseEvent event) { checkMove(g, grain); }
    @FXML void carryLion(MouseEvent event) { checkMove(l, lion); }
    @FXML void carryMan(MouseEvent event) { checkMove(m, man); }
    @FXML void carryWoman(MouseEvent event) { checkMove(w, woman); }
}
