package employee.mgmt.client;

import java.awt.EventQueue;
import javax.swing.JFrame;
import javax.swing.UIManager;

/**
 *
 * @author jvergara
 */
public class EmployeeMgmtClient
{

    public static void main(String[] args) throws Exception
    {
        try {
            UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
        }
        catch(Exception e){}
        
        final JFrame f = new JFrame("Test Client");
        f.setContentPane(new EmployeeListPage());
        f.pack();
        f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        
        EventQueue.invokeLater(new Runnable() {
            @Override
            public void run()
            {
                f.setVisible(true);
            }
        });
    }
}
