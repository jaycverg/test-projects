package employee.mgmt.client;

import employee.mgmt.client.controller.EmployeeMgmtController;
import java.awt.EventQueue;
import javax.swing.JFrame;
import javax.swing.UIManager;
import simplemvc.util.MVCUtil;

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
        
        final JFrame f = MVCUtil.createFrame(new EmployeeMgmtController(), "Employee Mgmt.");
        f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        f.pack();
        
        EventQueue.invokeLater(new Runnable() {
            @Override
            public void run()
            {
                f.setVisible(true);
            }
        });
    }
}
