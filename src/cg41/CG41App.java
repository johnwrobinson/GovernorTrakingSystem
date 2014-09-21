package cg41;

import org.jdesktop.application.Application;
import org.jdesktop.application.SingleFrameApplication;

/**
 * The main class of the application.
 */
public class CG41App extends SingleFrameApplication {

    /**
     * At startup create and show the main frame of the application.
     */
    @Override protected void startup() {
        show(new CG41View(this));
    }

    /**
     * This method is to initialize the specified window by injecting resources.
     * Windows shown in our application come fully initialized from the GUI
     * builder, so this additional configuration is not needed.
     */
    @Override protected void configureWindow(java.awt.Window root) {
    }

    /**
     * A convenient static getter for the application instance.
     * @return the instance of CG41App
     */
    public static CG41App getApplication() {
        return Application.getInstance(CG41App.class);
    }

    /**
     * Main method launching the application.
     */

    public static MyDBObject dbObject;
    public static MyDBObject dbObject2;
    public static Validation validateObject;

    public static void main(String[] args) {
        //create the database and validation objects
        dbObject = new MyDBObject();
        dbObject2 = new MyDBObject();
        validateObject = new Validation();
        if( CG41App.dbObject.ErrorCode == 0){
            launch(CG41App.class, args);
        }
    }
}
