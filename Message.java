import javax.swing.JOptionPane;
/**
 * @author Miguel Angel Cortes Hernandez
 * @version 20/Abril/2022
 * @apiNote class Message for throw inforamation messages
 */
public class Message{//public class
    private int value;//global var 

    protected void exit() {//confirm message to exit
        value = JOptionPane.showConfirmDialog(null, "Are you sure yo want exit?\n'Estas seguro que quieres salir?'", "Exit", JOptionPane.YES_NO_OPTION, JOptionPane.INFORMATION_MESSAGE);
        if (value==0){//handling options
            System.exit(0);}}

    protected void error() {//error message
        JOptionPane.showMessageDialog(null, "An error has ocurred", "Error", JOptionPane.ERROR_MESSAGE);
    }//end method

    protected void author(){//throw information from author
        JOptionPane.showMessageDialog(null, "created by Miguel Angel H", "Author", JOptionPane.DEFAULT_OPTION);
    }//end method
}//end class
