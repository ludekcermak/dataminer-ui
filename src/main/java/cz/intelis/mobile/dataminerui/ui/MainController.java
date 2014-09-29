package cz.intelis.mobile.dataminerui.ui;

import org.zkoss.zk.ui.Component;
import org.zkoss.zk.ui.select.SelectorComposer;
import org.zkoss.zk.ui.select.annotation.Listen;
import org.zkoss.zk.ui.select.annotation.Wire;
import org.zkoss.zul.Messagebox;
import org.zkoss.zul.Radio;
import org.zkoss.zul.Textbox;

/**
 * @author Ludek Cermak
 *
 */
public class MainController extends SelectorComposer<Component> {
	
	private static final long serialVersionUID = 1L;
	
	private static final String MESSAGE_TYPE_NEW_VERSION = "version";
	private static final String MESSAGE_TYPE_SERVER_MAINTENANCE = "maintenance";

	@Wire
	Textbox tbMessage;
	@Wire
	Radio rNotifKindMaintenance;
	@Wire
	Radio rNotifKindNewVersion;
	@Wire
	Radio rOsBoth;
	@Wire
	Radio rOsAndroid;
	@Wire
	Radio rOsIOs;

	@Listen("onClick=#btnSend")
	public void doPostMessage() {
		String message = tbMessage.getValue();
		try {
			if (message.isEmpty())
				Messagebox.show("Notification didn't send. Write some message.", "Information", Messagebox.OK, Messagebox.ERROR);
			else {
				if (rOsAndroid.isChecked() || rOsBoth.isChecked())
					if (rNotifKindMaintenance.isChecked())
						postAndroid(message, MESSAGE_TYPE_SERVER_MAINTENANCE);
					else
						postAndroid(message, MESSAGE_TYPE_NEW_VERSION);
				if (rOsIOs.isChecked() || rOsBoth.isChecked())
					if (rNotifKindMaintenance.isChecked())
						postIOs(message, MESSAGE_TYPE_SERVER_MAINTENANCE);
					else
						postIOs(message, MESSAGE_TYPE_NEW_VERSION);				
				Messagebox.show("Notification sent successfully.", "Information", Messagebox.OK, Messagebox.INFORMATION);
				tbMessage.setValue("");
			}
		} catch (RuntimeException e) {
			Messagebox.show("Notification didn't send. See log for detail information.", "Information", Messagebox.OK, Messagebox.ERROR);
			tbMessage.setValue("");
		}
	}
	
	private void postAndroid(String message, String messageTypeValue) {
		System.out.println( "Sending POST to GCM..." );
        Post2Gcm.post(message, messageTypeValue);
	}
	
	private void postIOs(String message, String messageTypeValue) {
		System.out.println( "Sending POST to APNS..." );
		Post2Apns.post(message, messageTypeValue);
	}

}
